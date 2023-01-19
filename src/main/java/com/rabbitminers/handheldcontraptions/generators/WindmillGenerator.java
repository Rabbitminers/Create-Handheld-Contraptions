package com.rabbitminers.handheldcontraptions.generators;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.rabbitminers.handheldcontraptions.config.HHCConfig;
import com.rabbitminers.handheldcontraptions.render.ToolBaseModel;
import com.rabbitminers.handheldcontraptions.render.drill.DrillToolModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.rabbitminers.handheldcontraptions.util.ToolTipUtils;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class WindmillGenerator extends BaseGenerator implements IToolGenerator {
    public static String GENERATOR_NAME = "Windmill Generator";
    private float rotationAngle = 0.0f;
    private static final int maximumStressOutput = HHCConfig.GENERAL.windmillMaxStressOutput.get();
    private static final float maximumRotationalSpeed = 32.0f;

    public WindmillGenerator() {
        super(maximumStressOutput);
    }

    @Override
    public void tickEvent(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        double yHeight = entity.getY() + 65.0f;
        double y = (yHeight > 377.0f) ? 377f : yHeight;

        stressOutput = (int) Math.floor((yHeight/377)* maximumStressOutput);
        // if (!isPlayerOutside(entity)) stressOutput /= 1.5;
        rotationalSpeed = stressOutput > 0 ? ((maximumStressOutput*(float) y)/(maximumStressOutput*377.0f)*48.0f) : 0;
        System.out.println(rotationalSpeed);
    }

    public boolean isPlayerOutside(Entity entity) {
        return entity.getLevel().canSeeSky(entity.getOnPos());
    }

    public void updateRotationAngle() {
        float step = (360f / (20f * 60f) * (rotationalSpeed / 1.5f))/2.75f;
        rotationAngle = (rotationAngle + step) < 360f ? rotationAngle + step : rotationAngle + step - 360f;
    }

    @Override
    public void render(ItemStack stack, DrillToolModel model, PartialItemModelRenderer renderer, ItemTransforms.TransformType transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        float xOffset = -1/16f;

        ms.translate(0.5, 0.5, 0.5);
        ms.translate(0, 0, -xOffset);

        updateRotationAngle();
        ms.mulPose(Vector3f.XN.rotationDegrees(this.rotationAngle));

        ms.translate(0, 0, xOffset);

        renderer.renderSolid(model.getPartial("windmill"), light);
    }


    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

}
