package com.tyz0218.networking;

import com.tyz0218.PieChartBan;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record HandshakeS2CPayload(boolean idk) implements CustomPayload {
    public static Identifier HandshakeS2CPayloadID = PieChartBan.MOD_CHANNEL;
    public static final CustomPayload.Id<HandshakeS2CPayload> ID = new CustomPayload.Id<>(HandshakeS2CPayloadID);
    public static final PacketCodec<RegistryByteBuf, HandshakeS2CPayload> CODEC = PacketCodec.tuple(PacketCodecs.BOOLEAN, HandshakeS2CPayload::idk, HandshakeS2CPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
