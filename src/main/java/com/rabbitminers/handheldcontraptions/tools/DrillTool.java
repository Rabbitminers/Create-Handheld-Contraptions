package com.rabbitminers.handheldcontraptions.tools;

import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DrillTool extends ToolBase implements IToolBase {
    public DrillTool(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        return super.use(p_41432_, p_41433_, p_41434_);
    }
}
