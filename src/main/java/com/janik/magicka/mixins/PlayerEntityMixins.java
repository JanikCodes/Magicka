package com.janik.magicka.mixins;

import com.janik.magicka.register.MagickaItems;
import com.janik.magicka.utils.BiomeUtils;
import dev.emi.trinkets.api.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixins {


    @Inject(method = "tick", at=@At("TAIL"))
    public void onTick(CallbackInfo cbi){
        PlayerEntity entity = (PlayerEntity)(Object)this;

        if(!entity.getEntityWorld().isClient) {
            iceArmorEffect(entity);
            magmaArmorEffect(entity);
        }
    }

    private static void iceArmorEffect(PlayerEntity entity){

        Biome biome = entity.getEntityWorld().getBiome(entity.getBlockPos());

        if(BiomeUtils.isWarmBiome(biome) || entity.isInLava()){
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == MagickaItems.ICE_CHESTPLATE || entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == MagickaItems.ICE_HELMET || entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == MagickaItems.ICE_LEGGINGS || entity.getEquippedStack(EquipmentSlot.FEET).getItem() == MagickaItems.ICE_BOOTS) {
                TrinketComponent comp = TrinketsApi.TRINKETS.get(entity);
                ItemStack stack = comp.getStack(SlotGroups.HAND, Slots.RING);

                if(stack.getItem() != MagickaItems.ICE_RING_ITEM){
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 1, false, false, false));
                }
            }
        } else if (BiomeUtils.isColdBiome(biome)){
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == MagickaItems.ICE_CHESTPLATE && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == MagickaItems.ICE_HELMET && entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == MagickaItems.ICE_LEGGINGS && entity.getEquippedStack(EquipmentSlot.FEET).getItem() == MagickaItems.ICE_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5, 0, false, false, false));
            }
            if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == MagickaItems.ICE_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 0, false, false, false));
            }
        }
    }

    private static void magmaArmorEffect(PlayerEntity entity) {

        Biome biome = entity.getEntityWorld().getBiome(entity.getBlockPos());

        if (BiomeUtils.isColdBiome(biome) || entity.isSubmergedInWater()) {
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == MagickaItems.MAGMA_CHESTPLATE || entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == MagickaItems.MAGMA_HELMET || entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == MagickaItems.MAGMA_LEGGINGS || entity.getEquippedStack(EquipmentSlot.FEET).getItem() == MagickaItems.MAGMA_BOOTS) {
                TrinketComponent comp = TrinketsApi.TRINKETS.get(entity);
                ItemStack stack = comp.getStack(SlotGroups.HAND, Slots.RING);

                if (stack.getItem() != MagickaItems.MAGMA_RING_ITEM) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 1, false, false, false));
                }
            }
        } else if (BiomeUtils.isWarmBiome(biome)) {
            if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == MagickaItems.MAGMA_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5, 0, false, false, false));
            }
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == MagickaItems.MAGMA_CHESTPLATE && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == MagickaItems.MAGMA_HELMET && entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == MagickaItems.MAGMA_LEGGINGS && entity.getEquippedStack(EquipmentSlot.FEET).getItem() == MagickaItems.MAGMA_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 0, false, false, false));
            }
        }
    }
}
