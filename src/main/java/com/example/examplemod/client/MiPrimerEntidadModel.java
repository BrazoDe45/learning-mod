package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

// Modelo del mob, adaptado del código que exportó Blockbench (mi_primer_entidad).
// Se eliminaron los campos body/crown y los métodos setupAnim/renderToBuffer, porque
// el juego dibuja automáticamente las partes del modelo y este mob no tiene animaciones.
public class MiPrimerEntidadModel extends EntityModel<LivingEntityRenderState> {

    // Identificador de la capa del modelo. Se registra en ExampleMod (onRegisterLayers)
    // y se usa en el renderizador para construir el modelo.
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExampleMod.MODID, "mi_mob"), "main");

    // Recibe la parte raíz ya construida a partir de createBodyLayer().
    public MiPrimerEntidadModel(ModelPart root) {
        super(root);
    }

    // Define la forma del modelo: los cubos del cuerpo y de la corona, con sus posiciones
    // y las coordenadas de textura (texOffs). Es el contenido exportado por Blockbench.
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Cuerpo: un cubo de 11x9x11 con un pequeño engrosado (CubeDeformation 0.5).
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -9.0F, -6.0F, 11.0F, 9.0F, 11.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        // Corona: conjunto de cubos finos sobre la parte superior del cuerpo.
        partdefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(0, 30).addBox(-6.0F, -9.0F, -6.0F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 30).addBox(-6.0F, -9.0F, 4.0F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(4.0F, -9.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(20, 20).addBox(-6.0F, -9.0F, -5.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(24, 34).addBox(-3.0F, -10.0F, 4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 38).addBox(2.0F, -11.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 38).addBox(-5.0F, -11.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 40).addBox(-6.0F, -12.0F, 4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 20).addBox(4.0F, -12.0F, 4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 32).addBox(-6.0F, -11.0F, -5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 32).addBox(-6.0F, -10.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 38).addBox(-6.0F, -11.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 36).addBox(4.0F, -11.0F, 2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(4.0F, -10.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(-2.0F, -11.0F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 36).addBox(4.0F, -11.0F, -5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 40).addBox(4.0F, -12.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 38).addBox(2.0F, -11.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 32).addBox(-3.0F, -10.0F, -6.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 38).addBox(-5.0F, -11.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 24).addBox(-6.0F, -12.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        // Los dos últimos números (64, 64) son el tamaño de la textura en píxeles.
        // El PNG debe medir exactamente 64x64.
        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}