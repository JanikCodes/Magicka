package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import com.janik.magicka.register.MagickaEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyBinding.class)
public class KeyBindingMixins {



    @Inject(method = "isPressed", at = @At("HEAD"), cancellable = true)
    public void onMouseButton(CallbackInfoReturnable<Boolean> cbi) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.hasStatusEffect(MagickaEffects.FREEZE_EFFECT)){
            cbi.setReturnValue(false);
        }
    }

}
