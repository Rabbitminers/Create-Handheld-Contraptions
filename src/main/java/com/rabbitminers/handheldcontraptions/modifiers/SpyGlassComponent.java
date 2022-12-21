package com.rabbitminers.handheldcontraptions.modifiers;

import com.rabbitminers.handheldcontraptions.modifiers.data.ModifierComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class SpyGlassComponent implements IModifierComponent {
    private static final int ID
            = ModifierComponents.SPYGLASS.getId();
    private static final int STRESS_CONSUMPTION
            = ModifierComponents.SPYGLASS.getSUconsumption();
    @Override
    public int getComponentId() {
        return ID;
    }

    @Override
    public int getStressConsumption() {
        return STRESS_CONSUMPTION;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    public int getUseDuration(ItemStack stack) {
        return 1200;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPYGLASS;
    }
}
