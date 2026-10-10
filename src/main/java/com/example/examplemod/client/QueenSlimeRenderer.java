package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.QueenSlime;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class QueenSlimeRenderer extends MobRenderer<QueenSlime, LivingEntityRenderState, QueenSlimeModel> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(ExampleMod.MODID, "textures/entity/queen_slime.png");

    public QueenSlimeRenderer(EntityRendererProvider.Context context) {
        super(context, new QueenSlimeModel(context.bakeLayer(QueenSlimeModel.LAYER_LOCATION)), 0.4f);
    }

    @Override
    public LivingEntityRenderState createRenderState() { return new LivingEntityRenderState();}

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {return TEXTURE;}
}
