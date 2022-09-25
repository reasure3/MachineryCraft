package com.reasure.machinerycraft.item;

import com.reasure.machinerycraft.MachineryCraft;
import com.reasure.machinerycraft.setup.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier TIN = TierSortingRegistry.registerTier(
            new ForgeTier(1, 178, 5.0f, 1.5f, 10,
                    ModTags.Blocks.NEEDS_TIN_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_TIN)),
            new ResourceLocation(MachineryCraft.MODID, "tin"),
            List.of(Tiers.STONE), List.of(Tiers.IRON)
    );

    public static final Tier LEAD = TierSortingRegistry.registerTier(
            new ForgeTier(2, 250, 6.0f, 2.0f, 14,
                    ModTags.Blocks.NEEDS_LEAD_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_LEAD)),
            new ResourceLocation(MachineryCraft.MODID, "lead"),
            List.of(Tiers.IRON), List.of()
    );

    public static final Tier SILVER = TierSortingRegistry.registerTier(
            new ForgeTier(2, 190, 7.0f, 2.3f, 24,
                    ModTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_SILVER)),
            new ResourceLocation(MachineryCraft.MODID, "silver"),
            List.of(Tiers.IRON, ModTiers.LEAD), List.of(Tiers.DIAMOND)
    );

    public static void register() {}
}
