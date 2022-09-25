package com.reasure.machinerycraft;

import com.mojang.logging.LogUtils;
import com.reasure.machinerycraft.item.ModTiers;
import com.reasure.machinerycraft.setup.ModBlockEntities;
import com.reasure.machinerycraft.setup.ModBlocks;
import com.reasure.machinerycraft.setup.ModItems;
import com.reasure.machinerycraft.setup.ModTags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MachineryCraft.MODID)
public class MachineryCraft {
    // Directly reference a slf4j logger
    public static final String MODID = "machinerycraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MachineryCraft() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the deferred registries
        ModItems.register(modBus);
        ModBlocks.register(modBus);
        ModBlockEntities.register(modBus);

        ModTags.init();
        ModTiers.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
