package com.reasure.machinerycraft.item;

import com.reasure.machinerycraft.setup.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModItemGroup {
    public static final String MAIN_TAB_NAME = "machinery_craft";

    public static final CreativeModeTab MAIN_ITEM_GROUP = new CreativeModeTab(MAIN_TAB_NAME) {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SILVER_INGOT.get());
        }
    };
}
