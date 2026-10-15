package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.TestingMob;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

// Renderizador del mob: es quien dibuja el modelo con su textura en pantalla.
// Se registra en ClientEvents (onRegisterRenderers).
public class TestingMobRenderer extends MobRenderer<TestingMob, LivingEntityRenderState, TestingMobModel> {

    // Ruta de la textura: assets/examplemod/textures/entity/mob_prueba.png
    // (en el código se escribe sin el prefijo "assets/<modid>/").
    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(ExampleMod.MODID, "textures/entity/testing_mob.png");

    // Construye el modelo a partir de la capa registrada (LAYER_LOCATION).
    // El último parámetro (0.4f) es el radio de la sombra bajo el mob.
    public TestingMobRenderer(EntityRendererProvider.Context context) {
        super(context, new TestingMobModel(context.bakeLayer(TestingMobModel.LAYER_LOCATION)), 0.4f);
    }

    // Crea el objeto de estado que el juego usa para pasar datos al renderizado.
    // Como el mob no tiene animaciones ni datos especiales, basta con el estado estándar.
    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    // Devuelve la textura que se aplica al modelo.
    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}