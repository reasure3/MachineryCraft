package com.reasure.machinerycraft.datagen.client;

import com.reasure.machinerycraft.MachineryCraft;
import com.reasure.machinerycraft.setup.ModBlocks;
import com.reasure.machinerycraft.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    private final static ModelFile itemGenerated = new ModelFile.UncheckedModelFile("item/generated");
    private final static ModelFile itemHandheld = new ModelFile.UncheckedModelFile("item/handheld");

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MachineryCraft.MODID, existingFileHelper);
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

        build(ModItems.TIN_SWORD.getId().getPath(), itemHandheld);
        build(ModItems.TIN_SHOVEL.getId().getPath(), itemHandheld);
        build(ModItems.TIN_PICKAXE.getId().getPath(), itemHandheld);
        build(ModItems.TIN_AXE.getId().getPath(), itemHandheld);
        build(ModItems.TIN_HOE.getId().getPath(), itemHandheld);
        build(ModItems.LEAD_SWORD.getId().getPath(), itemHandheld);
        build(ModItems.LEAD_SHOVEL.getId().getPath(), itemHandheld);
        build(ModItems.LEAD_PICKAXE.getId().getPath(), itemHandheld);
        build(ModItems.LEAD_AXE.getId().getPath(), itemHandheld);
        build(ModItems.LEAD_HOE.getId().getPath(), itemHandheld);
        build(ModItems.SILVER_SWORD.getId().getPath(), itemHandheld);
        build(ModItems.SILVER_SHOVEL.getId().getPath(), itemHandheld);
        build(ModItems.SILVER_PICKAXE.getId().getPath(), itemHandheld);
        build(ModItems.SILVER_AXE.getId().getPath(), itemHandheld);
        build(ModItems.SILVER_HOE.getId().getPath(), itemHandheld);

        build(ModItems.LEAD_HELMET.getId().getPath(), itemGenerated);
        build(ModItems.LEAD_CHESTPLATE.getId().getPath(), itemGenerated);
        build(ModItems.LEAD_LEGGINGS.getId().getPath(), itemGenerated);
        build(ModItems.LEAD_BOOTS.getId().getPath(), itemGenerated);
        build(ModItems.SILVER_HELMET.getId().getPath(), itemGenerated);
        build(ModItems.SILVER_CHESTPLATE.getId().getPath(), itemGenerated);
        build(ModItems.SILVER_LEGGINGS.getId().getPath(), itemGenerated);
        build(ModItems.SILVER_BOOTS.getId().getPath(), itemGenerated);

        build(ModItems.SILVER_HORSE_ARMOR.getId().getPath(), itemGenerated);
    }

    private void block(String itemPath) {
        block(itemPath, itemPath);
    }

    private void block(String itemPath, String BlockPath) {
        withExistingParent(itemPath, modLoc("block/" + BlockPath));
    }

    private void build(String path, ModelFile parent) {
        getBuilder(path).parent(parent).texture("layer0", modLoc("item/" + path));
    }
}
