package net.mcreator.teamod.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

public class TeaenergyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(100, false);
		}
		if (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 1, false, true));
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 1, false, true));
			if (entity instanceof Player _player)
				_player.giveExperienceLevels((int) (entity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 1, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1, false, false));
		}
	}
}