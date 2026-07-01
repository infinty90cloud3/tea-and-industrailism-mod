package net.mcreator.teamod.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.teamod.procedures.TeabucketMobplayerCollidesBlockProcedure;
import net.mcreator.teamod.init.TeaModModFluids;

public class TeabucketBlock extends LiquidBlock {
	public TeabucketBlock(BlockBehaviour.Properties properties) {
		super(TeaModModFluids.TEABUCKET.get(), properties.mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		TeabucketMobplayerCollidesBlockProcedure.execute(entity);
	}
}