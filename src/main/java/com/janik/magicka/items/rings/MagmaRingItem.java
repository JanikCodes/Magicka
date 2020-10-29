package com.janik.magicka.items.rings;

import com.janik.magicka.Magicka;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagmaRingItem extends TrinketItem {

    public MagmaRingItem() {
        super(new Settings().group(Magicka.MAGICKA_ITEMGROUP).maxCount(1));
    }

    @Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.HAND) && slot.equals(Slots.RING);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("Test"));
    }
}