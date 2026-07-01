/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.teamod.TeaModMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TeaModModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, TeaModMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> STATUS = REGISTRY.register("status", () -> new RangedAttribute("attribute.tea_mod.status", 1, 1, 11).setSyncable(true).setSentiment(Attribute.Sentiment.NEUTRAL));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, STATUS);
	}
}