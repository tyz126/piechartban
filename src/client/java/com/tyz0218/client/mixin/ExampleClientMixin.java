package com.tyz0218.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DebugHud.class)
public class ExampleClientMixin {
	@Inject(at = @At("HEAD"), method = "shouldRenderTickCharts", cancellable = true)
	public void shouldRenderTickCharts(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}

	@Inject(at = @At("HEAD"), method = "shouldShowRenderingChart", cancellable = true)
	public void shouldShowRenderingChart(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}
}