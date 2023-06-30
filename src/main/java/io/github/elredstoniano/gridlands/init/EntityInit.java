package io.github.elredstoniano.gridlands.init;

import io.github.elredstoniano.gridlands.GridLands;
import io.github.elredstoniano.gridlands.entity.GreenApplePigEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GridLands.MODID);

    public static final RegistryObject<EntityType<GreenApplePigEntity>> GREEN_APPLE_MAN = ENTITIES.register("green_apple_pig",
            () -> EntityType.Builder.<GreenApplePigEntity>of(GreenApplePigEntity::new,
                    MobCategory.CREATURE)
                    .sized(0.75f, 1.985f)
                    .build(new ResourceLocation(GridLands.MODID, "green_apple_pig").toString()));
}
