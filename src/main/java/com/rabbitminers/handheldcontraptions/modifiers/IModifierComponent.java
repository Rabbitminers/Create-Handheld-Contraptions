package com.rabbitminers.handheldcontraptions.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.render.drill.DrillToolModel;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
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
    default String getComponentName() {
        return "Invalid Component";
    }
    default int getStressConsumption() {
        return 0;
    }



    default void render(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType,
                        PoseStack ms, MultiBufferSource buffer, int light, int overlay) {

    }
}
