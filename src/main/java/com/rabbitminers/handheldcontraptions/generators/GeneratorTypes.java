package com.rabbitminers.handheldcontraptions.generators;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.render.ToolBaseModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public enum GeneratorTypes {
    NONE(0, "None", 0),
    WINDMILL(1, "Windmill", 512),
    FURNACE(2, "Furnace", 1024);
    private final int id;
    private final String name;
    private final  int maximumStress;
    GeneratorTypes(int id, String name, int maximumStress) {
        this.id = id;
        this.name = name;
        this.maximumStress = maximumStress;
    }

    public static GeneratorTypes of(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        if (nbt != null && !nbt.contains("generator")) return NONE;
        return GeneratorTypes.of(nbt.getInt("generator"));
    }

    public static GeneratorTypes of(int queryId) {
        for (GeneratorTypes generatorType : GeneratorTypes.values())
            if (generatorType.id == queryId)
                return generatorType;
        return NONE;
    }

    public static IToolGenerator getGeneratorOf(int queryId) {
        return switch (queryId) {
            case 1 -> new WindmillGenerator();
            case 2 -> new FurnaceEngineGenerator();
            default -> new BaseGenerator(0);
        };
    }
}
