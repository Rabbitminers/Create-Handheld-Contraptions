package com.rabbitminers.handheldcontraptions.modifiers;

import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;

public abstract class BlazeBurnerComponent implements IModifierComponent {
    private static final int ID
            = ModifierComponents.BLAZE_BURNER.getId();
    private static final int STRESS_CONSUMPTION
            = ModifierComponents.BLAZE_BURNER.getSUconsumption();
    @Override
    public int getComponentId() {
        return ID;
    }

    @Override
    public int getStressConsumption() {
        return STRESS_CONSUMPTION;
    }


}
