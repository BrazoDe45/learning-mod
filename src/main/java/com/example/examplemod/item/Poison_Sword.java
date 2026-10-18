package com.example.examplemod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Poison_Sword extends Item{
    private static final int POISON_DURATION = 5*20;
    private static final int POISON_LEVEL = 0;
    private static final int HITS_PER_POISON = 3;
    private final Map<UUID,Integer> hitCounters = new HashMap<>();

    public Poison_Sword(Item.Properties properties)
    {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        super.hurtEnemy(stack, target,attacker);

        if(attacker.level().isClientSide())
        {
            return;
        }

        int hits = hitCounters.merge(attacker.getUUID(), 1, Integer::sum);

        if(hits >= HITS_PER_POISON)
        {
            hitCounters.put(attacker.getUUID(), 0);
            target.addEffect(new MobEffectInstance(MobEffects.POISON, POISON_DURATION, POISON_LEVEL));
        }
    }
}