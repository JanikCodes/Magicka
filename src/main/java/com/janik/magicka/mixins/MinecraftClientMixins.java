package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixins {

    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "doAttack", at = @At("HEAD"), cancellable = true)
    public void onDoAttack(CallbackInfo cbi){
        if (player.hasStatusEffect(Magicka.FREEZE_EFFECT)){
            cbi.cancel();
        }
    }

    @Inject(method = "doItemUse", at = @At("HEAD"), cancellable = true)
    public void doItemUse(CallbackInfo cbi){
        if (player.hasStatusEffect(Magicka.FREEZE_EFFECT)){
            cbi.cancel();
        }
    }


}
