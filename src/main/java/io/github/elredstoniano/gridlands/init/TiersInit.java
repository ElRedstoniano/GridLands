package io.github.elredstoniano.gridlands.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TiersInit {
    public static final ForgeTier TIER = new ForgeTier(
            4, // 4 = netherita
            1800,
            1.5f, // baseline speed
            7,
            20,
            TagInit.NEEDS_APPLE_TOOL,
            () -> Ingredient.of(ItemsInit.APPLE_GREEN::get)
    );

}
