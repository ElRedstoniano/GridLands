package io.github.elredstoniano.gridlands.events;

import com.mojang.logging.LogUtils;
import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.TabButton;
import net.minecraft.client.gui.components.tabs.Tab;
import net.minecraft.client.gui.components.tabs.TabNavigationBar;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = GridLands.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ScreensEventsTest {

    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void addCustomTab(ScreenEvent.Init event){

        //This is a test
        if (event.getScreen() instanceof CreateWorldScreen){
            // Only for code shortening purposes
            CreateWorldScreen screen = ((CreateWorldScreen) event.getScreen());

            //Remove old tabNavigationBar
            ((CreateWorldScreen) event.getScreen()).removeWidget(((CreateWorldScreen) event.getScreen()).tabNavigationBar);

            //Create new tabNavigationBar
            ((CreateWorldScreen) event.getScreen()).tabNavigationBar = TabNavigationBar.builder(screen.tabManager, screen.width).addTabs(screen.new GameTab(), screen.new WorldTab(), screen.new MoreTab()).build();

            //Add new tabNavigationBar
            ((CreateWorldScreen) event.getScreen()).addRenderableWidget(((CreateWorldScreen) event.getScreen()).tabNavigationBar);

            // test
            ((CreateWorldScreen) event.getScreen()).addRenderableWidget(new EditBox(Minecraft.getInstance().font,
                    10,
                    10,
                    40,
                    10,
                    Component.translatable("key.keyboard.delete")));

            // Reload UI
            ((CreateWorldScreen) event.getScreen()).repositionElements();
        }
    }
}
