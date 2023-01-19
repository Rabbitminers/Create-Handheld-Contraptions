package com.rabbitminers.handheldcontraptions.generators;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.render.ToolBaseRenderer;
import com.rabbitminers.handheldcontraptions.render.drill.DrillToolModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public interface IToolGenerator {
    default boolean isActive(ItemStack stack) {
        return getRotationalSpeed() > 0 && getStressOutput() > 0;
    }
    default String getGeneratorName() {
        return null;
    }
    default float getRotationalSpeed() {
        return 0.0f;
    }
    default int getStressOutput() {
        return 0;
    }
    default void tickEvent(ItemStack stack, Level level, Entity entity, int i, boolean b) {}
    default void useEvent(Level level, Player player, InteractionHand interactionHand) {}
    default List<Component> appendDisplayText(List<Component> components) { return components; }
    default void render(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType,
                        PoseStack ms, MultiBufferSource buffer, int light, int overlay) {}
    default void useAnimation() {}
}
