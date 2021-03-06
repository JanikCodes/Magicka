package com.janik.magicka;

import com.janik.magicka.register.MagickaBlocks;
import com.janik.magicka.register.MagickaEffects;
import com.janik.magicka.register.MagickaItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class Magicka implements ModInitializer {

    public static String MOD_ID = "magick";

    //Item group for our mod
    public static final ItemGroup MAGICKA_ITEMGROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "itemgroup"))
            .icon(() -> new ItemStack(MagickaItems.ENDERBOWL_ITEM))
            .build();


    @Override
    public void onInitialize() {

        MagickaBlocks.registerBlocks();
        MagickaItems.registerItems();
        MagickaEffects.registerEffects();
    }
}
