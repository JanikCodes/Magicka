package com.janik.magicka.register;

import com.janik.magicka.Magicka;
import com.janik.magicka.items.IceSwordItem;
import com.janik.magicka.items.materials.IceArmorMaterial;

import com.janik.magicka.items.materials.IceToolMaterial;
import com.janik.magicka.items.materials.MagmaArmorMaterial;
import com.janik.magicka.items.rings.IceRingItem;
import com.janik.magicka.items.rings.MagmaRingItem;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;

import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Items {

    public static final Item BACON_ITEM = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(7f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3), 0.1f).build()).rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item COOKED_BACON_ITEM = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()).rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item ENDERBOWL_ITEM = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).alwaysEdible().build()).maxCount(1).rarity(Rarity.UNCOMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item ICE_SHARD_ITEM = new Item(new Item.Settings().maxCount(16).group(Magicka.MAGICKA_ITEMGROUP));
    public static final ArmorMaterial ICEARMOR_MATERIAL = new IceArmorMaterial();
    public static final Item ICE_HELMET = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item ICE_CHESTPLATE = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item ICE_LEGGINGS = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item ICE_BOOTS = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().rarity(Rarity.UNCOMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final ArmorMaterial MAGMAARMOR_MATERIAL = new MagmaArmorMaterial();
    public static final Item MAGMA_HELMET = new ArmorItem(MAGMAARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item MAGMA_CHESTPLATE = new ArmorItem(MAGMAARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item MAGMA_LEGGINGS = new ArmorItem(MAGMAARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().rarity(Rarity.COMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item MAGMA_BOOTS = new ArmorItem(MAGMAARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().rarity(Rarity.UNCOMMON).group(Magicka.MAGICKA_ITEMGROUP));
    public static final Item MAGMA_RING_ITEM = new MagmaRingItem();
    public static final Item ICE_RING_ITEM = new IceRingItem();


    public static void registerItems(){

        TrinketSlots.addSlot(SlotGroups.HAND, Slots.RING, new Identifier("trinkets", "textures/item/empty_trinket_slot_ring.png"));
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"bacon"), BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"cooked_bacon"), COOKED_BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"enderbowl"), ENDERBOWL_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_shard"), ICE_SHARD_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_ring"), ICE_RING_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_sword"), new IceSwordItem(new IceToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_helmet"), ICE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_chestplate"), ICE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_leggings"), ICE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"ice_boots"),ICE_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"magma_ring"), MAGMA_RING_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"magma_helmet"), MAGMA_HELMET);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"magma_chestplate"), MAGMA_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"magma_leggings"), MAGMA_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID,"magma_boots"), MAGMA_BOOTS);
    }
}
