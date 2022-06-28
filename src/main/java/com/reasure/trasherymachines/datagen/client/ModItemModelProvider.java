package com.reasure.trasherymachines.datagen.client;

import com.reasure.trasherymachines.TrasheryMachines;
import com.reasure.trasherymachines.setup.ModBlocks;
import com.reasure.trasherymachines.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    private final ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
    private final ModelFile itemHandhelds = getExistingFile(mcLoc("item/handheld"));

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        block(ModBlocks.TIN_ORE.getId().getPath());
        block(ModBlocks.DEEPSLATE_TIN_ORE.getId().getPath());
        block(ModBlocks.RAW_TIN_BLOCK.getId().getPath());
        block(ModBlocks.TIN_BLOCK.getId().getPath());

        block(ModBlocks.LEAD_ORE.getId().getPath());
        block(ModBlocks.DEEPSLATE_LEAD_ORE.getId().getPath());
        block(ModBlocks.RAW_LEAD_BLOCK.getId().getPath());
        block(ModBlocks.LEAD_BLOCK.getId().getPath());

        block(ModBlocks.SILVER_ORE.getId().getPath());
        block(ModBlocks.DEEPSLATE_SILVER_ORE.getId().getPath());
        block(ModBlocks.RAW_SILVER_BLOCK.getId().getPath());
        block(ModBlocks.SILVER_BLOCK.getId().getPath());

        build(ModItems.RAW_TIN.getId().getPath(), itemGenerated);
        build(ModItems.TIN_INGOT.getId().getPath(), itemGenerated);
        build(ModItems.TIN_NUGGET.getId().getPath(), itemGenerated);

        build(ModItems.RAW_LEAD.getId().getPath(), itemGenerated);
        build(ModItems.LEAD_INGOT.getId().getPath(), itemGenerated);
        build(ModItems.LEAD_NUGGET.getId().getPath(), itemGenerated);

        build(ModItems.RAW_SILVER.getId().getPath(), itemGenerated);
        build(ModItems.SILVER_INGOT.getId().getPath(), itemGenerated);
        build(ModItems.SILVER_NUGGET.getId().getPath(), itemGenerated);

    }

    private void block(String itemPath) {
        block(itemPath, itemPath);
    }

    private void block(String itemPath, String BlockPath) {
        withExistingParent(itemPath, modLoc("block/" + BlockPath));
    }

    private void build(String path, ModelFile parent) {
        getBuilder(path).parent(parent).texture("layer0", "item/" + path);
    }
}
