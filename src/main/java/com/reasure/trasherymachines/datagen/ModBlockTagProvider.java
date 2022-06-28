package com.reasure.trasherymachines.datagen;

import com.reasure.trasherymachines.TrasheryMachines;
import com.reasure.trasherymachines.setup.ModBlocks;
import com.reasure.trasherymachines.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(ModTags.Blocks.ORES_TIN)
                .addTag(ModTags.Blocks.ORES_LEAD)
                .addTag(ModTags.Blocks.ORES_SILVER)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_TIN)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_SILVER)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_TIN)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_LEAD)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER)
        ;
        tag(BlockTags.NEEDS_STONE_TOOL)
                .addTag(ModTags.Blocks.ORES_TIN)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_TIN)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_TIN)
        ;
        tag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(ModTags.Blocks.ORES_LEAD)
                .addTag(ModTags.Blocks.ORES_SILVER)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_SILVER)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_LEAD)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER)
        ;

        tag(Tags.Blocks.ORES)
                .addTag(ModTags.Blocks.ORES_TIN)
                .addTag(ModTags.Blocks.ORES_LEAD)
                .addTag(ModTags.Blocks.ORES_SILVER)
        ;
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_TIN)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_SILVER)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_TIN)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_LEAD)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER)
        ;
        tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
        ;
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
        ;

        tag(ModTags.Blocks.ORES_TIN).add(ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get());
        tag(ModTags.Blocks.ORES_LEAD).add(ModBlocks.LEAD_ORE.get(), ModBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get(), ModBlocks.DEEPSLATE_SILVER_ORE.get());

        tag(ModTags.Blocks.STORAGE_BLOCKS_RAW_TIN).add(ModBlocks.RAW_TIN_BLOCK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_RAW_LEAD).add(ModBlocks.RAW_LEAD_BLOCK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_RAW_SILVER).add(ModBlocks.RAW_SILVER_BLOCK.get());

        tag(ModTags.Blocks.STORAGE_BLOCKS_TIN).add(ModBlocks.TIN_BLOCK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_LEAD).add(ModBlocks.LEAD_BLOCK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModBlocks.SILVER_BLOCK.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Block Tags: " + modId;
    }
}
