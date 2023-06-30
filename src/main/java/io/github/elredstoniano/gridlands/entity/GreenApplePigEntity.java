package io.github.elredstoniano.gridlands.entity;

import io.github.elredstoniano.gridlands.init.EntityInit;
import io.github.elredstoniano.gridlands.init.ItemsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class GreenApplePigEntity extends Animal {
    public GreenApplePigEntity(EntityType<GreenApplePigEntity> type, Level level) {
        super(type, level);
    }

    // Este constructor llama al anterior
    public GreenApplePigEntity(Level level, double x, double y, double z){
        this(EntityInit.GREEN_APPLE_MAN.get(),level);
        setPos(x, y, z);
    }

    public GreenApplePigEntity(Level level, BlockPos position){
        this(level, position.getX(), position.getY(), position.getZ());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return new GreenApplePigEntity(level, this.blockPosition());
    }

    @Override
    protected void registerGoals(){
        //super.registerGoals(); si se estuviera extendiendo a un animal como pig se podrúa usar,
        // pero como no es así no hay goals por defecto
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new TemptGoal(this, 1.0D, Ingredient.of(ItemsInit.APPLE_GREEN.get()), false));
    }

    public static AttributeSupplier.Builder createExampleAttributes(){
        //return AttributeSupplier.builder();
        //return Animal.createMobAttributes();
        return Pig.createAttributes();
    }

    public static boolean canSpawn(EntityType<GreenApplePigEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random){
        return Animal.checkAnimalSpawnRules(entityType, level, spawnType, position, random);// && level.getLevelData().isRaining() && position.getY() > 40;
    }

}
