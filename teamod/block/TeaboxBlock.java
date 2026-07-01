package net.mcreator.teamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class TeaboxBlock extends Block {
	public TeaboxBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(3f, 10f).friction(1f).ignitedByLava().instrument(NoteBlockInstrument.BASS));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}