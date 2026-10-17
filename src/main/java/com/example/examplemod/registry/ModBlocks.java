package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Aquí se registran TODOS los bloques del mod.
public class ModBlocks {
    // Lista de registro de bloques. Se conecta al bus en ExampleMod.
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<Block> BLOQUEA = BLOCKS.register("bloquea",
            () -> new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key("bloquea"))
                    .mapColor(MapColor.STONE)
            )
    );

/*    public static final RegistryObject<Block> TESTING_BUILDING_BLOCK = BLOCKS.register("testing_building_block",
            () -> new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key("testing_building_block"))
                    .mapColor(MapColor.STONE)
            )
    );  */

    public static final RegistryObject<Block> TESTING_NATURAL_BLOCK = BLOCKS.register("testing_natural_block",
            () -> new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key("testing_natural_block"))
                    .mapColor(MapColor.STONE))

    /*public static final RegistryObject<Block> TESTING_BUILDING_BLOCK = BLOCKS.register("testing_building_block",
            () -> new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key("testing_building_block"))
                    .mapColor(MapColor.STONE)
            )*/
    );

}