package com.janik.magicka.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class IceSword extends SwordItem {

    public IceSword(ToolMaterial material) {
        super(material, -1, -2.2f, new Item.Settings().group(ItemGroup.TOOLS));
    }
}
