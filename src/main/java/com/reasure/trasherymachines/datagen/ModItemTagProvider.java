package com.reasure.trasherymachines.datagen;

import com.reasure.trasherymachines.TrasheryMachines;
import com.reasure.trasherymachines.setup.ModItems;
import com.reasure.trasherymachines.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);

        copy(ModTags.Blocks.ORES_TIN, ModTags.Items.ORES_TIN);
        copy(ModTags.Blocks.ORES_LEAD, ModTags.Items.ORES_LEAD);
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);

        copy(ModTags.Blocks.STORAGE_BLOCKS_RAW_TIN, ModTags.Items.STORAGE_BLOCKS_RAW_TIN);
        copy(ModTags.Blocks.STORAGE_BLOCKS_RAW_LEAD, ModTags.Items.STORAGE_BLOCKS_RAW_LEAD);
        copy(ModTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, ModTags.Items.STORAGE_BLOCKS_RAW_SILVER);

        copy(ModTags.Blocks.STORAGE_BLOCKS_TIN, ModTags.Items.STORAGE_BLOCKS_TIN);
        copy(ModTags.Blocks.STORAGE_BLOCKS_LEAD, ModTags.Items.STORAGE_BLOCKS_LEAD);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);

        tag(Tags.Items.RAW_MATERIALS)
                .addTag(ModTags.Items.RAW_MATERIALS_TIN)
                .addTag(ModTags.Items.RAW_MATERIALS_LEAD)
                .addTag(ModTags.Items.RAW_MATERIALS_SILVER)
        ;
        tag(Tags.Items.INGOTS)
                .addTag(ModTags.Items.INGOTS_TIN)
                .addTag(ModTags.Items.INGOTS_LEAD)
                .addTag(ModTags.Items.INGOTS_SILVER)
        ;
        tag(Tags.Items.NUGGETS)
                .addTag(ModTags.Items.NUGGETS_TIN)
                .addTag(ModTags.Items.NUGGETS_LEAD)
                .addTag(ModTags.Items.NUGGETS_SILVER)
        ;

        tag(ModTags.Items.RAW_MATERIALS_TIN).add(ModItems.RAW_TIN.get());
        tag(ModTags.Items.RAW_MATERIALS_LEAD).add(ModItems.RAW_LEAD.get());
        tag(ModTags.Items.RAW_MATERIALS_SILVER).add(ModItems.RAW_SILVER.get());

        tag(ModTags.Items.INGOTS_TIN).add(ModItems.TIN_INGOT.get());
        tag(ModTags.Items.INGOTS_LEAD).add(ModItems.LEAD_INGOT.get());
        tag(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());

        tag(ModTags.Items.NUGGETS_TIN).add(ModItems.TIN_NUGGET.get());
        tag(ModTags.Items.NUGGETS_LEAD).add(ModItems.LEAD_NUGGET.get());
        tag(ModTags.Items.NUGGETS_SILVER).add(ModItems.SILVER_NUGGET.get());
    }

    @NotNull
    @Override
    public String getName() {
        return "Item Tags: " + modId;
    }
}
