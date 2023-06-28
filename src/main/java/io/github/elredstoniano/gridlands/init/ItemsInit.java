package io.github.elredstoniano.gridlands.init;

import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.github.elredstoniano.gridlands.init.CreativeTabsInit.addToTab;

public class ItemsInit {
    // DeferredRegister es como un map de Strings y un Suppler<?> -> Map<String, Suppler<?>>
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GridLands.MODID);

    public static final RegistryObject<Item> APPLE_GREEN = addToTab(
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

    public static final RegistryObject<BlockItem> GREEN_APPLE_BLOCK_ITEM = addToTab(
            ITEMS.register("green_apple_block",
            () -> new BlockItem(BlocksInit.GREEN_APPLE_BLOCK.get(),
                    new Item.Properties().
                        rarity(Rarity.EPIC)))
    );

    // Sword
    public static final RegistryObject<SwordItem> GREEN_APPLE_SWORD = addToTab(
            ITEMS.register("green_apple_sword",
                    () -> new SwordItem(
                            TiersInit.TIER,
                            7,
                            2.5f,
                            new Item.Properties()
                    ))
    );

    // Pickaxe
    public static final RegistryObject<PickaxeItem> GREEN_APPLE_PICKAXE = addToTab(
            ITEMS.register("green_apple_pickaxe",
                    () -> new PickaxeItem(
                            TiersInit.TIER,
                            2,
                            3.0f,
                            new Item.Properties()
                    ))
    );

    // Axe
    public static final RegistryObject<AxeItem> GREEN_APPLE_AXE = addToTab(
            ITEMS.register("green_apple_axe",
                    () -> new AxeItem(
                            TiersInit.TIER,
                            2,
                            3.0f,
                            new Item.Properties()
                    ))
    );

    // Shovel
    public static final RegistryObject<ShovelItem> GREEN_APPLE_SHOVEL = addToTab(
            ITEMS.register("green_apple_shovel",
                    () -> new ShovelItem(
                            TiersInit.TIER,
                            2,
                            3.0f,
                            new Item.Properties()
                    ))
    );

    // Hoe
    public static final RegistryObject<HoeItem> GREEN_APPLE_HOE = addToTab(
            ITEMS.register("green_apple_hoe",
                    () -> new HoeItem(
                            TiersInit.TIER,
                            2,
                            3.0f,
                            new Item.Properties()
                    ))
    );

    // Helmet
    public static final RegistryObject<ArmorItem> APPLE_HELMET = addToTab(
            ITEMS.register("green_apple_helmet",
                    () -> new ArmorItem(
                            ArmorMaterialInit.APPLE_MATERIAL,
                            ArmorItem.Type.HELMET,
                            new Item.Properties()
                    ))
    );

    // Chestplate
    public static final RegistryObject<ArmorItem> APPLE_CHESTPLATE = addToTab(
            ITEMS.register("green_apple_chestplate",
                    () -> new ArmorItem(
                            ArmorMaterialInit.APPLE_MATERIAL,
                            ArmorItem.Type.CHESTPLATE,
                            new Item.Properties()
                    ))
    );

    // Helmet
    public static final RegistryObject<ArmorItem> APPLE_LEGGINGS = addToTab(
            ITEMS.register("green_apple_leggings",
                    () -> new ArmorItem(
                            ArmorMaterialInit.APPLE_MATERIAL,
                            ArmorItem.Type.LEGGINGS,
                            new Item.Properties()
                    ))
    );

    // Chestplate
    public static final RegistryObject<ArmorItem> APPLE_BOOTS = addToTab(
            ITEMS.register("green_apple_boots",
                    () -> new ArmorItem(
                            ArmorMaterialInit.APPLE_MATERIAL,
                            ArmorItem.Type.BOOTS,
                            new Item.Properties()
                    ))
    );

    //////
    public static final RegistryObject<BlockItem> GREEN_APPLE_ORE_ITEM = addToTab(
            ITEMS.register("green_apple_ore",
                    () -> new BlockItem(BlocksInit.GREEN_APPLE_ORE.get(),
                            new Item.Properties())));

    public static final RegistryObject<BlockItem> DEEPSLATE_GREEN_APPLE_ORE_ITEM = addToTab(
            ITEMS.register("deepslate_green_apple_ore",
                    () -> new BlockItem(BlocksInit.DEEPSLATE_GREEN_APPLE_ORE.get(),
                            new Item.Properties())));
}
