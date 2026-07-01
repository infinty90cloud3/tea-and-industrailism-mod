/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.teamod.fluid.TeabucketFluid;
import net.mcreator.teamod.TeaModMod;

public class TeaModModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, TeaModMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> TEABUCKET = REGISTRY.register("teabucket", () -> new TeabucketFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_TEABUCKET = REGISTRY.register("flowing_teabucket", () -> new TeabucketFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(TEABUCKET.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_TEABUCKET.get(), RenderType.translucent());
		}
	}
}