package com.rabbitminers.handheldcontraptions.tools;

import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.network.Packets;
import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ToolBase extends Item implements IToolBase {

    public static final String UUID_ACCESSOR = "toolid";
    public static final String MODIFIER_COMPONENTS_ACCESSOR = "modifiercomponents";
    public static final String COMPONENTS_ACCESSOR = "components";
    private static final Map<UUID, IToolGenerator> GENERATOR_MAP = new HashMap<>();
    public ToolBase(Properties p_41383_) {
        super(p_41383_);
    }

    public boolean isToolComplete(ItemStack stack) {
        return false;
    }

    public UUID getOrCreateUUID(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        if (nbt == null) return null;
        if (!nbt.hasUUID(UUID_ACCESSOR)) {
            UUID uuid = UUID.randomUUID();
            nbt.putUUID(UUID_ACCESSOR, uuid);
            stack.setTag(nbt);
            return uuid;
        } else
            return nbt.getUUID(UUID_ACCESSOR);
    }


    @Override
    public boolean isOverStressed() {
        return IToolBase.super.isOverStressed();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        UUID uuid = getOrCreateUUID(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.isCurse();
    }
}
