package com.rabbitminers.handheldcontraptions.render.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.modifiers.IModifierComponent;
import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import com.rabbitminers.handheldcontraptions.render.drill.DrillToolModel;
import com.rabbitminers.handheldcontraptions.tools.IToolBase;
import com.rabbitminers.handheldcontraptions.tools.ToolBase;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CommonToolRenderer {
    public static void renderComponents(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType,
                                        PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        if (stack.getItem() instanceof IToolBase toolBase) {
            List<ModifierComponents> componentsList = toolBase.getComponents(stack);
            System.out.println(componentsList);
            componentsList.forEach(y -> {
                IModifierComponent component = y.getModifierComponentClass();
                component.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
            });
        }
    }

    public static void renderGenerator(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType,
                                       PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        if (stack.getItem() instanceof IToolBase toolBase) {
            IToolGenerator generator = toolBase.getGenerator(stack);
            generator.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
        }
    }
}
