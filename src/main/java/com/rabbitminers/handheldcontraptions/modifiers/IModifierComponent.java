package com.rabbitminers.handheldcontraptions.modifiers;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public interface IModifierComponent {
    default int getComponentId() {
        return -1;
    }

    default int getStressConsumption() {
        return 0;
    }

    default InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return null;
    }

    default int getUseDuration(ItemStack stack) {
        return 0;
    }
}
