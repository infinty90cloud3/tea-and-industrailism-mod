package net.mcreator.teamod.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.teamod.world.inventory.MenuMenu;
import net.mcreator.teamod.init.TeaModModMenus;
import net.mcreator.teamod.init.TeaModModItems;

public class ChargeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof TeaModModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == TeaModModItems.TEASOULGEM.get()) {
			if (entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().get(ResourceLocation.parse("tea_mod:teadrinker"))).isDone()) {
				if (entity instanceof Player _plr3 && _plr3.containerMenu instanceof MenuMenu) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof TeaModModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("tea_mod:powerof_tea"))), 10);
					if (world instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
						if (_entityStorage != null)
							_entityStorage.receiveEnergy((entity instanceof Player _plr ? _plr.experienceLevel : 0) * getEnergyStored(world, BlockPos.containing(x, y, z), null), false);
					}
				}
			}
		}
	}

	public static int getEnergyStored(LevelAccessor level, BlockPos pos, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IEnergyStorage energyStorage = levelExtension.getCapability(Capabilities.EnergyStorage.BLOCK, pos, direction);
			if (energyStorage != null)
				return energyStorage.getEnergyStored();
		}
		return 0;
	}
}