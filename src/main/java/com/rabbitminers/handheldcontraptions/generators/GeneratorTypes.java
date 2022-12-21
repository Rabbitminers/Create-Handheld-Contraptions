package com.rabbitminers.handheldcontraptions.generators;

import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public enum GeneratorTypes {
    NONE(0, "None", 0),
    WINDMILL(1, "Windmill", 512);
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
}
