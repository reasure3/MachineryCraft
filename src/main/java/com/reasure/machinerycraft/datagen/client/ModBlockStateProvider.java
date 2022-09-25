package com.reasure.machinerycraft.datagen.client;

import com.reasure.machinerycraft.MachineryCraft;
import com.reasure.machinerycraft.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MachineryCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TIN_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE.get());
        simpleBlock(ModBlocks.RAW_TIN_BLOCK.get());
        simpleBlock(ModBlocks.TIN_BLOCK.get());

        simpleBlock(ModBlocks.LEAD_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        simpleBlock(ModBlocks.RAW_LEAD_BLOCK.get());
        simpleBlock(ModBlocks.LEAD_BLOCK.get());

        simpleBlock(ModBlocks.SILVER_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        simpleBlock(ModBlocks.RAW_SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_BLOCK.get());
    }
}
