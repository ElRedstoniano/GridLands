package io.github.elredstoniano.gridlands;

import io.github.elredstoniano.gridlands.events.RegisterWorldPreset;
import io.github.elredstoniano.gridlands.init.BlocksInit;
import io.github.elredstoniano.gridlands.init.CreativeTabsInit;
import io.github.elredstoniano.gridlands.init.EntityInit;
import io.github.elredstoniano.gridlands.init.ItemsInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GridLands.MODID)
public class GridLands {
    public static final String MODID = "gridlands"; // NO MAYUS

    public GridLands() {
        // Registrando los items en el event bus
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //bus.addListener(RegisterWorldPreset::testEvent);
    // test 2
        ItemsInit.ITEMS.register(bus);
        BlocksInit.BLOCKS.register(bus);
        CreativeTabsInit.TABS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }
}
