package com.janik.magicka.items.rings;

import com.janik.magicka.Magicka;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//A class for your trinket
public class IceRingItem extends TrinketItem {

    public IceRingItem() {
        //Adding the trinket to the TOOLS group and making it not stack
        super(new Settings().group(Magicka.MAGICKA_ITEMGROUP).maxCount(1));
    }

    @Override
    public boolean canWearInSlot(String group, String slot) {
        //Determines what slots the trinket can be worn in, this makes it usable in the hand:ring slot
        return group.equals(SlotGroups.HAND) && slot.equals(Slots.RING);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        //Just one of the methods you can override in Trinket, the ring gives you the speed effect while wearing it
        //Though you probably shouldn't give the player a status effect every tick
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 19, 0));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("Test"));
    }
}