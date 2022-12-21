package com.rabbitminers.handheldcontraptions.network;

import com.rabbitminers.handheldcontraptions.util.NBTUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class ApplyToolUUIDPacket {
    public final ItemStack stack;
    public ApplyToolUUIDPacket(ItemStack stack) {
        this.stack = stack;

    }
    public ApplyToolUUIDPacket(FriendlyByteBuf byteBuf) {
        this(byteBuf.readItem());
    }

    public void encode(FriendlyByteBuf byteBuf) {
        byteBuf.writeItemStack(this.stack, true);
    }
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        final var success = new AtomicBoolean(false);
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            CompoundTag nbt = NBTUtils.getOrGenerateCompoundTag(this.stack);
            if (player != null && nbt != null) {
                nbt.putUUID("toolid", UUID.randomUUID());
                stack.setTag(nbt);
                success.set(true);
            }
        });
        ctx.get().setPacketHandled(true);
        return success.get();
    }
}
