/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.teamod.potion.TeaPotionEffectMobEffect;
import net.mcreator.teamod.TeaModMod;

public class TeaModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TeaModMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> TEA = REGISTRY.register("tea", () -> new TeaPotionEffectMobEffect());
}