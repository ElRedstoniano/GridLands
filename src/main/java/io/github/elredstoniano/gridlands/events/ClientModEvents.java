package io.github.elredstoniano.gridlands.events;

import io.github.elredstoniano.gridlands.GridLands;
import io.github.elredstoniano.gridlands.client.model.GreenApplePigEntityModel;
import io.github.elredstoniano.gridlands.client.renderer.GreenApplePigRenderer;
import io.github.elredstoniano.gridlands.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GridLands.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(EntityInit.GREEN_APPLE_MAN.get(), GreenApplePigRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(GreenApplePigEntityModel.LAYER_LOCATION, GreenApplePigEntityModel::createBodyLayer);
    }
}
