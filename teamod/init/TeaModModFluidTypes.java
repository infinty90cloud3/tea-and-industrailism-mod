/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.teamod.fluid.types.TeabucketFluidType;
import net.mcreator.teamod.TeaModMod;

public class TeaModModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, TeaModMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> TEABUCKET_TYPE = REGISTRY.register("teabucket", () -> new TeabucketFluidType());
}