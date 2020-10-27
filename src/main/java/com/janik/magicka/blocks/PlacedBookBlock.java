package com.janik.magicka.blocks;

import com.janik.magicka.blocks.entity.PlacedBookBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class PlacedBookBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    protected static final VoxelShape SHAPE_NS = Block.createCuboidShape(1.0D, 0.0D, 3.0D, 15.0D, 1.5D, 13.0D);
    protected static final VoxelShape SHAPE_WE = Block.createCuboidShape(3.0D, 0.0D, 1.0D, 13.0D, 1.5D, 15.0D);


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(FACING) == Direction.SOUTH || state.get(FACING) == Direction.NORTH ? SHAPE_NS : SHAPE_WE;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    public PlacedBookBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new PlacedBookBlockEntity();
    }
}