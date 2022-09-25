package com.reasure.machinerycraft.setup;

import com.reasure.machinerycraft.MachineryCraft;
import com.reasure.machinerycraft.block.custom.HeatGeneratorBlock;
import com.reasure.machinerycraft.item.ModItemGroup;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MachineryCraft.MODID);

    public static final RegistryObject<Block> TIN_ORE = register("tin_ore", () ->
            new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", () ->
            new OreBlock(BlockBehaviour.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RAW_TIN_BLOCK = register("raw_tin_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(3.0f, 6.0f)));

    public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(4.0f, 6.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> LEAD_ORE = register("lead_ore", () ->
            new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));

    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", () ->
            new OreBlock(BlockBehaviour.Properties.copy(LEAD_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RAW_LEAD_BLOCK = register("raw_lead_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));

    public static final RegistryObject<Block> LEAD_BLOCK = register("lead_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () ->
            new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", () ->
            new OreBlock(BlockBehaviour.Properties.copy(SILVER_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RAW_SILVER_BLOCK = register("raw_silver_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));

    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> HEAT_GENERATOR = register("heat_generator", () ->
            new HeatGeneratorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE)
                    .requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).lightLevel(machineBlockEmission(13))));

    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<? extends T> block) {
        RegistryObject<T> obj = registerBlock(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(obj.get(), new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));
        return obj;
    }

    private static ToIntFunction<BlockState> machineBlockEmission(int lightValue) {
        return state -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
}
