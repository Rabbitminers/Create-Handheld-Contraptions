package com.rabbitminers.handheldcontraptions.generators;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IToolGenerator {
    default boolean isActive(ItemStack stack) {
        return getRotationalSpeed() > 0 && getStressOutput() > 0;
    }

    default float getRotationalSpeed() {
        return 0.0f;
    }

    default int getStressOutput() {
        return 0;
    }

    default void tickEvent(ItemStack stack, Level level, Entity entity, int i, boolean b) {}
}
