package com.rabbitminers.handheldcontraptions.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import java.util.List;

public class ToolTipUtils {

    public static void addHorizontalDivider(List<Component> components, int width) {
        components.add(new TextComponent("-".repeat(Math.max(0, width))).withStyle(ChatFormatting.DARK_GRAY));
    }

    public static void addColouredPair(List<Component> components, String firstValue, String lastValue, ChatFormatting firstColour,
                                       ChatFormatting lastColour) {
        components.add(new TextComponent(firstValue)
                .withStyle(firstColour).append(new TextComponent(lastValue).withStyle(lastColour)));
    }

    public static void addColouredPair(List<Component> components,  String firstValue, String lastValue) {
        components.add(new TextComponent(firstValue)
                .withStyle(ChatFormatting.DARK_GRAY).append(new TextComponent(lastValue).withStyle(ChatFormatting.GRAY)));
    }
}
