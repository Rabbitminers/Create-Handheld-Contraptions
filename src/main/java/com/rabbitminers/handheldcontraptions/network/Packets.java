package com.rabbitminers.handheldcontraptions.network;

import com.rabbitminers.handheldcontraptions.HandHeldContraptions;
import com.rabbitminers.handheldcontraptions.network.ApplyToolUUIDPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Packets {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }
    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(HandHeldContraptions.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ApplyToolUUIDPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ApplyToolUUIDPacket::new)
                .encoder(ApplyToolUUIDPacket::encode)
                .consumer(ApplyToolUUIDPacket::handle)
                .add();
    }

    public static <MSG> void sendServerMessage(MSG message) {
        INSTANCE.sendToServer(message);
    }
}
