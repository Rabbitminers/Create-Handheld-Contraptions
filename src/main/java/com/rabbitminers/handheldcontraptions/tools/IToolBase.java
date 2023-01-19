package com.rabbitminers.handheldcontraptions.tools;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.generators.BaseGenerator;
import com.rabbitminers.handheldcontraptions.generators.GeneratorTypes;
import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import com.rabbitminers.handheldcontraptions.render.ToolBaseModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IToolBase {
    default float getRotationSpeed(ItemStack stack) {
        return getGenerator(stack).getRotationalSpeed();
    }

    default boolean isOverStressed() {
        return true;
    }

    default IToolGenerator getGenerator(ItemStack stack) {
        return getGenerator(stack.getItem());
    }

    default IToolGenerator getGenerator(Item item) {
        return new BaseGenerator(0);
    }

    default List<ModifierComponents> getComponents(Player player) {
        return getComponents(player.getMainHandItem());
    }
    default List<ModifierComponents> getComponents(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        assert nbt != null;
        if (nbt.contains(ToolBase.MODIFIER_COMPONENTS_ACCESSOR)) {
            List<ModifierComponents> components = new ArrayList<>();
            for (int id : nbt.getIntArray(ToolBase.MODIFIER_COMPONENTS_ACCESSOR))
                components.add(ModifierComponents.of(id) != null
                ? ModifierComponents.of(id)
                : ModifierComponents.INVALID_COMPONENT);
            return components;
        }
        return Collections.emptyList();
    }

}
