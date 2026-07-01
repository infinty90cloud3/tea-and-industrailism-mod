package net.mcreator.teamod.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.teamod.init.TeaModModItems;
import net.mcreator.teamod.init.TeaModModFluids;
import net.mcreator.teamod.init.TeaModModFluidTypes;
import net.mcreator.teamod.init.TeaModModBlocks;

public abstract class TeabucketFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> TeaModModFluidTypes.TEABUCKET_TYPE.get(), () -> TeaModModFluids.TEABUCKET.get(), () -> TeaModModFluids.FLOWING_TEABUCKET.get())
			.explosionResistance(100f).bucket(() -> TeaModModItems.TEABUCKET_BUCKET.get()).block(() -> (LiquidBlock) TeaModModBlocks.TEABUCKET.get());

	private TeabucketFluid() {
		super(PROPERTIES);
	}

	public static class Source extends TeabucketFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends TeabucketFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}