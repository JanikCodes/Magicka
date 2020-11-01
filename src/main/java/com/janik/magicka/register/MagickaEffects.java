package com.janik.magicka.register;

import com.janik.magicka.Magicka;
import com.janik.magicka.effects.FreezeEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MagickaEffects {

    public static final StatusEffect FREEZE_EFFECT = new FreezeEffect();

    public static void registerEffects(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Magicka.MOD_ID, "freeze"), FREEZE_EFFECT);
    }

}
