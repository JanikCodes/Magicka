package com.janik.magicka.client;

import com.janik.magicka.client.renderer.PlacedBookBlockEntityRenderer;
import com.janik.magicka.register.MagickaBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class MagickaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(MagickaBlocks.PLACED_BOOK_BLOCK_ENTITY, PlacedBookBlockEntityRenderer::new);
    }
}
