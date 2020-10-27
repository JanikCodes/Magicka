package com.janik.magicka.client.renderer;

import com.janik.magicka.blocks.entity.PlacedBookBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.EnchantingTableBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;

public class PlacedBookBlockEntityRenderer extends BlockEntityRenderer<PlacedBookBlockEntity> {

    private final BookModel book = new BookModel();

    public PlacedBookBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(PlacedBookBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();
        matrices.push();
        matrices.translate(0.5D, 0, 0.5D);
        float g = ((Direction)blockState.get(LecternBlock.FACING)).rotateYClockwise().asRotation();
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-g));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(90F));

        float f = (entity.getWorld().getTime() + tickDelta)*0.06F;
        float h = (float)Math.sin(f)*0.5F + 0.5F;
        this.book.setPageAngles(0.0F, MathHelper.lerp(h, 0.05F, 0.1F), MathHelper.lerp(h, 0.95F, 0.9F), 1.2F);
        VertexConsumer vertexConsumer = EnchantingTableBlockEntityRenderer.BOOK_TEXTURE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        this.book.method_24184(matrices, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}