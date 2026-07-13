package com.tyz0218.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.packet.CustomPayload;
import com.tyz0218.PieChartBan;

public class PieChartBanClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(new CustomPayload.Id<>(PieChartBan.MOD_CHANNEL), (payload, context) -> {

        });
    }
}
