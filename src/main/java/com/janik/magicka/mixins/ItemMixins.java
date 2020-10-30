package com.janik.magicka.mixins;

import com.janik.magicka.Magicka;
import com.janik.magicka.register.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixins {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void onUseOnBlock(ItemUsageContext context, CallbackInfoReturnable cbi){
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        if (world.isClient || !stack.getItem().equals(Items.BOOK)) return;

        Direction side = context.getSide();
        PlayerEntity player = context.getPlayer();
        BlockPos blockPos = context.getBlockPos();
        if (player.isSneaking() && side == Direction.UP && world.isAir(blockPos.offset(Direction.UP, 1))){
            world.setBlockState(blockPos.offset(Direction.UP, 1), Blocks.PLACED_BOOK.getPlacementState(new ItemPlacementContext(context)));
            if (player.isCreative()) return;
            stack.setCount(stack.getCount()-1);
        }

    }

//    @Inject(at = @At("HEAD"), method = "use", cancellable = true)
//    public void onUse(CallbackInfoReturnable cbi){
//        System.out.println("use");
//    }


}
