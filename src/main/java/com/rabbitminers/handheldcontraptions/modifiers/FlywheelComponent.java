package com.rabbitminers.handheldcontraptions.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.rabbitminers.handheldcontraptions.render.drill.DrillToolModel;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.tileEntity.behaviour.scrollvalue.ScrollValueHandler;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

public class FlywheelComponent implements IModifierComponent {
    // TODO


    @Override
    public void render(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        float xOffset = -1/16f;
        ms.translate(0.5, 0.5, 0.5);

        ms.translate(-xOffset, 0, 0);
        ms.mulPose(Vector3f.ZP.rotationDegrees(ScrollValueHandler.getScroll(AnimationTickHolder.getPartialTicks())));
        ms.translate(xOffset, 0, 0);

        renderer.renderSolid(model.getPartial("flywheel"), light);

        IModifierComponent.super.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
    }
}
