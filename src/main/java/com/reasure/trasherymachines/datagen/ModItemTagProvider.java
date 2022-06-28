package com.reasure.trasherymachines.datagen;

import com.reasure.trasherymachines.TrasheryMachines;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }

    @NotNull
    @Override
    public String getName() {
        return "Item Tags: " + modId;
    }
}
