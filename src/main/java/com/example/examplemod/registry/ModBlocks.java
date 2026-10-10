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

    // Bloque de ejemplo: "examplemod:example_block".
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("example_block"))
                    .mapColor(MapColor.STONE)
            )
    );

    // Para añadir otro bloque, copia el bloque anterior con otro nombre,
    // y registra su BlockItem en ModItems.
}