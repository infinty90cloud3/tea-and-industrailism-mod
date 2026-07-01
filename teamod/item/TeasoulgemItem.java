package net.mcreator.teamod.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.teamod.procedures.TealeafFoodEatenProcedure;
import net.mcreator.teamod.procedures.TeaenergyProcedure;

public class TeasoulgemItem extends Item {
	public TeasoulgemItem(Item.Properties properties) {
		super(properties.enchantable(5));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState state) {
		return 2f;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		TealeafFoodEatenProcedure.execute(entity);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			TeaenergyProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}