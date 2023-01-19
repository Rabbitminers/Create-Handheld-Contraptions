package com.rabbitminers.handheldcontraptions.util;

import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import com.rabbitminers.handheldcontraptions.tools.ToolBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public static UUID getUUIDofTool(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        return nbt != null && nbt.hasUUID(ToolBase.UUID_ACCESSOR) ? nbt.getUUID(ToolBase.UUID_ACCESSOR) : null;
    }
    public static int getOrGenerateGeneratorTag(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        assert nbt != null;
        if (!(nbt.contains(ToolBase.GENERATOR_ACCESSOR))) {
            nbt.putInt(ToolBase.GENERATOR_ACCESSOR, 0);
            stack.setTag(nbt);
        }
        return nbt.contains(ToolBase.GENERATOR_ACCESSOR) ? nbt.getInt(ToolBase.GENERATOR_ACCESSOR) : 0;
    }

    public static List<ModifierComponents> getComponents(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        assert nbt != null;
        if (nbt.contains(ToolBase.MODIFIER_COMPONENTS_ACCESSOR)) {
            List<ModifierComponents> components = new ArrayList<>();
            for (int id : nbt.getIntArray(ToolBase.MODIFIER_COMPONENTS_ACCESSOR))
                components.add(ModifierComponents.of(id));
            return components;
        }
        return Collections.emptyList();
    }

    public static boolean toolContainsModifierComponent(ItemStack stack, ModifierComponents componentSearch) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        if (nbt == null || !nbt.contains("components"))
            return false;
        for (int component : nbt.getIntArray("components")) {
            if (component == componentSearch.getId())
                return true;
        }
        return false;
    }


}
