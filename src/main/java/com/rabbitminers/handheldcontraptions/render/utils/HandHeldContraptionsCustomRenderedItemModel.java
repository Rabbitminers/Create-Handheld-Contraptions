package com.rabbitminers.handheldcontraptions.render.utils;

import com.rabbitminers.handheldcontraptions.HandHeldContraptions;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import net.minecraft.client.resources.model.BakedModel;

public class HandHeldContraptionsCustomRenderedItemModel extends CustomRenderedItemModel {
    public HandHeldContraptionsCustomRenderedItemModel(BakedModel template, String basePath) {
        super(template, HandHeldContraptions.MODID, basePath);
    }
}
