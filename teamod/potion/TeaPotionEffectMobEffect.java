package net.mcreator.teamod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.teamod.procedures.TeaPotionStartedappliedProcedure;

public class TeaPotionEffectMobEffect extends InstantenousMobEffect {
	public TeaPotionEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6737152);
	}

	@Override
	public void applyInstantenousEffect(ServerLevel level, Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		TeaPotionStartedappliedProcedure.execute(entity);
	}
}