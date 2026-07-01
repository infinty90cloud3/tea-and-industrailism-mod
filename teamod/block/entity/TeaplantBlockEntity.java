package net.mcreator.teamod.block.entity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.BlockPos;

import net.mcreator.teamod.init.TeaModModBlockEntities;

public class TeaplantBlockEntity extends BlockEntity {
	public TeaplantBlockEntity(BlockPos pos, BlockState state) {
		super(TeaModModBlockEntities.TEAPLANT.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}
}