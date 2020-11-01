package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixins {

    @Inject(method = "render", at = @At("HEAD"))
    public void onRenderHead(LivingEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo cbi){
        if (livingEntity.hasStatusEffect(Magicka.FREEZE_EFFECT)){

        }
    }

    @Inject(method = "render", at = @At("TAIL"))
    public void onRenderTail(LivingEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo cbi){
        if (livingEntity.hasStatusEffect(Magicka.FREEZE_EFFECT)){

        }
    }



}
