package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixins {


    @Inject(method = "tick", at=@At("TAIL"))
    public void onTick(CallbackInfo cbi){
        PlayerEntity entity = (PlayerEntity)(Object)this;

        if(!entity.getEntityWorld().isClient) {
            if (entity.world.getBlockState(entity.getBlockPos().down()).isOf(Blocks.SNOW_BLOCK) || entity.world.getBlockState(entity.getBlockPos().down()).isOf(Blocks.SNOW) || entity.world.getBlockState(entity.getBlockPos().down()).isIn(BlockTags.ICE) || entity.world.getBlockState(entity.getBlockPos()).isOf(Blocks.SNOW)){
                if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Magicka.ICE_CHESTPLATE) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 5, 0, false, false, true));
                }
                if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Magicka.ICE_HELMET) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 5, 0, false, false, true));
                }
                if (entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Magicka.ICE_LEGGINGS) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 5, 0, false, false, true));
                }
                if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 5, 0, false, false, true));
                }
            }
        }
    }

}
