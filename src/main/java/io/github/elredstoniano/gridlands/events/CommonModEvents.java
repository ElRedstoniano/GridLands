package io.github.elredstoniano.gridlands.events;

import io.github.elredstoniano.gridlands.GridLands;
import io.github.elredstoniano.gridlands.entity.GreenApplePigEntity;
import io.github.elredstoniano.gridlands.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GridLands.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(EntityInit.GREEN_APPLE_MAN.get(), GreenApplePigEntity.createExampleAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event){
        event.register(EntityInit.GREEN_APPLE_MAN.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                GreenApplePigEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR);
    }
}
