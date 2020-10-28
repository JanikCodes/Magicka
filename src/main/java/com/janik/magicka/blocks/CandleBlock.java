package com.janik.magicka.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CandleBlock extends Block {

    public static final IntProperty CANDLES;
    protected static final VoxelShape ONE_CANDLE_SHAPE;
    protected static final VoxelShape TWO_CANDLE_SHAPE;
    protected static final VoxelShape THREE_CANDLE_SHAPE;
    protected static final VoxelShape FOUR_CANDLE_SHAPE;
    protected final ParticleEffect particle;

    public CandleBlock(Settings settings, ParticleEffect particle) {
        super(settings);
        this.particle = particle;
        this.setDefaultState((this.stateManager.getDefaultState()).with(CANDLES, 1));
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.with(CANDLES, Math.min(4, blockState.get(CANDLES) + 1));
        } else {
            return super.getPlacementState(ctx);
        }
    }

    protected boolean canPlaceOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return !floor.getCollisionShape(world, pos).getFace(Direction.UP).isEmpty() || floor.isSideSolidFullSquare(world, pos, Direction.UP);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return this.canPlaceOnTop(world.getBlockState(blockPos), world, blockPos);
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().getItem() == this.asItem() && (Integer) state.get(CANDLES) < 4 || super.canReplace(state, context);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch(state.get(CANDLES)) {
            case 1:
            default:
                return ONE_CANDLE_SHAPE;
            case 2:
                return TWO_CANDLE_SHAPE;
            case 3:
                return THREE_CANDLE_SHAPE;
            case 4:
                return FOUR_CANDLE_SHAPE;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CANDLES);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

        switch(state.get(CANDLES)) {
            case 1:
            default:{
                renderParticle(8, 8, 8, pos, world);
                break;
            }
            case 2: {
                renderParticle(10, 6, 10, pos, world);
                renderParticle(5, 7, 5, pos, world);
                break;
            }
            case 3: {
                renderParticle(4, 5, 4, pos, world);
                renderParticle(10, 8, 6, pos, world);
                renderParticle(8, 8, 11, pos, world);
//                renderParticle(0, 8, 0, pos, world);
                break;
            }
            case 4: {
                renderParticle(4, 7, 4, pos, world);
                renderParticle(11, 8, 4, pos, world);
                renderParticle(11, 5, 12, pos, world);
                renderParticle(4, 9, 10, pos, world);
//                renderParticle(0, 8, 0, pos, world);
                break;
            }
        }
    }

    private void renderParticle(double x, double y, double z, BlockPos pos, World world){
        double xCoord = (x / 16)+pos.getX();
        double yCoord = (y / 16)+pos.getY();
        double zCoord = (z / 16)+pos.getZ();
        world.addParticle(ParticleTypes.SMOKE, xCoord, yCoord, zCoord, 0.0D, 0.0D, 0.0D);
        world.addParticle(this.particle, xCoord, yCoord, zCoord, 0.0D, 0.0D, 0.0D);
    }

    static {
        CANDLES = IntProperty.of("candles", 1, 4);
        ONE_CANDLE_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 6.0D, 10.0D);
        TWO_CANDLE_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D);
        THREE_CANDLE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
        FOUR_CANDLE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D);
    }
}
