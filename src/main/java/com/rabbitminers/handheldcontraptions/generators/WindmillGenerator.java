package com.rabbitminers.handheldcontraptions.generators;

import com.rabbitminers.handheldcontraptions.config.HHCConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WindmillGenerator extends BaseGenerator implements IToolGenerator {
    public static String GENERATOR_NAME = "Windmill Generator";
    private float rotationalSpeed = 0.0f;
    private int stressOutput = 0;
    private final int maximumStressOutput = HHCConfig.GENERAL.windmillMaxStressOutput.get();

    public WindmillGenerator(int stressOutput, float rotationalSpeed) {
        super(stressOutput, rotationalSpeed);
    }
    @Override
    public float getRotationalSpeed() {
        return rotationalSpeed;
    }
    @Override
    public int getStressOutput() {
        return stressOutput;
    }

    @Override
    public void tickEvent(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        double yHeight = entity.getY() + 65.0f;
        int y = (yHeight > 377.0f) ? 377 : (int) Math.floor(yHeight);

        stressOutput = (int) Math.floor((yHeight/377)*maximumStressOutput);
        this.rotationalSpeed = stressOutput > 0 ? maximumStressOutput/10.0f : 0;
    }
}
