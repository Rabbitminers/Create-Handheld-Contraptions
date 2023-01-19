package com.rabbitminers.handheldcontraptions.render;

import com.rabbitminers.handheldcontraptions.render.utils.HandHeldContraptionsCustomRenderedItemModel;
import net.minecraft.client.resources.model.BakedModel;

public class ToolBaseModel extends HandHeldContraptionsCustomRenderedItemModel {
    public ToolBaseModel(BakedModel template, String... partials) {
        super(template, "base");
        addPartials(
                "drill_head",
                "casing",
                "handle",
                "cog",
                "head",
                "flywheel",
                "blaze",
                "cage",
                "spyglass",
                "electron_tube",
                "steam_engine",
                "windmill",
                "encased_fan",
                "fan_blades",
                "rsc"
        );
    }
}

