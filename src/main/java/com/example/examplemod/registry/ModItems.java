package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Aquí se registran TODOS los ítems del mod, incluidos los BlockItem
// (el ítem que coloca cada bloque).
public class ModItems {
    // Lista de registro de ítems. Se conecta al bus en ExampleMod.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    // Ítem que coloca el bloque de ejemplo. Usa el mismo nombre que el bloque.
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
            () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(),
                    new Item.Properties().setId(ITEMS.key("example_block")))
    );

    // Ítem de comida de ejemplo.
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key("example_item"))
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .nutrition(1)
                            .saturationModifier(2f)
                            .build()
                    )
            )
    );
}