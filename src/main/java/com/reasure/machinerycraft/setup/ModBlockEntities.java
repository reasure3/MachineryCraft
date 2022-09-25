package com.reasure.machinerycraft.setup;

import com.reasure.machinerycraft.MachineryCraft;
import com.reasure.machinerycraft.block.entity.HeatGeneratorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MachineryCraft.MODID);

    public static final RegistryObject<BlockEntityType<HeatGeneratorBlockEntity>> HEAT_GENERATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("heat_generator_block_entity", () ->
            BlockEntityType.Builder.of(HeatGeneratorBlockEntity::new, ModBlocks.HEAT_GENERATOR.get()).build(null));

    public static void register(IEventBus modBus) {
        BLOCK_ENTITIES.register(modBus);
    }
}
