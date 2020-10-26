package com.janik.magicka.items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterial_Ice_sword implements ToolMaterial {

    @Override
    public int getDurability() {
        return 250;
    }

    @Override
    public float getMiningSpeed() {
        return 2;
    }

    @Override
    public float getAttackDamage() {
        return 6.5f;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems();
    }
}
