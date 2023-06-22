package io.github.elredstoniano.gridlands.init;

import io.github.elredstoniano.gridlands.GridLands;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksInit {
    //https://www.youtube.com/watch?v=KPMiUnp0gp4
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GridLands.MODID);

    // Mirar la clase Blocks de forge para ver algunos ejemplos
    public static final RegistryObject<Block> GREEN_APPLE_BLOCK = BLOCKS.register("green_apple_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(5.0f, 17f) // dureza , resistencia a las explosiones
                    .instrument(NoteBlockInstrument.BANJO)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops() // para asegurarse de que se tiene que romper con
                    // la herramienta correcta, y si no no soltar nada
                    .pushReaction(PushReaction.DESTROY) // Al empujar con pistones, el bloque se destruirá
            ));

    // Alternativa
//    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
//
//        return ItemsInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
//    }
//
//    private static <T extends Block> RegistryObject<T> registerBlock(String name, RegistryObject<T> block){
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn);
//        return toReturn;
//    }
}
