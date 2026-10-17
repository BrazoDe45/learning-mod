package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.Poison_Sword;
import net.minecraft.core.RegistrySynchronization;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Weapon;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Aquí se registran TODOS los ítems del mod, incluidos los BlockItem
// (el ítem que coloca cada bloque).
public class ModItems {
    // Lista de registro de ítems. Se conecta al bus en ExampleMod.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    //ITEMS DE BLOQUES
    public static final RegistryObject<Item> TESTING_BUILDING_BLOCK_ITEM = ITEMS.register("testing_building_block",
            () -> new BlockItem(ModBlocks.TESTING_BUILDING_BLOCK.get(),
                    new Item.Properties().setId(ITEMS.key("testing_building_block")))
    );

    public static final RegistryObject<Item> TESTING_EFFECTS_BLOCK_ITEM = ITEMS.register("testing_effects_block",
            () -> new BlockItem(ModBlocks.TESTING_EFFECTS_BLOCK.get(),
                    new Item.Properties().setId(ITEMS.key("testing_effects_block")))
    );

    //ARMAS
    public static final RegistryObject<Item> TESTING_POISON_SWORD = ITEMS.register("testing_poison_sword",
            () -> new Poison_Sword(new Item.Properties()
                    .setId(ITEMS.key("testing_poison_sword"))
                    .sword(ToolMaterial.IRON, 3.0F, -2.4F)));

    //COMIDAS
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