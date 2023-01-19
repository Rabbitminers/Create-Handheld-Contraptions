package com.rabbitminers.handheldcontraptions.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import com.rabbitminers.handheldcontraptions.render.drill.DrillToolModel;
import com.rabbitminers.handheldcontraptions.util.ToolUtils;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import oshi.util.tuples.Pair;

import java.util.UUID;

public class BlazeBurnerComponent implements IModifierComponent {
    private static final int ID
            = ModifierComponents.BLAZE_BURNER.getId();
    private static final int STRESS_CONSUMPTION
            = ModifierComponents.BLAZE_BURNER.getSUconsumption();

    private static int xOffSet = 0;
    private static boolean isGoingUp = true;

    @Override
    public int getComponentId() {
        return ID;
    }

    @Override
    public int getStressConsumption() {
        return STRESS_CONSUMPTION;
    }

    public void updateXOffSet() {
        float step = (float) 0.00625/10.0f;

        if (xOffSet > 2.5f/16f && isGoingUp) {
            xOffSet -= step;
            isGoingUp = false;
        }
        else if (xOffSet < 0.2f/16f && !isGoingUp) {
            xOffSet += step;
            isGoingUp = true;
        }
        else
            xOffSet+=(isGoingUp ? +step : -step);
    }

    @Override
    public void render(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        IModifierComponent.super.render(stack, model, renderer, transformType, ms, buffer, light, overlay);

        ms.translate(0.5, 0.5, 0.5);

        if (!ToolUtils.toolContainsModifierComponent(stack, ModifierComponents.MILL_STONE)
            || ToolUtils.toolContainsModifierComponent(stack, ModifierComponents.MECHANICAL_ARM))
            renderer.render(model.getPartial("cage"), light);

        updateXOffSet();

        ms.popPose();
        ms.pushPose();

        ms.translate(0.5, 0.5, 0.5);

        ms.translate(-xOffSet, 0, 0);
        ms.mulPose(Vector3f.XP.rotationDegrees(xOffSet));
        ms.translate(xOffSet, 0, 0);

        renderer.renderSolid(model.getPartial("head"), light);

        ms.popPose();
        ms.pushPose();
    }
}
