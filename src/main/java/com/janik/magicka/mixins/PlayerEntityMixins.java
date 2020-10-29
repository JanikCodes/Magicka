package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import com.janik.magicka.utils.BiomeUtils;
import dev.emi.trinkets.TrinketSlot;
import dev.emi.trinkets.api.*;
import net.fabricmc.fabric.impl.biome.InternalBiomeUtils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeArray;
import net.minecraft.world.biome.source.BiomeSource;
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
            IceArmorEffect(entity);
        }
    }

    private static void IceArmorEffect(PlayerEntity entity){

        Biome biome = entity.getEntityWorld().getBiome(entity.getBlockPos());

        if(BiomeUtils.isWarmBiome(biome) || entity.isInLava()){
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Magicka.ICE_CHESTPLATE || entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Magicka.ICE_HELMET || entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Magicka.ICE_LEGGINGS || entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                TrinketComponent comp = TrinketsApi.TRINKETS.get(entity);
                ItemStack stack = comp.getStack(SlotGroups.HAND, Slots.RING);
                if(stack.getItem() != Magicka.ICE_RING_ITEM){
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 1, false, false, true));
                }
            }
        } else if (BiomeUtils.isColdBiome(biome)){
            if (entity.getEquippedStack(EquipmentSlot.CHEST).getItem() == Magicka.ICE_CHESTPLATE && entity.getEquippedStack(EquipmentSlot.HEAD).getItem() == Magicka.ICE_HELMET && entity.getEquippedStack(EquipmentSlot.LEGS).getItem() == Magicka.ICE_LEGGINGS && entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5, 0, false, false, true));
            }
            if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() == Magicka.ICE_BOOTS) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 0, false, false, true));
            }
        }
    }

}
