package com.rabbitminers.handheldcontraptions.tools;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.generators.BaseGenerator;
import com.rabbitminers.handheldcontraptions.generators.GeneratorTypes;
import com.rabbitminers.handheldcontraptions.generators.IToolGenerator;
import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import com.rabbitminers.handheldcontraptions.network.Packets;
import com.rabbitminers.handheldcontraptions.render.ToolBaseModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import com.rabbitminers.handheldcontraptions.util.ToolUtils;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ToolBase extends Item implements IToolBase {

    public static final String UUID_ACCESSOR = "toolid";
    public static final String MODIFIER_COMPONENTS_ACCESSOR = "modifiercomponents";
    public static final String COMPONENTS_ACCESSOR = "components";
    public static final String GENERATOR_ACCESSOR = "generator";
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


    public boolean isOverStressed(ItemStack stack) {
        CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(stack);
        int[] components;
        int stressRequirement;

        assert nbt != null;
        if (nbt.contains(MODIFIER_COMPONENTS_ACCESSOR)) {
            components = nbt.getIntArray(MODIFIER_COMPONENTS_ACCESSOR);
        }


        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack mainHandItemStack = player.getMainHandItem();
        if (mainHandItemStack.getItem() instanceof ToolBase toolBase) {
            IToolGenerator generator = toolBase.getGenerator(toolBase);
            generator.useEvent(level, player, interactionHand);
        }
        return super.use(level, player, interactionHand);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        System.out.println(getGenerator(useOnContext.getItemInHand()));
        return InteractionResult.CONSUME;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        UUID uuid = getOrCreateUUID(stack);
        if (!(GENERATOR_MAP.containsKey(uuid))) {
            IToolGenerator generator = GeneratorTypes
                    .getGeneratorOf(ToolUtils
                            .getOrGenerateGeneratorTag(stack));
            GENERATOR_MAP.put(uuid, generator);
        }
        IToolGenerator generator = GENERATOR_MAP.get(uuid);
        generator.tickEvent(stack, level, entity, i, b);
    }

    @Override
    public IToolGenerator getGenerator(ItemStack stack) {
        UUID uuid = getOrCreateUUID(stack);
        return GENERATOR_MAP.containsKey(uuid) ? GENERATOR_MAP.get(uuid) : new BaseGenerator(0);
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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        components = getGenerator(stack).appendDisplayText(components);
        List<ModifierComponents> modifierComponents = getComponents(stack);
        for (ModifierComponents component : modifierComponents) {
            components.add(new TextComponent("- " + component.getName()).withStyle(ChatFormatting.DARK_GRAY));
            if (Screen.hasShiftDown()) components.add(new TextComponent(component.getDescription()).withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, p_41422_, components, p_41424_);
    }
}
