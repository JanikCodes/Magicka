package com.janik.magicka.utils;

import net.minecraft.world.biome.Biome;

public class BiomeUtils {

    public static boolean isColdBiome(Biome biome){
        return biome.getTemperature() <= 0.3F;
    }

    public static boolean isWarmBiome(Biome biome){
        return biome.getTemperature() >= 0.95F;
    }
}
