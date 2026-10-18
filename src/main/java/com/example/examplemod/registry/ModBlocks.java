package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.PoisonBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

// Aquí se registran TODOS los bloques del mod.
public class ModBlocks {
    // Lista de registro de bloques. Se conecta al bus en ExampleMod.
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<Block> TESTING_SIXFACES_BLOCK = BLOCKS.register("testing_sixfaces_block",
            () -> new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key("testing_sixfaces_block"))
                    .mapColor(MapColor.STONE)
            )
    );

    public static final RegistryObject<Block> TESTING_ONEFACE_BLOCK = BLOCKS.register("testing_oneface_block",
            ()-> new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key("testing_oneface_block"))
                    .mapColor(MapColor.STONE)
            )
    );

    public static final RegistryObject<Block> TESTING_EFFECTS_BLOCK = BLOCKS.register("testing_effects_block",
            () -> new PoisonBlock(BlockBehaviour.Properties.of().setId(BLOCKS.key("testing_efffects_block"))
                .mapColor(MapColor.COLOR_RED)
            )
    );

}