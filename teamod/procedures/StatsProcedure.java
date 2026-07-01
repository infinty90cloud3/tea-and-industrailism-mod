package net.mcreator.teamod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.teamod.init.TeaModModAttributes;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class StatsProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(TeaModModAttributes.STATUS))
			_livingEntity1.getAttribute(TeaModModAttributes.STATUS).setBaseValue((DoubleArgumentType.getDouble(arguments, "status")));
	}
}