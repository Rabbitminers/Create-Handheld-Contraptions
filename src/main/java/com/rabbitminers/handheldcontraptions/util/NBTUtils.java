package com.rabbitminers.handheldcontraptions.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class NBTUtils {
    @Nullable
    public static CompoundTag getOrGenerateCompoundTag(ItemStack stack) {
        return stack.hasTag() ? stack.getTag() : new CompoundTag();
    }

    public static int getOrCreateTagInt(String name, ItemStack stack) {
        CompoundTag nbt = getOrGenerateCompoundTag(stack);
        return 0;
    }

    public static int getOrCreateTagInt(String name, CompoundTag nbt) {
        return 0;
    }
}
