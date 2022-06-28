package com.reasure.trasherymachines.datagen.client;

import com.reasure.trasherymachines.item.ModItemGroup;
import com.reasure.trasherymachines.setup.ModBlocks;
import com.reasure.trasherymachines.setup.ModItems;
import net.minecraft.data.DataGenerator;

public class ModKorLanguageProvider extends BaseLanguageProvider {
    public ModKorLanguageProvider(DataGenerator generator) {
        super(generator, "ko_kr");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModItemGroup.MAIN_TAB_NAME, "잡다한 기계들");

        addItems();
        addBlocks();
    }

    private void addItems() {
        add(ModItems.RAW_TIN.get(), "주석 원석");
        add(ModItems.TIN_INGOT.get(), "주석 주괴");
        add(ModItems.TIN_NUGGET.get(), "주석 조각");

        add(ModItems.RAW_LEAD.get(), "납 원석");
        add(ModItems.LEAD_INGOT.get(), "납 주괴");
        add(ModItems.LEAD_NUGGET.get(), "납 조각");

        add(ModItems.RAW_SILVER.get(), "은 원석");
        add(ModItems.SILVER_INGOT.get(), "은 주괴");
        add(ModItems.SILVER_NUGGET.get(), "은 조각");
    }

    private void addBlocks() {
        add(ModBlocks.TIN_ORE.get(), "주석 광석");
        add(ModBlocks.DEEPSLATE_TIN_ORE.get(), "심층암 주석 광석");
        add(ModBlocks.RAW_TIN_BLOCK.get(), "주석 원석 블록");
        add(ModBlocks.TIN_BLOCK.get(), "주석 블록");

        add(ModBlocks.LEAD_ORE.get(), "납 광석");
        add(ModBlocks.DEEPSLATE_LEAD_ORE.get(), "심층암 납 광석");
        add(ModBlocks.RAW_LEAD_BLOCK.get(), "납 원석 블록");
        add(ModBlocks.LEAD_BLOCK.get(), "납 블록");

        add(ModBlocks.SILVER_ORE.get(), "은 광석");
        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(), "심층암 은 광석");
        add(ModBlocks.RAW_SILVER_BLOCK.get(), "은 원석 블록");
        add(ModBlocks.SILVER_BLOCK.get(), "은 블록");
    }
}
