package com.rabbitminers.handheldcontraptions.util;

import com.rabbitminers.handheldcontraptions.tools.ToolBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public abstract class ToolUtils {
    public static boolean isToolInMainHand(ItemStack stack, Player player) {
        ItemStack heldItem = player.getMainHandItem();
        return heldItem == stack;
    }
    public static boolean isToolInOffHand(ItemStack stack, Player player) {
        ItemStack heldItem = player.getOffhandItem();
        return heldItem == stack;
    }
    public static boolean isToolHeld(ItemStack stack, Player player) {
        return isToolInMainHand(stack, player) && isToolInOffHand(stack, player);
    }

    public UUID getUUIDofTool(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        return nbt != null && nbt.hasUUID(ToolBase.UUID_ACCESSOR) ? nbt.getUUID(ToolBase.UUID_ACCESSOR) : null;
    }
}
