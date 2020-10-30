package com.janik.magicka.register;

import com.janik.magicka.Magicka;
import com.janik.magicka.blocks.CandleBlock;
import com.janik.magicka.blocks.PlacedBookBlock;
import com.janik.magicka.blocks.entity.PlacedBookBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MagickaBlocks {

    public static final Block PLACED_BOOK = new PlacedBookBlock(FabricBlockSettings.of(Material.WOOL).nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL));
    public static BlockEntityType<PlacedBookBlockEntity> PLACED_BOOK_BLOCK_ENTITY;
    public static final Block CANDLE_BLOCK = new CandleBlock(FabricBlockSettings.of(Material.SUPPORTED).nonOpaque().breakInstantly().sounds(BlockSoundGroup.WOOD).luminance((state) -> 3 + 3 * state.get(CandleBlock.CANDLES)), ParticleTypes.FLAME);


    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Magicka.MOD_ID, "placed_book"), PLACED_BOOK);
        PLACED_BOOK_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Magicka.MOD_ID, "placed_book"), BlockEntityType.Builder.create(PlacedBookBlockEntity::new, PLACED_BOOK).build(null));

        Registry.register(Registry.BLOCK, new Identifier(Magicka.MOD_ID, "candle"), CANDLE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Magicka.MOD_ID, "candle"), new BlockItem(CANDLE_BLOCK, new Item.Settings().group(Magicka.MAGICKA_ITEMGROUP)));
    }
}
