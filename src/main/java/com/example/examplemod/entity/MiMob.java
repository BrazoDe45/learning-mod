package com.example.examplemod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

// Mob hostil con comportamiento parecido al del zombi.
// Extiende Monster: es hostil, desaparece en dificultad pacifica
// y usa los sonidos y reglas de spawn de los monstruos.
public class MiMob extends Monster {

    public MiMob(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    // Atributos base. Se parecen a los del zombi:
    // - MAX_HEALTH: 20 de vida (10 corazones).
    // - MOVEMENT_SPEED: velocidad de movimiento.
    // - ATTACK_DAMAGE: dano por golpe (3 = 1,5 corazones).
    // - FOLLOW_RANGE: distancia a la que detecta objetivos.
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.23)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.FOLLOW_RANGE, 35.0);
    }

    // Objetivos de IA. Un numero de prioridad mas bajo se evalua antes.
    @Override
    protected void registerGoals() {
        // goalSelector: que hace el mob (comportamiento).
        this.goalSelector.addGoal(0, new FloatGoal(this));                              // flota en el agua en vez de hundirse
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));            // ataca cuerpo a cuerpo (velocidad 1.0)
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0));        // vuelve a su zona permitida si se aleja
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));     // pasea al azar evitando el agua
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));   // mira al jugador cercano (hasta 8 bloques)
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));                   // gira la cabeza al azar

        // targetSelector: a quien elige como objetivo.
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));                                  // responde a quien le haga dano
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // persigue al jugador mas cercano
    }
}