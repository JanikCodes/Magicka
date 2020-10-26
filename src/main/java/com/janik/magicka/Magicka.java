package com.janik.magicka;

import com.janik.magicka.items.IceSword;
import com.janik.magicka.items.ToolMaterialIce;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Magicka implements ModInitializer {

    public static final Item BACON_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(1).saturationModifier(7f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3), 0.1f).build()).rarity(Rarity.COMMON));
    public static final Item COOKED_BACON_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()).rarity(Rarity.COMMON));
    public static final Item ENDERBOWL_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).alwaysEdible().build()).maxCount(1).rarity(Rarity.UNCOMMON));
    public static final Item ICE_SHARD_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("magick","bacon"), BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier("magick","cooked_bacon"), COOKED_BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier("magick","enderbowl"), ENDERBOWL_ITEM);
        Registry.register(Registry.ITEM, new Identifier("magick","ice_shard"), ICE_SHARD_ITEM);
        Registry.register(Registry.ITEM, new Identifier("magick","ice_sword"), new IceSword(new ToolMaterialIce()));
    }
}
