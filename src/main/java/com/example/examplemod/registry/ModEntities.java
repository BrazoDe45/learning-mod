package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.MiMob;
import com.example.examplemod.entity.QueenSlime;
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
    public static final RegistryObject<EntityType<MiMob>> MI_MOB = ENTITY_TYPES.register("mi_mob",
            () -> EntityType.Builder.of(MiMob::new, MobCategory.MONSTER)
                    .sized(0.75f, 0.8f)
                    .build(ENTITY_TYPES.key("mi_mob"))
    );

    public static final RegistryObject<EntityType<QueenSlime>> QUEEN_SLIME = ENTITY_TYPES.register("queen_slime",
            () -> EntityType.Builder.of(QueenSlime::new, MobCategory.MONSTER)
                    .sized(0.75F, 0.8F)
                    .build(ENTITY_TYPES.key("queen_slime"))
    );

    // Asocia cada mob con sus atributos base. Se engancha al evento en ExampleMod.
    // Cada mob nuevo necesita su propia línea event.put(...).
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MI_MOB.get(), MiMob.createAttributes().build());
        event.put(QUEEN_SLIME.get(), QueenSlime.createAttributes().build());
    }
}