package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import com.janik.magicka.register.MagickaEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mouse.class)
public abstract class MouseMixins {

    @Shadow private double x;
    @Shadow private double y;
    @Shadow @Final private MinecraftClient client;

    @Shadow public abstract boolean isCursorLocked();

    private double currentX = 0;
    private double currentY = 0;


    @Inject(method = "onCursorPos", at = @At("HEAD"), cancellable = true)
    public void onCursorPos(CallbackInfo cbi) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && client.isWindowFocused() && isCursorLocked()) {
            if (player.hasStatusEffect(MagickaEffects.FREEZE_EFFECT)) {
                cbi.cancel();
            }
        }
    }

    @Inject(method = "updateMouse", at = @At("HEAD"), cancellable = true)
    public void updateMouse(CallbackInfo cbi) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && client.isWindowFocused() && isCursorLocked()) {
            if (player.hasStatusEffect(MagickaEffects.FREEZE_EFFECT)){
                x = currentX;
                y = currentY;
                if (player.getStatusEffect(MagickaEffects.FREEZE_EFFECT).getDuration() == 1){
                    InputUtil.setCursorParameters(this.client.getWindow().getHandle(), 212995, x, y);
                }
                cbi.cancel();
            } else {
                currentX = x;
                currentY = y;
            }
        }
    }
}