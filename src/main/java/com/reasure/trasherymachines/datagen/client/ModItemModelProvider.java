package com.reasure.trasherymachines.datagen.client;

import com.reasure.trasherymachines.TrasheryMachines;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    private final ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
    private final ModelFile itemHandhelds = getExistingFile(mcLoc("item/handheld"));

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TrasheryMachines.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    private void block(String itemPath) {
        block(itemPath, itemPath);
    }

    private void block(String itemPath, String BlockPath) {
        withExistingParent(itemPath, modLoc("block/" + BlockPath));
    }

    private void build(String path, ModelFile parent) {
        getBuilder(path).parent(parent).texture("layer0", "item/" + path);
    }
}
