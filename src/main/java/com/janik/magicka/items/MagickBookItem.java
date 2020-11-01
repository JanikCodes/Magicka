package com.janik.magicka.items;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagickBookItem extends Item {


    public MagickBookItem(Settings settings) {
        super(settings);
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        CompoundTag nbt = playerEntity.getStackInHand(hand).getOrCreateTag();
        System.out.println(nbt);

        if(nbt.contains("Uses")){
            nbt.putInt("Uses",nbt.getInt("Uses") + 1);
        }else{
            nbt.putInt("Uses", 1);
        }

        playerEntity.getStackInHand(hand).setTag(nbt);
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }

   /*
    if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Uses"))
    {
        lores.add(Integer.toString(stack.getTagCompound().getInteger("Uses")));
    }

     */

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(stack.hasTag()){
            CompoundTag tag = stack.getTag();
            if(tag.contains("Uses")){
                tooltip.add(Text.of(Integer.toString(tag.getInt("Uses"))));
            }
        }

    }

}
