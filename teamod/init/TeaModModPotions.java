/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.teamod.TeaModMod;

public class TeaModModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, TeaModMod.MODID);
	public static final DeferredHolder<Potion, Potion> TEA = REGISTRY.register("tea",
			() -> new Potion("tea", new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0, false, true), new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0, false, true)));
}