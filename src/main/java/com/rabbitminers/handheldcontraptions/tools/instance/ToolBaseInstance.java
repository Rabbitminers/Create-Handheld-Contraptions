package com.rabbitminers.handheldcontraptions.tools.instance;

import com.rabbitminers.handheldcontraptions.generators.Generator;
import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;

import java.util.UUID;

public class ToolBaseInstance implements IToolBaseInstance {
    private final UUID toolUUID;
    private IToolGenerator generator;
    private ToolTypes toolType;
    public ToolBaseInstance(UUID uuid) {
        this.toolUUID = uuid;
    }
    @Override
    public boolean isToolComplete() {
        return false;
    }
}
