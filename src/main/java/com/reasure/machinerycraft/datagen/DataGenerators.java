package com.reasure.machinerycraft.datagen;

import com.reasure.machinerycraft.MachineryCraft;
import com.reasure.machinerycraft.datagen.client.ModBlockStateProvider;
import com.reasure.machinerycraft.datagen.client.ModEngLanguageProvider;
import com.reasure.machinerycraft.datagen.client.ModItemModelProvider;
import com.reasure.machinerycraft.datagen.client.ModKorLanguageProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MachineryCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(generator, helper);
            generator.addProvider(blockTagProvider);
            generator.addProvider(new ModItemTagProvider(generator, blockTagProvider, helper));
            generator.addProvider(new ModRecipeProvider(generator));
            generator.addProvider(new ModLootTableProvider(generator));
        }

        if (event.includeClient()) {
            generator.addProvider(new ModBlockStateProvider(generator, helper));
            generator.addProvider(new ModItemModelProvider(generator, helper));
            generator.addProvider(new ModEngLanguageProvider(generator));
            generator.addProvider(new ModKorLanguageProvider(generator));
        }
    }
}
