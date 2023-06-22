package io.github.elredstoniano.gridlands.init;

import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsInit {
    // DeferredRegister es como un map de Strings y un Suppler<?> -> Map<String, Suppler<?>>
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GridLands.MODID);

    public static final RegistryObject<Item> APPLE_GREEN = CreativeTabsInit.addToTab(
            ITEMS.register("green_apple", // en models/items el .json tiene que llevar el mismo nombre
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(0.2f)
                            .effect( () -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2), 0.5f) // la duracion es en ticks, la probabilidad va de 0.0f a 1.0f
                            // efecto , duración/ticks, nivel
                            .build())
                    .rarity(Rarity.EPIC)))

    );

    public static final RegistryObject<BlockItem> GREEN_APPLE_BLOCK_ITEM = CreativeTabsInit.addToTab(
            ITEMS.register("green_apple_block",
            () -> new BlockItem(BlocksInit.GREEN_APPLE_BLOCK.get(),
                    new Item.Properties().
                        rarity(Rarity.EPIC)))
    );
}
