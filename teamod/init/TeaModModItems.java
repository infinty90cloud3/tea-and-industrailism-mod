/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.teamod.item.TeaswordbaseItem;
import net.mcreator.teamod.item.TeasoulgemItem;
import net.mcreator.teamod.item.TealeafItem;
import net.mcreator.teamod.item.TeabucketItem;
import net.mcreator.teamod.item.TaepoweredswordItem;
import net.mcreator.teamod.item.MusketItem;
import net.mcreator.teamod.TeaModMod;

import java.util.function.Function;

public class TeaModModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TeaModMod.MODID);
	public static final DeferredItem<Item> TEABOX = block(TeaModModBlocks.TEABOX);
	public static final DeferredItem<Item> TEABUCKET_BUCKET = register("teabucket_bucket", TeabucketItem::new);
	public static final DeferredItem<Item> TAEPOWEREDSWORD = register("taepoweredsword", TaepoweredswordItem::new);
	public static final DeferredItem<Item> TEASOULGEM = register("teasoulgem", TeasoulgemItem::new);
	public static final DeferredItem<Item> TEAPOWERPLANT = block(TeaModModBlocks.TEAPOWERPLANT);
	public static final DeferredItem<Item> SOULORE = block(TeaModModBlocks.SOULORE);
	public static final DeferredItem<Item> TEAPLANT = block(TeaModModBlocks.TEAPLANT);
	public static final DeferredItem<Item> TEALEAF = register("tealeaf", TealeafItem::new);
	public static final DeferredItem<Item> MUSKET = register("musket", MusketItem::new);
	public static final DeferredItem<Item> TEASWORDBASE = register("teaswordbase", TeaswordbaseItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}