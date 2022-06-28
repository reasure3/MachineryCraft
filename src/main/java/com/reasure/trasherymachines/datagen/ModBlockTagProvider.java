package com.reasure.trasherymachines.datagen;

import com.reasure.trasherymachines.TrasheryMachines;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }

    @NotNull
    @Override
    public String getName() {
        return "Block Tags: " + modId;
    }
}
