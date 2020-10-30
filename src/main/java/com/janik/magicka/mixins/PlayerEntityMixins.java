package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import com.janik.magicka.register.Items;
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
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ICE_CHESTPLATE || entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Items.ICE_HELMET || entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Items.ICE_LEGGINGS || entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.ICE_BOOTS) {
                TrinketComponent comp = TrinketsApi.TRINKETS.get(entity);
                ItemStack stack = comp.getStack(SlotGroups.HAND, Slots.RING);

                if(stack.getItem() != Items.ICE_RING_ITEM){
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 1, false, false, false));
                }
            }
        } else if (BiomeUtils.isColdBiome(biome)){
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ICE_CHESTPLATE && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Items.ICE_HELMET && entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Items.ICE_LEGGINGS && entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.ICE_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5, 0, false, false, false));
            }
            if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.ICE_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 0, false, false, false));
            }
        }
    }

    private static void magmaArmorEffect(PlayerEntity entity) {

        Biome biome = entity.getEntityWorld().getBiome(entity.getBlockPos());

        if (BiomeUtils.isColdBiome(biome) || entity.isSubmergedInWater()) {
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.MAGMA_CHESTPLATE || entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Items.MAGMA_HELMET || entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Items.MAGMA_LEGGINGS || entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.MAGMA_BOOTS) {
                TrinketComponent comp = TrinketsApi.TRINKETS.get(entity);
                ItemStack stack = comp.getStack(SlotGroups.HAND, Slots.RING);

                if (stack.getItem() != Items.ICE_RING_ITEM) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 1, false, false, false));
                }
            }
        } else if (BiomeUtils.isWarmBiome(biome)) {
            if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.MAGMA_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5, 0, false, false, false));
            }
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.MAGMA_CHESTPLATE && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Items.MAGMA_HELMET && entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Items.MAGMA_LEGGINGS && entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.MAGMA_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 5, 0, false, false, false));
            }
        }
    }
}
