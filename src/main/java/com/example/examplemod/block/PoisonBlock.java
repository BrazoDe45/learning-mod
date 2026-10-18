package com.example.examplemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

// Bloque que envenena a los jugadores cercanos.
// Cada segundo revisa quién está a su alrededor y, si el jugador no está ya envenenado,
// le aplica Veneno durante 10 segundos.
public class PoisonBlock extends Block {

    // Radio de acción, en bloques.
    private static final double RANGE = 5.0;
    // Cada cuántos ticks revisa si hay jugadores cerca (20 ticks = 1 segundo).
    private static final int CHECK_INTERVAL = 20;
    // Duración del veneno en ticks: 10 segundos = 200 ticks.
    private static final int POISON_DURATION = 10 * 20;
    // Nivel del efecto: 0 = Veneno I, 1 = Veneno II...
    private static final int POISON_LEVEL = 0;

    public PoisonBlock(BlockBehaviour.Properties properties) {
        super(properties);
        int DURATION;
    }



    // Se ejecuta al colocar el bloque: programa la primera comprobación.
    // (Solo en el servidor; los ticks programados se guardan con el mundo.)
    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        if (level instanceof ServerLevel serverLevel && !oldState.is(state.getBlock())) {
            serverLevel.scheduleTick(pos, this, CHECK_INTERVAL);
        }
    }

    // Se ejecuta cuando vence el tick programado.
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Zona cuadrada alrededor del bloque, que se refina después con la distancia real.
        AABB area = new AABB(pos).inflate(RANGE);

        for (Player player : level.getEntitiesOfClass(Player.class, area)) {
            boolean inRange = player.distanceToSqr(pos.getCenter()) <= RANGE * RANGE;

            // Solo envenena si no tiene ya el efecto: así cada exposición dura 10 s completos
            // y el veneno hace daño a su ritmo normal en lugar de reiniciarse cada segundo.
            if (inRange && !player.isSpectator() && !player.hasEffect(MobEffects.POISON)) {
                player.addEffect(new MobEffectInstance(MobEffects.POISON, POISON_DURATION, POISON_LEVEL));
            }
        }

        // Vuelve a programar la siguiente comprobación: así el bloque actúa de forma continua.
        level.scheduleTick(pos, this, CHECK_INTERVAL);
    }
}