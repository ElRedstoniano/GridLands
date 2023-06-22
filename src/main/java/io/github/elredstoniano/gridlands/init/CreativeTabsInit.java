package io.github.elredstoniano.gridlands.init;

import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = GridLands.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabsInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GridLands.MODID);

    public static final List<Supplier <? extends ItemLike>> TAB_ITEMS = new ArrayList<>();

    // O en vez de esto usar @SubscribeEvent // registerCreativeModsTabs(CreativeModeTabEvent.Register event)
    public static final RegistryObject<CreativeModeTab> MOD_FOOD_TAB = TABS.register("mod_food_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mod_food_tab")) // no se pueden tener mayus
    // a exepcion de los nombres clave de las translations keys
                    //.icon( () -> new ItemStack(ItemInit.APPLE_GREEN.get()))
                    .icon(ItemsInit.APPLE_GREEN.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        //output.accept(ItemInit.APPLE_GREEN.get());
                        //output.accept(ItemInit.GREEN_APPLE_BLOCK_ITEM.get());
                        TAB_ITEMS.forEach(itemlike -> output.accept(itemlike.get()));
                        // esta es la manera que forge recomienda hacerlo
                        // tambien el TAB_ITEMS.forEach se puede poner en vez de aqui en el buildContents
                    })
                    .build());

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike){
        TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ItemsInit.GREEN_APPLE_BLOCK_ITEM);
            event.accept(ItemsInit.APPLE_GREEN);
        }

        if(event.getTab() == MOD_FOOD_TAB.get()) {
            event.accept(ItemsInit.GREEN_APPLE_BLOCK_ITEM);
            event.accept(ItemsInit.APPLE_GREEN);
        }
    }
}
