package com.reasure.trasherymachines.setup;

import com.reasure.trasherymachines.TrasheryMachines;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static void init() {
        Blocks.init();
        Items.init();
    }

    public static final class Blocks {
        private static void init() {}

        public static final TagKey<Block> ORES_TIN = forgeTag("ores/tin");
        public static final TagKey<Block> ORES_LEAD = forgeTag("ores/lead");
        public static final TagKey<Block> ORES_SILVER = forgeTag("ores/silver");

        public static final TagKey<Block> STORAGE_BLOCKS_RAW_TIN = forgeTag("storage_blocks/raw_tin");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = forgeTag("storage_blocks/raw_lead");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILVER = forgeTag("storage_blocks/raw_silver");

        public static final TagKey<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final TagKey<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final TagKey<Block> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        private static TagKey<Block> modTag(String name) {
            return BlockTags.create(new ResourceLocation(TrasheryMachines.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static final class Items {
        private static void init() {}

        public static final TagKey<Item> ORES_TIN = forgeTag("ores/tin");
        public static final TagKey<Item> ORES_LEAD = forgeTag("ores/lead");
        public static final TagKey<Item> ORES_SILVER = forgeTag("ores/silver");

        public static final TagKey<Item> STORAGE_BLOCKS_RAW_TIN = forgeTag("storage_blocks/raw_tin");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = forgeTag("storage_blocks/raw_lead");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILVER = forgeTag("storage_blocks/raw_silver");

        public static final TagKey<Item> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final TagKey<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final TagKey<Item> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final TagKey<Item> RAW_MATERIALS_TIN = forgeTag("raw_materials/tin");
        public static final TagKey<Item> RAW_MATERIALS_LEAD = forgeTag("raw_materials/lead");
        public static final TagKey<Item> RAW_MATERIALS_SILVER = forgeTag("raw_materials/silver");

        public static final TagKey<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final TagKey<Item> INGOTS_LEAD = forgeTag("ingots/lead");
        public static final TagKey<Item> INGOTS_SILVER = forgeTag("ingots/silver");

        public static final TagKey<Item> NUGGETS_TIN = forgeTag("nuggets/tin");
        public static final TagKey<Item> NUGGETS_LEAD = forgeTag("nuggets/lead");
        public static final TagKey<Item> NUGGETS_SILVER = forgeTag("nuggets/silver");

        private static TagKey<Item> modTag(String name) {
            return ItemTags.create(new ResourceLocation(TrasheryMachines.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
