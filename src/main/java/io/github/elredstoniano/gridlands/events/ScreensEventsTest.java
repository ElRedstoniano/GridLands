package io.github.elredstoniano.gridlands.events;

import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GridLands.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ScreensEventsTest {

    @SubscribeEvent
    //d
    public static void aVoid(ScreenEvent.Init event){
        //This is a test
        if (event.getScreen() instanceof CreateWorldScreen){
            event.getScreen().addRenderableWidget(new EditBox(Minecraft.getInstance().font,
                    10,
                    10,
                    40,
                    10,
                    Component.translatable("key.keyboard.delete")));
        }
    }
}
