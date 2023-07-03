package io.github.elredstoniano.gridlands.events;

import com.mojang.logging.LogUtils;
import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraftforge.client.PresetEditorManager;
import net.minecraftforge.client.event.RegisterPresetEditorsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;

public class RegisterWorldPreset {
    private static final Logger LOGGER = LogUtils.getLogger();

    //@SubscribeEvent
    public static void testEvent(RegisterPresetEditorsEvent event){
        //ResourceKey resKey = new ResourceKey<WorldPreset>(new ResourceLocation("minecraft", "preset"),
                //new ResourceLocation(GridLands.MODID, "worldgen/world_preset/grid_lands.json"));
        ResourceKey resKey = ResourceKey.create(Registries.WORLD_PRESET,
                new ResourceLocation(GridLands.MODID, "worldgen/world_preset/grid_lands.json"));
        event.register(resKey, PresetEditorManager.get(resKey));
        LOGGER.info("TESTSSSSSSSSSSSSSSSSS");
    }
}
