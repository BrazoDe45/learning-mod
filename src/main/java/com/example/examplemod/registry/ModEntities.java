package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.TestingMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Aquí se registran TODOS los mobs (entidades) del mod.
public class ModEntities {
    // Lista de registro de entidades. Se conecta al bus en ExampleMod.
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);

    // Mob "examplemod:mi_mob". MobCategory.MONSTER lo marca como hostil.
    // sized(ancho, alto) es la caja de colisión en bloques.
    public static final RegistryObject<EntityType<TestingMob>> MOB_PRUEBAS = ENTITY_TYPES.register("mob_pruebas",
            () -> EntityType.Builder.of(TestingMob::new, MobCategory.MONSTER)
                    .sized(0.75f, 0.8f)
                    .build(ENTITY_TYPES.key("mob_pruebas"))
    );

    // Asocia cada mob con sus atributos base. Se engancha al evento en ExampleMod.
    // Cada mob nuevo necesita su propia línea event.put(...).
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MOB_PRUEBAS.get(), TestingMob.createAttributes().build());
    }
}