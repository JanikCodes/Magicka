package com.janik.magicka.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class FreezeEffect extends StatusEffect {



    public FreezeEffect() {
        super(StatusEffectType.HARMFUL, 0x82e4f5);
    }


    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            player.setVelocityClient(0, 0, 0);
        }
    }
}
