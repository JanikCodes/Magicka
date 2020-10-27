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
        ItemStack itemStack = entity.getEquippedStack(EquipmentSlot.FEET);

        if(!entity.getEntityWorld().isClient) {

            if (itemStack.getItem() == Magicka.ICE_BOOTS) {
                if (entity.world.getBlockState(entity.getBlockPos().down()).isOf(Blocks.SNOW_BLOCK) || entity.world.getBlockState(entity.getBlockPos().down()).isOf(Blocks.SNOW) || entity.world.getBlockState(entity.getBlockPos().down()).isIn(BlockTags.ICE)){
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 5, 1, false, false, true));
                }
            }
        }
    }

}
