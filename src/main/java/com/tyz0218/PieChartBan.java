package com.tyz0218;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tyz0218.networking.HandshakeS2CPayload;

import java.net.URI;

public class PieChartBan implements ModInitializer {
	public static final String MOD_ID = "piechartban";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier MOD_CHANNEL = Identifier.of(MOD_ID, "handshake");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//LOGGER.info("Hello Fabric world!");
		String url = "https://modrinth.com/mod/pie-chart-ban";

		PayloadTypeRegistry.playS2C().register(HandshakeS2CPayload.ID, HandshakeS2CPayload.CODEC);

		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			if (!ServerPlayNetworking.canSend(handler, MOD_CHANNEL)) {
				server.execute(() -> {
					handler.disconnect(Text.literal("You must download the Pie Chart Ban mod to join this server!\n").append(Text.literal(url).setStyle(Style.EMPTY.withUnderline(true)).formatted(Formatting.AQUA)));
				});
			}
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
