package com.rabbitminers.handheldcontraptions.tools;

import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IToolBase {
    default int getRotationSpeed() {
        return 0;
    }

    default boolean isOverStressed() {
        return true;
    }

    default IToolGenerator getGenerator(ItemStack stack) {
        return getGenerator(stack.getItem());
    }

    default IToolGenerator getGenerator(Item item) {
        if (item instanceof IToolBase) {

        }
        return null;
    }

    default List<ModifierComponents> getComponents(Player player) {
        return getComponents(player.getMainHandItem());
    }
    default List<ModifierComponents> getComponents(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        if (nbt != null && nbt.contains(ToolBase.MODIFIER_COMPONENTS_ACCESSOR)) {
            int[] componentsIds = nbt.getIntArray(ToolBase.MODIFIER_COMPONENTS_ACCESSOR);
            List<ModifierComponents> modifierComponents = new ArrayList<>();
            for (int componentsId : componentsIds)
                modifierComponents.add(ModifierComponents.of(componentsId));
            return modifierComponents;
        }
        return Collections.emptyList();
    }

}
