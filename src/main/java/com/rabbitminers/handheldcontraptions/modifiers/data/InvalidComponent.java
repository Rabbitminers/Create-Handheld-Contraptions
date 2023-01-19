package com.rabbitminers.handheldcontraptions.modifiers.data;

import com.rabbitminers.handheldcontraptions.modifiers.IModifierComponent;

public class InvalidComponent implements IModifierComponent {
    @Override
    public int getComponentId() {
        return -1;
    }

    @Override
    public String getComponentName() {
        return "INVALID";
    }
}
