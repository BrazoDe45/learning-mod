package com.example.examplemod;

import com.mojang.logging.LogUtils;
import com.example.examplemod.registry.ModBlocks;
import com.example.examplemod.registry.ModCreativeTabs;
import com.example.examplemod.registry.ModEntities;
import com.example.examplemod.registry.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// Clase principal: solo arranca el mod y conecta los registros.
// El contenido (bloques, ítems, mobs, pestañas) vive en el paquete "registry".
@Mod(ExampleMod.MODID)
public final class ExampleMod {
    // ID del mod. Lo usan todas las clases de registro y las carpetas de recursos.
    public static final String MODID = "examplemod";

    // Público para que otras clases (por ejemplo ClientEvents) puedan escribir en el log.
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();

        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup);

        // Conecta cada lista de registro al bus del mod.
        // Si falta alguna línea, lo que contiene esa lista no se registra.
        ModBlocks.BLOCKS.register(modBusGroup);
        ModItems.ITEMS.register(modBusGroup);
        ModEntities.ENTITY_TYPES.register(modBusGroup);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modBusGroup);

        // Asigna los atributos (vida, velocidad...) a los mobs del mod.
        EntityAttributeCreationEvent.BUS.addListener(ModEntities::registerAttributes);

        // Añade ítems a las pestañas creativas de vanilla.
        BuildCreativeModeTabContentsEvent.BUS.addListener(ModCreativeTabs::addToVanillaTabs);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
}