package com.reasure.trasherymachines;

import com.mojang.logging.LogUtils;
import com.reasure.trasherymachines.item.ModTiers;
import com.reasure.trasherymachines.setup.ModBlocks;
import com.reasure.trasherymachines.setup.ModItems;
import com.reasure.trasherymachines.setup.ModTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TrasheryMachines.MODID)
public class TrasheryMachines {
    // Directly reference a slf4j logger
    public static final String MODID = "trasherymachines";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TrasheryMachines() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the deferred registries
        ModItems.register(modBus);
        ModBlocks.register(modBus);

        ModTags.init();
        ModTiers.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
