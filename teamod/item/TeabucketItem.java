package net.mcreator.teamod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.teamod.init.TeaModModFluids;

public class TeabucketItem extends BucketItem {
	public TeabucketItem(Item.Properties properties) {
		super(TeaModModFluids.TEABUCKET.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}