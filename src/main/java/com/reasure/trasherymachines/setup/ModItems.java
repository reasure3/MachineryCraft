package com.reasure.trasherymachines.setup;

import com.reasure.trasherymachines.TrasheryMachines;
import com.reasure.trasherymachines.item.DebugItem;
import com.reasure.trasherymachines.item.ModItemGroup;
import com.reasure.trasherymachines.item.ModTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TrasheryMachines.MODID);

    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () ->
            new Item(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_SWORD = ITEMS.register("tin_sword", () ->
            new SwordItem(ModTiers.TIN, 3, -2.4f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_SHOVEL = ITEMS.register("tin_shovel", () ->
            new ShovelItem(ModTiers.TIN, 1.5f, -3.0f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_PICKAXE = ITEMS.register("tin_pickaxe", () ->
            new PickaxeItem(ModTiers.TIN, 1, -2.8f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_AXE = ITEMS.register("tin_axe", () ->
            new AxeItem(ModTiers.TIN, 6.5f, -3.2f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> TIN_HOE = ITEMS.register("tin_hoe", () ->
            new HoeItem(ModTiers.TIN, -1, -3.0f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_SWORD = ITEMS.register("lead_sword", () ->
            new SwordItem(ModTiers.LEAD, 3, -2.4f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_SHOVEL = ITEMS.register("lead_shovel", () ->
            new ShovelItem(ModTiers.LEAD, 1.5f, -3.0f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_PICKAXE = ITEMS.register("lead_pickaxe", () ->
            new PickaxeItem(ModTiers.LEAD, 1, -2.8f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_AXE = ITEMS.register("lead_axe", () ->
            new AxeItem(ModTiers.LEAD, 6.0f, -3.1f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> LEAD_HOE = ITEMS.register("lead_hoe", () ->
            new HoeItem(ModTiers.LEAD, -2, -1.0f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () ->
            new SwordItem(ModTiers.SILVER, 3, -2.4f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () ->
            new ShovelItem(ModTiers.SILVER, 1.5f, -3.0f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () ->
            new PickaxeItem(ModTiers.SILVER, 1, -2.8f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () ->
            new AxeItem(ModTiers.SILVER, 5.7f, -3.1f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () ->
            new HoeItem(ModTiers.SILVER, -2, -0.5f,
                    new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static final RegistryObject<Item> DEBUG_ITEM = ITEMS.register("debug_item", () ->
            new DebugItem(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
