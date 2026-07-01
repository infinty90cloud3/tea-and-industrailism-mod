/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.teamod.TeaModMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TeaModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TeaModMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(TeaModModBlocks.TEABOX.get().asItem());
			tabData.accept(TeaModModItems.TEALEAF.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(TeaModModItems.TEABUCKET_BUCKET.get());
			tabData.accept(TeaModModItems.TEASOULGEM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(TeaModModItems.TAEPOWEREDSWORD.get());
			tabData.accept(TeaModModItems.MUSKET.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(TeaModModBlocks.TEAPOWERPLANT.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(TeaModModBlocks.SOULORE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(TeaModModBlocks.TEAPLANT.get().asItem());
		}
	}
}