package io.github.elredstoniano.gridlands.client.renderer;

import io.github.elredstoniano.gridlands.GridLands;
import io.github.elredstoniano.gridlands.client.model.GreenApplePigEntityModel;
import io.github.elredstoniano.gridlands.entity.GreenApplePigEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GreenApplePigRenderer extends MobRenderer<GreenApplePigEntity, GreenApplePigEntityModel<GreenApplePigEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(GridLands.MODID, "textures/entity/green_apple_pig.png");
    public GreenApplePigRenderer(EntityRendererProvider.Context context) {
        super(context, new GreenApplePigEntityModel(context.bakeLayer(GreenApplePigEntityModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(GreenApplePigEntity entity) {
        //if(entity.isInPowderSnow) // cambiar skin
        return TEXTURE;
    }
}
