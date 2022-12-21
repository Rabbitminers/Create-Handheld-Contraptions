package com.rabbitminers.handheldcontraptions.generators;

public class BaseGenerator implements IToolGenerator {
    public static String GENERATOR_NAME = "NONE";
    private float rotationalSpeed;
    private int stressOutput ;
    public BaseGenerator(int stressOutput, float rotationalSpeed) {
        this.rotationalSpeed = rotationalSpeed;
        this.stressOutput = stressOutput;
    }
    @Override
    public int getStressOutput() {
        return stressOutput;
    }

    @Override
    public float getRotationalSpeed() {
        return rotationalSpeed;
    }
}
