package com.janik.magicka;

import com.janik.magicka.items.IceArmorMaterial;
import com.janik.magicka.items.IceSword;
import com.janik.magicka.items.ToolMaterialIce;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Magicka implements ModInitializer {

    public static final Item BACON_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(1).saturationModifier(7f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3), 0.1f).build()).rarity(Rarity.COMMON));
    public static final Item COOKED_BACON_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()).rarity(Rarity.COMMON));
    public static final Item ENDERBOWL_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).alwaysEdible().build()).maxCount(1).rarity(Rarity.UNCOMMON));
    public static final Item ICE_SHARD_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16));


    public static final ArmorMaterial ICEARMOR_MATERIAL = new IceArmorMaterial();
    public static final Item ICE_HELMET = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.MISC));
    public static final Item ICE_CHESTPLATE = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.MISC));
    public static final Item ICE_LEGGINGS = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.MISC));
    public static final Item ICE_BOOTS = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("magick","bacon"), BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier("magick","cooked_bacon"), COOKED_BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier("magick","enderbowl"), ENDERBOWL_ITEM);

        //Ice items
        Registry.register(Registry.ITEM, new Identifier("magick","ice_shard"), ICE_SHARD_ITEM);
        //Tools
        Registry.register(Registry.ITEM, new Identifier("magick","ice_sword"), new IceSword(new ToolMaterialIce()));
        //Armor
        Registry.register(Registry.ITEM, new Identifier("magick","ice_helmet"), ICE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("magick","ice_chestplate"), ICE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("magick","ice_leggings"), ICE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("magick","ice_boots"),ICE_BOOTS);
    }
}
