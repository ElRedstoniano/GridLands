package io.github.elredstoniano.gridlands.init;

import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit {
    public static final TagKey<Block> NEEDS_APPLE_TOOL = tag("");

    private static TagKey<Block> tag(String name){
        return BlockTags.create(new ResourceLocation(GridLands.MODID, name));
    }
}
