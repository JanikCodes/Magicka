package com.janik.magicka.client;

import com.janik.magicka.Magicka;
import com.janik.magicka.client.renderer.PlacedBookBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class MagickaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(Magicka.PLACED_BOOK_BLOCK_ENTITY, PlacedBookBlockEntityRenderer::new);
    }
}