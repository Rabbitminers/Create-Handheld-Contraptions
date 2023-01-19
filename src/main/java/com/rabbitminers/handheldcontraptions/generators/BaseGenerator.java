package com.rabbitminers.handheldcontraptions.generators;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.render.ToolBaseModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class BaseGenerator implements IToolGenerator {
    public static String GENERATOR_NAME = "NONE";
    public float rotationalSpeed = 0;
    public int stressOutput = 0 ;
    private final int maximumStress;

    public BaseGenerator(int maximumStress) {
        this.maximumStress = maximumStress;
    }
    @Override
    public int getStressOutput() {
        return stressOutput;
    }

    @Override
    public float getRotationalSpeed() {
        return rotationalSpeed;
    }
    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }
    @Override
    public List<Component> appendDisplayText(List<Component> components) {

        components.add(new TextComponent("Generator Type: ").withStyle(ChatFormatting.DARK_GRAY)
                .append(new TextComponent(getGeneratorName()).withStyle(ChatFormatting.GRAY)));
        components.add(new TextComponent("Speed: ")
                .withStyle(ChatFormatting.DARK_GRAY)
                .append(new TextComponent(rotationalSpeed + " RPM ")
                .withStyle(ChatFormatting.GRAY))
                .append(new TextComponent("Stress: ")
                .withStyle(ChatFormatting.DARK_GRAY))
                .append(new TextComponent(stressOutput + " su ")
                .withStyle(ChatFormatting.GRAY)));

        return components;
    }
}
