package com.rabbitminers.handheldcontraptions.generators;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rabbitminers.handheldcontraptions.config.HHCConfig;
import com.rabbitminers.handheldcontraptions.render.ToolBaseModel;
import com.rabbitminers.handheldcontraptions.tools.data.ToolTypes;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;

public class FurnaceEngineGenerator extends BaseGenerator {
    private int remainingFuelTicks;
    private static final int maximumStressOutput = HHCConfig.GENERAL.furnaceEngineMaxStressOutput.get();
    public static String GENERATOR_NAME = "Furnace Engine";

    public FurnaceEngineGenerator() {
        super(maximumStressOutput);
    }

    @Override
    public boolean isActive(ItemStack stack) {
        return remainingFuelTicks > 0;
    }

    @Override
    public String getGeneratorName() {
        return GENERATOR_NAME;
    }

    @Override
    public void useEvent(Level level, Player player, InteractionHand interactionHand) {
        ItemStack offHandItem = player.getOffhandItem();
        Vec3 playerPos = player.getEyePosition();
        int burnTime = ForgeHooks.getBurnTime(offHandItem, RecipeType.SMELTING);

        ItemStack tool = player.getMainHandItem();

        if (burnTime <= 0 && player.getCooldowns().isOnCooldown(tool.getItem())) {
            level.playSound((Player) null, player.blockPosition(), SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            return;
        }

        player.getCooldowns().addCooldown(tool.getItem(), 20);

        this.remainingFuelTicks += burnTime*offHandItem.getCount();
        level.addParticle(ParticleTypes.FLAME, playerPos.x, playerPos.y, playerPos.z, 0, 1, 0);
    }

    @Override
    public void tickEvent(ItemStack stack, Level level, Entity entity, int i, boolean b) {
        if (remainingFuelTicks <= 0) {

        }
    }

}
