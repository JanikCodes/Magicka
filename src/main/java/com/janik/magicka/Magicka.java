package com.janik.magicka;

import com.janik.magicka.blocks.PlacedBookBlock;
import com.janik.magicka.blocks.entity.PlacedBookBlockEntity;
import com.janik.magicka.items.IceArmorMaterial;
import com.janik.magicka.items.IceSword;
import com.janik.magicka.items.ToolMaterialIce;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Magicka implements ModInitializer {

    public static String MOD_ID = "magick";

    //Item group for our mod
    public static final ItemGroup MAGICKAGROUP = FabricItemGroupBuilder.create(
            new Identifier("tutorial", "other"))
            .icon(() -> new ItemStack(Items.BOWL))
            .build();

    public static final Item BACON_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(1).saturationModifier(7f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3), 0.1f).build()).rarity(Rarity.COMMON).group(MAGICKAGROUP));
    public static final Item COOKED_BACON_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()).rarity(Rarity.COMMON).group(MAGICKAGROUP));
    public static final Item ENDERBOWL_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).alwaysEdible().build()).maxCount(1).rarity(Rarity.UNCOMMON).group(MAGICKAGROUP));
    public static final Item ICE_SHARD_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(16).group(MAGICKAGROUP));


    public static final ArmorMaterial ICEARMOR_MATERIAL = new IceArmorMaterial();
    public static final Item ICE_HELMET = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON).group(MAGICKAGROUP));
    public static final Item ICE_CHESTPLATE = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON).group(MAGICKAGROUP));
    public static final Item ICE_LEGGINGS = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON).group(MAGICKAGROUP));
    public static final Item ICE_BOOTS = new ArmorItem(ICEARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.COMMON).group(MAGICKAGROUP));

    //Placed Book
    public static final Block PLACED_BOOK = new PlacedBookBlock(FabricBlockSettings.of(Material.WOOL).nonOpaque());
    public static BlockEntityType<PlacedBookBlockEntity> PLACED_BOOK_BLOCK_ENTITY;

    @Override
    public void onInitialize() {
        //Others
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"bacon"), BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"cooked_bacon"), COOKED_BACON_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"enderbowl"), ENDERBOWL_ITEM);

        //Ice items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ice_shard"), ICE_SHARD_ITEM);
        //Tools
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ice_sword"), new IceSword(new ToolMaterialIce()));
        //Armor
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ice_helmet"), ICE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ice_chestplate"), ICE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ice_leggings"), ICE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ice_boots"),ICE_BOOTS);

        //Placed Book
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "placed_book"), PLACED_BOOK);
        PLACED_BOOK_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "placed_book"), BlockEntityType.Builder.create(PlacedBookBlockEntity::new, PLACED_BOOK).build(null));

    }
}
