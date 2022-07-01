package com.reasure.trasherymachines.datagen;

import com.reasure.trasherymachines.TrasheryMachines;
import com.reasure.trasherymachines.setup.ModBlocks;
import com.reasure.trasherymachines.setup.ModItems;
import com.reasure.trasherymachines.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        oreCooking(consumer, ModTags.Items.ORES_TIN, ModItems.TIN_INGOT.get(), 0.5f, 200, "tin_ingot");
        oreCooking(consumer, ModTags.Items.RAW_MATERIALS_TIN, ModItems.TIN_INGOT.get(), 0.5f, 200, "tin_ingot");
        oreCooking(consumer, ModTags.Items.ORES_LEAD, ModItems.LEAD_INGOT.get(), 0.7f, 200, "lead_ingot");
        oreCooking(consumer, ModTags.Items.RAW_MATERIALS_LEAD, ModItems.LEAD_INGOT.get(), 0.7f, 200, "lead_ingot");
        oreCooking(consumer, ModTags.Items.ORES_SILVER, ModItems.SILVER_INGOT.get(), 0.9f, 200, "silver_ingot");
        oreCooking(consumer, ModTags.Items.RAW_MATERIALS_SILVER, ModItems.SILVER_INGOT.get(), 0.9f, 200, "silver_ingot");

        ninePackingWithGroup(consumer, ModTags.Items.NUGGETS_TIN, ModItems.TIN_INGOT.get(), "tin_ingot");
        unpackingWithGroup(consumer, ModTags.Items.INGOTS_TIN, ModItems.TIN_NUGGET.get(), 9, "tin_nugget");
        ninePacking(consumer, ModTags.Items.INGOTS_TIN, ModBlocks.TIN_BLOCK.get());
        unpackingWithGroup(consumer, ModTags.Items.STORAGE_BLOCKS_TIN, ModItems.TIN_INGOT.get(), 9, "tin_ingot");
        ninePacking(consumer, ModTags.Items.RAW_MATERIALS_TIN, ModBlocks.RAW_TIN_BLOCK.get());
        unpacking(consumer, ModTags.Items.STORAGE_BLOCKS_RAW_TIN, ModItems.RAW_TIN.get(), 9);

        ninePackingWithGroup(consumer, ModTags.Items.NUGGETS_LEAD, ModItems.LEAD_INGOT.get(), "lead_ingot");
        unpackingWithGroup(consumer, ModTags.Items.INGOTS_LEAD, ModItems.LEAD_NUGGET.get(), 9, "lead_nugget");
        ninePacking(consumer, ModTags.Items.INGOTS_LEAD, ModBlocks.LEAD_BLOCK.get());
        unpackingWithGroup(consumer, ModTags.Items.STORAGE_BLOCKS_LEAD, ModItems.LEAD_INGOT.get(), 9, "lead_ingot");
        ninePacking(consumer, ModTags.Items.RAW_MATERIALS_LEAD, ModBlocks.RAW_LEAD_BLOCK.get());
        unpacking(consumer, ModTags.Items.STORAGE_BLOCKS_RAW_LEAD, ModItems.RAW_LEAD.get(), 9);

        ninePackingWithGroup(consumer, ModTags.Items.NUGGETS_SILVER, ModItems.SILVER_INGOT.get(), "silver_ingot");
        unpackingWithGroup(consumer, ModTags.Items.INGOTS_SILVER, ModItems.SILVER_NUGGET.get(), 9, "silver_nugget");
        ninePacking(consumer, ModTags.Items.INGOTS_SILVER, ModBlocks.SILVER_BLOCK.get());
        unpackingWithGroup(consumer, ModTags.Items.STORAGE_BLOCKS_SILVER, ModItems.SILVER_INGOT.get(), 9, "silver_ingot");
        ninePacking(consumer, ModTags.Items.RAW_MATERIALS_SILVER, ModBlocks.RAW_SILVER_BLOCK.get());
        unpacking(consumer, ModTags.Items.STORAGE_BLOCKS_RAW_SILVER, ModItems.RAW_SILVER.get(), 9);

        tools(consumer, ModTags.Items.INGOTS_TIN, ModItems.TIN_SWORD.get(), ModItems.TIN_SHOVEL.get(), ModItems.TIN_PICKAXE.get(), ModItems.TIN_AXE.get(), ModItems.TIN_HOE.get());
        tools(consumer, ModTags.Items.INGOTS_LEAD, ModItems.LEAD_SWORD.get(), ModItems.LEAD_SHOVEL.get(), ModItems.LEAD_PICKAXE.get(), ModItems.LEAD_AXE.get(), ModItems.LEAD_HOE.get());
        tools(consumer, ModTags.Items.INGOTS_SILVER, ModItems.SILVER_SWORD.get(), ModItems.SILVER_SHOVEL.get(), ModItems.SILVER_PICKAXE.get(), ModItems.SILVER_AXE.get(), ModItems.SILVER_HOE.get());

        armors(consumer, ModTags.Items.INGOTS_LEAD, ModItems.LEAD_HELMET.get(), ModItems.LEAD_CHESTPLATE.get(), ModItems.LEAD_LEGGINGS.get(), ModItems.LEAD_BOOTS.get());
        armors(consumer, ModTags.Items.INGOTS_SILVER, ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get());
    }

    private void oreCooking(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result, float experience, int cookingTime, String group) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredients), result, experience, cookingTime).group(group).unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer, modLoc(getItemName(result) + "_from_smelting_" + getTagName(ingredients)));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredients), result, experience, cookingTime / 2).group(group).unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer, modLoc(getItemName(result) + "_from_blasting_" + getTagName(ingredients)));
    }

    private void ninePacking(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result) {
        ninePacking(consumer, ingredients, result, getItemName(result), null);
    }

    private void ninePackingWithGroup(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result, String group) {
        ninePacking(consumer, ingredients, result, getItemName(result) + "_from_" + getTagName(ingredients), group);
    }

    private void ninePacking(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result, String recipeName, String group) {
        ShapedRecipeBuilder.shaped(result).group(group)
                .define('#', ingredients)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer, modLoc(recipeName));
    }

    private void unpacking(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result, int resulCount) {
        unpacking(consumer, ingredients, result, resulCount, getItemName(result), null);
    }

    private void unpackingWithGroup(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result, int resultCount, String group) {
        unpacking(consumer, ingredients, result, resultCount, getItemName(result) + "from_" + getTagName(ingredients), group);
    }

    private void unpacking(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike result, int resultCount, String recipeName, @Nullable String group) {
        ShapelessRecipeBuilder.shapeless(result, resultCount).requires(ingredients).group(group).unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer, modLoc(recipeName));
    }

    private void sword(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike sword) {
        ShapedRecipeBuilder.shaped(sword)
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', ingredients)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void shovel(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike shovel) {
        ShapedRecipeBuilder.shaped(shovel)
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', ingredients)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void pickaxe(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike pickaxe) {
        ShapedRecipeBuilder.shaped(pickaxe)
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', ingredients)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void axe(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike axe) {
        ShapedRecipeBuilder.shaped(axe)
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', ingredients)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void hoe(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike hoe) {
        ShapedRecipeBuilder.shaped(hoe)
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', ingredients)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void tools(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients,
                       @Nullable ItemLike sword, @Nullable ItemLike shovel, @Nullable ItemLike pickaxe, @Nullable ItemLike axe, @Nullable ItemLike hoe) {
        if (sword != null) sword(consumer, ingredients, sword);
        if (shovel != null) shovel(consumer, ingredients, shovel);
        if (pickaxe != null) pickaxe(consumer, ingredients, pickaxe);
        if (axe != null) axe(consumer, ingredients, axe);
        if (hoe != null) hoe(consumer, ingredients, hoe);
    }

    private void helmet(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike helmet) {
        ShapedRecipeBuilder.shaped(helmet)
                .define('X', ingredients)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void chestplate(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike chestplate) {
        ShapedRecipeBuilder.shaped(chestplate)
                .define('X', ingredients)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void leggings(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike leggings) {
        ShapedRecipeBuilder.shaped(leggings)
                .define('X', ingredients)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void boots(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients, ItemLike boots) {
        ShapedRecipeBuilder.shaped(boots)
                .define('X', ingredients)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(getHasName(ingredients), has(ingredients))
                .save(consumer);
    }

    private void armors(Consumer<FinishedRecipe> consumer, TagKey<Item> ingredients,
                        @Nullable ItemLike helmet, @Nullable ItemLike chestplate, @Nullable ItemLike leggings, @Nullable ItemLike boots) {
        if (helmet != null) helmet(consumer, ingredients, helmet);
        if (chestplate != null) chestplate(consumer, ingredients, chestplate);
        if (leggings != null) leggings(consumer, ingredients, leggings);
        if (boots != null) boots(consumer, ingredients, boots);
    }

    private ResourceLocation modLoc(String path) {
        return new ResourceLocation(TrasheryMachines.MODID, path);
    }

    private String getTagName(TagKey<Item> tag) {
        return tag.location().getPath().replace('/', '_');
    }

    private String getHasName(TagKey<Item> tag) {
        return "has_" + getTagName(tag);
    }
}
