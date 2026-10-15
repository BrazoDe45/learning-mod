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

// Modelo del mob, adaptado del código que exportó Blockbench.
// Se eliminaron los métodos setupAnim/renderToBuffer, porque el juego dibuja
// automáticamente las partes del modelo y este mob no tiene animaciones.
public class TestingMobModel extends EntityModel<LivingEntityRenderState> {

    // Identificador de la capa del modelo. Se registra en ClientEvents (onRegisterLayers)
    // y se usa en el renderizador para construir el modelo.
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExampleMod.MODID, "mob_pruebas"), "main");

    // Recibe la parte raíz ya construida a partir de createBodyLayer().
    public TestingMobModel(ModelPart root) {
        super(root);
    }

    // Define la forma del modelo: cuerpo, brazos, piernas y cabeza, con sus posiciones
    // y las coordenadas de textura (texOffs). Es el contenido exportado por Blockbench.
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -1.0F));

        PartDefinition r_arm = bone.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -8.0F, -1.0F));

        PartDefinition l_arm = bone.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(20, 18).addBox(0.0F, 0.001F, -1.0115F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -8.0F, -1.0F));

        PartDefinition r_leg = bone.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(24, 7).addBox(-1.0F, 0.0F, -1.0042F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, -1.0F));

        PartDefinition l_leg = bone.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(20, 25).addBox(-1.0F, 0.0F, -0.9958F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, -1.0F));

        PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -1.0F));

        PartDefinition upper_mouth = head.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(24, 13).addBox(4.0F, -7.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 26).addBox(3.0F, -4.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 26).addBox(4.0F, -7.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 26).addBox(-5.0F, -7.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 26).addBox(-4.0F, -4.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-5.0F, -7.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 3.0F));

        PartDefinition lower_mouth = head.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}