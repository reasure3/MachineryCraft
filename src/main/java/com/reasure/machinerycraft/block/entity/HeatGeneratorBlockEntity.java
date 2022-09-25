package com.reasure.machinerycraft.block.entity;

import com.reasure.machinerycraft.block.ModBlockStateProperties;
import com.reasure.machinerycraft.capability.CustomEnergyStorage;
import com.reasure.machinerycraft.setup.ModBlockEntities;
import com.reasure.machinerycraft.util.TranslationKeys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicInteger;

public class HeatGeneratorBlockEntity extends BlockEntity implements MenuProvider {
    public static final int HEAT_GENERATOR_CAPACITY = 50000; // Max capacity
    public static final int HEAT_GENERATOR_GENERATE = 60;    // Generation per tick
    public static final int HEAT_GENERATOR_SEND = 200;       // Power to send out per tick

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> inventory = LazyOptional.of(() -> itemHandler);

    private final CustomEnergyStorage energyStorage = createEnergy();
    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    // burnProgress = remainBurningTime / burningDuration
    private int remainBurningTime = 0;
    private int burningDuration = 0;

    public HeatGeneratorBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntities.HEAT_GENERATOR_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    public void tickServer() {
        if (level == null) return;

        if (isGenerating()) {
            energyStorage.addEnergy(HEAT_GENERATOR_GENERATE);
            remainBurningTime--;
            setChanged();
        }

        if (remainBurningTime <= 0) {
            ItemStack stack = itemHandler.getStackInSlot(0);
            int burnTime = ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
            if (burnTime > 0) {
                itemHandler.extractItem(0, 1, false);
                remainBurningTime = burnTime;
                burningDuration = burnTime;
                setChanged();
            } else if (burningDuration > 0) {
                burningDuration = 0;
                setChanged();
            }
        }

        BlockState blockState = level.getBlockState(worldPosition);
        boolean on = isGenerating();
        if (blockState.getValue(ModBlockStateProperties.ON) != on) {
            level.setBlock(worldPosition, blockState.setValue(ModBlockStateProperties.ON, on), Block.UPDATE_ALL);
        }

        sendOutPower();
    }

    private void sendOutPower() {
        if (level == null) return;

        AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
        if (capacity.get() > 0) {
            for (Direction direction : Direction.values()) {
                BlockEntity be = level.getBlockEntity(worldPosition.relative(direction));
                if (be != null) {
                    boolean doContinue = be.getCapability(CapabilityEnergy.ENERGY, direction.getOpposite()).map(handler -> {
                                if (handler.canReceive()) {
                                    int received = handler.receiveEnergy(Math.min(capacity.get(), HEAT_GENERATOR_SEND), false);
                                    capacity.addAndGet(-received);
                                    energyStorage.consumeEnergy(received);
                                    setChanged();
                                    return capacity.get() > 0;
                                } else {
                                    return true;
                                }
                            }
                    ).orElse(true);
                    if (!doContinue) {
                        return;
                    }
                }
            }
        }
    }

    public boolean isGenerating() {
        return remainBurningTime > 0 && energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored();
    }

    @Override
    public void load(CompoundTag tag) {
        if (tag.contains("Inventory")) {
            itemHandler.deserializeNBT(tag.getCompound("Inventory"));
        }
        if (tag.contains("Energy")) {
            energyStorage.deserializeNBT(tag.get("Energy"));
        }
        if (tag.contains("Info")) {
            CompoundTag infoTag = tag.getCompound("Info");
            remainBurningTime = infoTag.getInt("RemainBurningTimes");
            burningDuration = infoTag.getCompound("Info").getInt("BurningDuration");
        }
        super.load(tag);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.put("Inventory", itemHandler.serializeNBT());
        tag.put("Energy", energyStorage.serializeNBT());

        CompoundTag infoTag = new CompoundTag();
        infoTag.putInt("RemainBurningTime", remainBurningTime);
        infoTag.putInt("BurningDuration", burningDuration);
        tag.put("Info", infoTag);
    }

    public void dropContents() {
        if (level != null) {
            SimpleContainer container = new SimpleContainer(itemHandler.getSlots());
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                container.setItem(i, itemHandler.getStackInSlot(i));
            }
            Containers.dropContents(level, worldPosition, container);
        }
    }

    @NotNull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(TranslationKeys.SCREEN_HEAT_GENERATOR);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return null;
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(1) {

            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) <= 0) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    private CustomEnergyStorage createEnergy() {
        return new CustomEnergyStorage(HEAT_GENERATOR_CAPACITY, 0) {
            @Override
            protected void onEnergyChanged() {
                setChanged();
            }
        };
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return inventory.cast();
        } else if (cap == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inventory.invalidate();
        energy.invalidate();
    }
}
