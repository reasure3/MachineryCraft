package com.reasure.trasherymachines.datagen.client;

import com.reasure.trasherymachines.TrasheryMachines;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
