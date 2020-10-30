package com.janik.magicka;

import com.janik.magicka.register.Blocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;


public class Magicka implements ModInitializer {

    public static String MOD_ID = "magick";

    //Item group for our mod
    public static final ItemGroup MAGICKA_ITEMGROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "itemgroup"))
            .icon(() -> new ItemStack(Items.BOWL))
            .build();


    @Override
    public void onInitialize() {

        Blocks.registerBlocks();
        com.janik.magicka.register.Items.registerItems();
    }
}
