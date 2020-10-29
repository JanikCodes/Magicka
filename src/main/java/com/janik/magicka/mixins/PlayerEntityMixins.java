package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
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
                if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Magicka.ICE_CHESTPLATE && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Magicka.ICE_HELMET && entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Magicka.ICE_LEGGINGS && entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 5, 0, false, false, true));
                }
                if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 5, 0, false, false, true));
                }
            }else if(entity.world.getBlockState(entity.getBlockPos().down()).isOf(Blocks.SAND) || entity.world.getBlockState(entity.getBlockPos().down()).isOf(Blocks.RED_SAND) || entity.world.getBlockState(entity.getBlockPos().down()).isIn(BlockTags.SAND) || entity.isSubmergedIn(FluidTags.LAVA) || entity.isInLava()){
                if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Magicka.ICE_CHESTPLATE || entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Magicka.ICE_HELMET || entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Magicka.ICE_LEGGINGS || entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 5, 1, false, false, true));
                }
            }
        }
    }

}
