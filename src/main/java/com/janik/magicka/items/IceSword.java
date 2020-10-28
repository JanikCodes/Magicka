package com.janik.magicka.items;

import com.janik.magicka.Magicka;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;

public class IceSword extends SwordItem {

    public IceSword(ToolMaterial material) {
        super(material, -1, -2.2f, new Item.Settings().group(Magicka.MAGICKA_ITEMGROUP));
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!attacker.getEntityWorld().isClient){
            if(target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 2, false, true));
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
