package com.reasure.machinerycraft.item;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.TierSortingRegistry;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

/*
This item is only used for debug code
 */
public class DebugItem extends Item {
    private static final Logger logger = LogUtils.getLogger();

    public DebugItem(Properties properties) {
        super(properties);
    }

    @NotNull
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand useHand) {
        logger.debug(TierSortingRegistry.getSortedTiers().toString());
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(useHand), level.isClientSide());
    }
}
