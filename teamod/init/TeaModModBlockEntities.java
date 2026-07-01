/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.teamod.block.entity.TeapowerplantBlockEntity;
import net.mcreator.teamod.block.entity.TeaplantBlockEntity;
import net.mcreator.teamod.block.entity.SouloreBlockEntity;
import net.mcreator.teamod.TeaModMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TeaModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TeaModMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TeapowerplantBlockEntity>> TEAPOWERPLANT = register("teapowerplant", TeaModModBlocks.TEAPOWERPLANT, TeapowerplantBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SouloreBlockEntity>> SOULORE = register("soulore", TeaModModBlocks.SOULORE, SouloreBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TeaplantBlockEntity>> TEAPLANT = register("teaplant", TeaModModBlocks.TEAPLANT, TeaplantBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TEAPOWERPLANT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, TEAPOWERPLANT.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SOULORE.get(), SidedInvWrapper::new);
	}
}