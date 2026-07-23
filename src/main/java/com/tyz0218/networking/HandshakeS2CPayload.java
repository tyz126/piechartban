package com.tyz0218.networking;

import com.tyz0218.PieChartBan;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record HandshakeS2CPayload(boolean idk) implements CustomPacketPayload {
    public static Identifier HandshakeS2CPayloadID = PieChartBan.MOD_CHANNEL;
    public static final CustomPacketPayload.Type<HandshakeS2CPayload> ID = new CustomPacketPayload.Type<>(HandshakeS2CPayloadID);
    public static final StreamCodec<RegistryFriendlyByteBuf, HandshakeS2CPayload> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, HandshakeS2CPayload::idk, HandshakeS2CPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
