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

        add(ModItems.TIN_SWORD.get(), "주석 검");
        add(ModItems.TIN_SHOVEL.get(), "주석 삽");
        add(ModItems.TIN_PICKAXE.get(), "주석 곡괭이");
        add(ModItems.TIN_AXE.get(), "주석 도끼");
        add(ModItems.TIN_HOE.get(), "주석 괭이");
        add(ModItems.LEAD_SWORD.get(), "납 검");
        add(ModItems.LEAD_SHOVEL.get(), "납 삽");
        add(ModItems.LEAD_PICKAXE.get(), "납 곡괭이");
        add(ModItems.LEAD_AXE.get(), "납 도끼");
        add(ModItems.LEAD_HOE.get(), "납 괭이");
        add(ModItems.SILVER_SWORD.get(), "은 검");
        add(ModItems.SILVER_SHOVEL.get(), "은 삽");
        add(ModItems.SILVER_PICKAXE.get(), "은 곡괭이");
        add(ModItems.SILVER_AXE.get(), "은 도끼");
        add(ModItems.SILVER_HOE.get(), "은 괭이");
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

        add(ModItems.LEAD_HELMET.get(), "납 투구");
        add(ModItems.LEAD_CHESTPLATE.get(), "납 흉갑");
        add(ModItems.LEAD_LEGGINGS.get(), "납 레깅스");
        add(ModItems.LEAD_BOOTS.get(), "납 부츠");
        add(ModItems.SILVER_HELMET.get(), "은 투구");
        add(ModItems.SILVER_CHESTPLATE.get(), "은 흉갑");
        add(ModItems.SILVER_LEGGINGS.get(), "은 레깅스");
        add(ModItems.SILVER_BOOTS.get(), "은 부츠");

        add(ModItems.SILVER_HORSE_ARMOR.get(), "은 말 갑옷");
    }
}
