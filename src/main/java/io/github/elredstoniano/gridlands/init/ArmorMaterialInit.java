package io.github.elredstoniano.gridlands.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final AppleArmorMaterial APPLE_MATERIAL = new AppleArmorMaterial(
        // aquí se define un array que por el orden de los elementos define
        // la durabilidad de cada elemento de la armadura
        new int[] {500, 1200, 600, 400},
                new int[]{11, 16, 15, 13},
                20,
                SoundEvents.BAMBOO_FALL,
                () -> Ingredient.of(ItemsInit.APPLE_GREEN::get),
                "apple_armor_material",
                0.25f,
                0.15f);
}
