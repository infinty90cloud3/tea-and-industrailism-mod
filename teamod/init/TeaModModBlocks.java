/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.teamod.block.TeapowerplantBlock;
import net.mcreator.teamod.block.TeaplantBlock;
import net.mcreator.teamod.block.TeabucketBlock;
import net.mcreator.teamod.block.TeaboxBlock;
import net.mcreator.teamod.block.SouloreBlock;
import net.mcreator.teamod.TeaModMod;

import java.util.function.Function;

public class TeaModModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TeaModMod.MODID);
	public static final DeferredBlock<Block> TEABOX = register("teabox", TeaboxBlock::new);
	public static final DeferredBlock<Block> TEABUCKET = register("teabucket", TeabucketBlock::new);
	public static final DeferredBlock<Block> TEAPOWERPLANT = register("teapowerplant", TeapowerplantBlock::new);
	public static final DeferredBlock<Block> SOULORE = register("soulore", SouloreBlock::new);
	public static final DeferredBlock<Block> TEAPLANT = register("teaplant", TeaplantBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}