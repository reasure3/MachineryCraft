package com.reasure.trasherymachines.setup;

import com.reasure.trasherymachines.TrasheryMachines;
import com.reasure.trasherymachines.item.DebugItem;
import com.reasure.trasherymachines.item.ModItemGroup;
import net.minecraft.world.item.Item;
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

    public static final RegistryObject<DebugItem> DEBUG_ITEM = ITEMS.register("debug_item", () ->
            new DebugItem(new Item.Properties().tab(ModItemGroup.MAIN_ITEM_GROUP)));

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
