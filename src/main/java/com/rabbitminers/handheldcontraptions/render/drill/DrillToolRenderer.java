package com.rabbitminers.handheldcontraptions.render.drill;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.rabbitminers.handheldcontraptions.render.ToolBaseRenderer;
import com.rabbitminers.handheldcontraptions.render.utils.CommonToolRenderer;
import com.rabbitminers.handheldcontraptions.tools.ToolBase;
import com.rabbitminers.handheldcontraptions.util.ToolUtils;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.tileEntity.behaviour.scrollvalue.ScrollValueHandler;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class DrillToolRenderer extends CustomRenderedItemModelRenderer<DrillToolModel> {

    @Override
    protected void render(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType,
                          PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        // Render static handle at origin of model
        renderer.renderSolid(model.getPartial("handle"), light);
        renderer.renderSolid(model.getPartial("casing"), light);
        // Generate offset for each component
        float xOffset = -1/16f;
        // Rotate cog around central points
        ms.translate(-xOffset, 0, 0);
        ms.mulPose(Vector3f.ZP.rotationDegrees(ScrollValueHandler.getScroll(AnimationTickHolder.getPartialTicks())));
        ms.translate(xOffset, 0, 0);

        CompoundTag nbt = stack.hasTag() ? stack.getTag() : new CompoundTag();

        renderer.render(model.getPartial("cog"), light);
        renderer.render(model.getPartial("drill_head"), light);

        ms.popPose();
        ms.pushPose();

        CommonToolRenderer.renderComponents(stack, model, renderer, transformType, ms, buffer, light, overlay);

        ms.popPose();
        ms.pushPose();

        CommonToolRenderer.renderGenerator(stack, model, renderer, transformType, ms, buffer, light, overlay);

        ms.popPose();
        ms.pushPose();
    }

    @Override
    public DrillToolModel createModel(BakedModel originalModel) {
        return new DrillToolModel(originalModel);
    }
}
