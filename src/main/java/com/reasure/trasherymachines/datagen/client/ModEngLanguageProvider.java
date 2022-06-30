package com.reasure.trasherymachines.datagen.client;

import com.reasure.trasherymachines.item.ModItemGroup;
import com.reasure.trasherymachines.setup.ModBlocks;
import com.reasure.trasherymachines.setup.ModItems;
import net.minecraft.data.DataGenerator;

public class ModEngLanguageProvider extends BaseLanguageProvider {
    public ModEngLanguageProvider(DataGenerator generator) {
        super(generator, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModItemGroup.MAIN_TAB_NAME, "Trashery Machines");

        addItems();
        addBlocks();
    }

    private void addItems() {
        add(ModItems.RAW_TIN.get(), "Raw Tin");
        add(ModItems.TIN_INGOT.get(), "Tin Ingot");
        add(ModItems.TIN_NUGGET.get(), "Tin Nugget");

        add(ModItems.RAW_LEAD.get(), "Raw Lead");
        add(ModItems.LEAD_INGOT.get(), "Lead Ingot");
        add(ModItems.LEAD_NUGGET.get(), "Lead Nugget");

        add(ModItems.RAW_SILVER.get(), "Raw Silver");
        add(ModItems.SILVER_INGOT.get(), "Silver Ingot");
        add(ModItems.SILVER_NUGGET.get(), "Silver Nugget");

        add(ModItems.TIN_SWORD.get(), "Tin Sword");
        add(ModItems.TIN_SHOVEL.get(), "Tin Shovel");
        add(ModItems.TIN_PICKAXE.get(), "Tin Pickaxe");
        add(ModItems.TIN_AXE.get(), "Tin Axe");
        add(ModItems.TIN_HOE.get(), "Tin Hoe");
        add(ModItems.LEAD_SWORD.get(), "Lead Sword");
        add(ModItems.LEAD_SHOVEL.get(), "Lead Shovel");
        add(ModItems.LEAD_PICKAXE.get(), "Lead Pickaxe");
        add(ModItems.LEAD_AXE.get(), "Lead Axe");
        add(ModItems.LEAD_HOE.get(), "Lead Hoe");
        add(ModItems.SILVER_SWORD.get(), "Silver Sword");
        add(ModItems.SILVER_SHOVEL.get(), "Silver Shovel");
        add(ModItems.SILVER_PICKAXE.get(), "Silver Pickaxe");
        add(ModItems.SILVER_AXE.get(), "Silver Axe");
        add(ModItems.SILVER_HOE.get(), "Silver Hoe");
    }

    private void addBlocks() {
        add(ModBlocks.TIN_ORE.get(), "Tin Ore");
        add(ModBlocks.DEEPSLATE_TIN_ORE.get(), "Deepslate Tin Ore");
        add(ModBlocks.RAW_TIN_BLOCK.get(), "Raw Tin Block");
        add(ModBlocks.TIN_BLOCK.get(), "Tin Block");

        add(ModBlocks.LEAD_ORE.get(), "Lead Ore");
        add(ModBlocks.DEEPSLATE_LEAD_ORE.get(), "Deepslate Lead Ore");
        add(ModBlocks.RAW_LEAD_BLOCK.get(), "Raw Lead Block");
        add(ModBlocks.LEAD_BLOCK.get(), "Lead Block");

        add(ModBlocks.SILVER_ORE.get(), "Silver Ore");
        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(), "Deepslate Silver Ore");
        add(ModBlocks.RAW_SILVER_BLOCK.get(), "Raw Silver Block");
        add(ModBlocks.SILVER_BLOCK.get(), "Silver Block");
    }
}
