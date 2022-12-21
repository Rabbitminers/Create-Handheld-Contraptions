package com.rabbitminers.handheldcontraptions.generators;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FurnaceEngineGenerator extends BaseGenerator {
    private int remainingFuelTicks;
    public FurnaceEngineGenerator(int stressOutput, float rotationalSpeed) {
        super(stressOutput, rotationalSpeed);
    }

    @Override
    public boolean isActive(ItemStack stack) {
        return remainingFuelTicks > 0;
    }
    @Override
    public void tickEvent(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        if (remainingFuelTicks <= 0) {

        }
    }
}
