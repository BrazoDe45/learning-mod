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

public class QueenSlimeModel extends EntityModel<LivingEntityRenderState>{

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(ExampleMod.MODID, "queen_slime"), "main");

    public QueenSlimeModel(ModelPart root) {super(root);}

    public static LayerDefinition createBodyLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -9.0F, -6.0F, 11.0F, 9.0F, 11.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition crown = partDefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(0, 30).addBox(-6.0F, -9.0F, -6.0F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
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

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

}
