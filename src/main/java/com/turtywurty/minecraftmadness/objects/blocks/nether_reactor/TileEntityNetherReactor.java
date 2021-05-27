package com.turtywurty.minecraftmadness.objects.blocks.nether_reactor;

import com.turtywurty.minecraftmadness.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import scala.collection.script.Update;

public class TileEntityNetherReactor extends TileEntity implements ITickable 
{
	public boolean active = false;

	@Override
	public void update() 
	{
		BlockPos pos1 = pos.offset(EnumFacing.DOWN, 1); // Gets the block position below the block
		IBlockState state1 = this.world.getBlockState(pos1); // Gets the block state of the pos1
		Block block1 = state1.getBlock(); // Gets the block of the pos1

		BlockPos pos2 = pos.offset(EnumFacing.DOWN, 2); // Gets the block position 2 below the block
		IBlockState state2 = this.world.getBlockState(pos2); // Gets the block state of the pos2
		Block block2 = state2.getBlock(); // Gets the block of the pos2

		BlockPos pos3 = pos2.offset(EnumFacing.EAST, 1); // Gets the block position 2 below, and 1 east of the block
		IBlockState state3 = this.world.getBlockState(pos3); // Gets the block state of the pos3
		Block block3 = state3.getBlock(); // Gets the block of pos3

		BlockPos pos4 = pos2.offset(EnumFacing.WEST, 1); // Gets the block position 2 below, and 1 west of the block
		IBlockState state4 = this.world.getBlockState(pos4); // Gets the block state of the pos4
		Block block4 = state4.getBlock(); // Gets the block of pos4

		BlockPos pos5 = pos2.offset(EnumFacing.NORTH, 1); // Gets the block position 2 below, and 1 north of the block
		IBlockState state5 = this.world.getBlockState(pos5); // Gets the block state of the pos5
		Block block5 = state5.getBlock(); // Gets the block of pos5

		BlockPos pos6 = pos2.offset(EnumFacing.SOUTH, 1); // Gets the block position 2 below, and 1 south of the block
		IBlockState state6 = this.world.getBlockState(pos6); // Gets the block state of the pos6
		Block block6 = state6.getBlock(); // Gets the block of pos6

		BlockPos pos7 = pos2.offset(EnumFacing.EAST, 2); // Gets the block position 2 below, and 2 east of the block
		IBlockState state7 = this.world.getBlockState(pos7); // Gets the block state of the pos7
		Block block7 = state7.getBlock(); // Gets the block of pos7

		BlockPos pos8 = pos2.offset(EnumFacing.WEST, 2); // Gets the block position 2 below, and 2 west of the block
		IBlockState state8 = this.world.getBlockState(pos8); // Gets the block state of the pos8
		Block block8 = state8.getBlock(); // Gets the block of pos8

		BlockPos pos9 = pos2.offset(EnumFacing.NORTH, 2); // Gets the block position 2 below, and 2 north of the block
		IBlockState state9 = this.world.getBlockState(pos9); // Gets the block state of the pos9
		Block block9 = state9.getBlock(); // Gets the block of pos9

		BlockPos pos10 = pos2.offset(EnumFacing.SOUTH, 2); // Gets the block position 2 below, and 2 south of the block
		IBlockState state10 = this.world.getBlockState(pos10); // Gets the block state of the pos10
		Block block10 = state10.getBlock(); // Gets the block of pos10

		BlockPos pos12 = pos8.offset(EnumFacing.EAST, 1); // Gets the block position 2 below, 2 west and 1 east of the
															// block
		IBlockState state12 = this.world.getBlockState(pos12); // Gets the block state of the pos12
		Block block12 = state12.getBlock(); // Gets the block of pos12

		BlockPos pos13 = pos9.offset(EnumFacing.EAST, 1); // Gets the block position 2 below, 2 north and 1 east of the
															// block
		IBlockState state13 = this.world.getBlockState(pos13); // Gets the block state of the pos13
		Block block13 = state13.getBlock(); // Gets the block of pos13

		BlockPos pos14 = pos10.offset(EnumFacing.EAST, 1); // Gets the block position 2 below, 2 south and 1 east of the
															// block
		IBlockState state14 = this.world.getBlockState(pos14); // Gets the block state of the pos14
		Block block14 = state14.getBlock(); // Gets the block of pos14

		BlockPos pos15 = pos.offset(EnumFacing.UP, 1); // Gets the block position up the block
		IBlockState state15 = this.world.getBlockState(pos15); // Gets the block state of the pos15
		Block block15 = state15.getBlock(); // Gets the block of the pos15

		BlockPos pos16 = pos.offset(EnumFacing.UP, 2); // Gets the block position 2 up the block
		IBlockState state16 = this.world.getBlockState(pos16); // Gets the block state of the pos16
		Block block16 = state16.getBlock(); // Gets the block of the pos16

		BlockPos pos17 = pos16.offset(EnumFacing.EAST, 1); // Gets the block position 2 up, and 1 east of the block
		IBlockState state17 = this.world.getBlockState(pos17); // Gets the block state of the pos
		Block block17 = state17.getBlock(); // Gets the block of pos

		BlockPos pos18 = pos16.offset(EnumFacing.NORTH, 1); // Gets the block position 2 up, and 1 north of the block
		IBlockState state18 = this.world.getBlockState(pos18); // Gets the block state of the pos
		Block block18 = state18.getBlock(); // Gets the block of pos

		BlockPos pos19 = pos16.offset(EnumFacing.SOUTH, 1); // Gets the block position 2 up, and 1 south of the block
		IBlockState state19 = this.world.getBlockState(pos19); // Gets the block state of the pos
		Block block19 = state19.getBlock(); // Gets the block of pos

		BlockPos pos20 = pos16.offset(EnumFacing.EAST, 2); // Gets the block position 2 up, and 2 east of the block
		IBlockState state20 = this.world.getBlockState(pos20); // Gets the block state of the pos
		Block block20 = state20.getBlock(); // Gets the block of pos

		BlockPos pos21 = pos16.offset(EnumFacing.WEST, 2); // Gets the block position 2 up, and 2 west of the block
		IBlockState state21 = this.world.getBlockState(pos21); // Gets the block state of the pos
		Block block21 = state21.getBlock(); // Gets the block of pos

		BlockPos pos22 = pos16.offset(EnumFacing.NORTH, 2); // Gets the block position 2 up, and 2 north of the block
		IBlockState state22 = this.world.getBlockState(pos22); // Gets the block state of the pos
		Block block22 = state22.getBlock(); // Gets the block of pos

		BlockPos pos23 = pos16.offset(EnumFacing.SOUTH, 2); // Gets the block position 2 up, and 2 south of the block
		IBlockState state23 = this.world.getBlockState(pos23); // Gets the block state of the pos
		Block block23 = state23.getBlock(); // Gets the block of pos

		BlockPos pos24 = pos22.offset(EnumFacing.EAST, 1); // Gets the block position 2 up, 2 west and 1 east of the
															// block
		IBlockState state24 = this.world.getBlockState(pos24); // Gets the block state of the pos
		Block block24 = state24.getBlock(); // Gets the block of pos

		BlockPos pos25 = pos23.offset(EnumFacing.EAST, 1); // Gets the block position 2 up, 2 north and 1 east of the
															// block
		IBlockState state25 = this.world.getBlockState(pos25); // Gets the block state of the pos
		Block block25 = state25.getBlock(); // Gets the block of pos

		BlockPos pos26 = pos24.offset(EnumFacing.EAST, 1); // Gets the block position 2 up, 2 south and 1 east of the
															// block
		IBlockState state26 = this.world.getBlockState(pos26); // Gets the block state of the pos
		Block block26 = state26.getBlock(); // Gets the block of pos

		BlockPos pos27 = pos16.offset(EnumFacing.WEST, 1); // Gets the block position 2 up, and 1 west of the block
		IBlockState state27 = this.world.getBlockState(pos27); // Gets the block state of the pos
		Block block27 = state27.getBlock(); // Gets the block of pos

		if (block1 == Blocks.OBSIDIAN && block2 == Blocks.OBSIDIAN && block3 == Blocks.OBSIDIAN
				&& block4 == Blocks.OBSIDIAN && block5 == Blocks.OBSIDIAN && block6 == Blocks.OBSIDIAN
				&& block7 == Blocks.OBSIDIAN && block8 == Blocks.OBSIDIAN && block9 == Blocks.OBSIDIAN
				&& block10 == Blocks.OBSIDIAN && block12 == Blocks.OBSIDIAN && block13 == Blocks.OBSIDIAN
				&& block14 == Blocks.OBSIDIAN && block15 == Blocks.OBSIDIAN && block16 == Blocks.OBSIDIAN
				&& block17 == Blocks.OBSIDIAN && block18 == Blocks.OBSIDIAN && block19 == Blocks.OBSIDIAN
				&& block20 == Blocks.OBSIDIAN && block21 == Blocks.OBSIDIAN && block22 == Blocks.OBSIDIAN
				&& block23 == Blocks.OBSIDIAN && block24 == Blocks.OBSIDIAN && block25 == Blocks.OBSIDIAN
				&& block27 == Blocks.OBSIDIAN) 
		{
			BlockPos pos28 = pos.add(2, 0, 0);
			BlockPos pos29 = pos.add(-2, 0, 0);
			BlockPos pos30 = pos.add(0, 0, 2);
			BlockPos pos31 = pos.add(0, 0, -2);

			BlockPos pos32 = pos.add(2, 1, 0);
			BlockPos pos33 = pos.add(-2, 1, 0);
			BlockPos pos34 = pos.add(0, 1, 2);
			BlockPos pos35 = pos.add(0, 1, -2);

			BlockPos pos36 = pos.add(2, -1, 0);
			BlockPos pos37 = pos.add(-2, -1, 0);
			BlockPos pos38 = pos.add(0, -1, 2);
			BlockPos pos39 = pos.add(0, -1, -2);

			this.world.setBlockState(pos28, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos29, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos30, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos31, BlockInit.GLOWING_OBSIDIAN.getDefaultState());

			this.world.setBlockState(pos32, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos33, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos34, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos35, BlockInit.GLOWING_OBSIDIAN.getDefaultState());

			this.world.setBlockState(pos36, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos37, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos38, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
			this.world.setBlockState(pos39, BlockInit.GLOWING_OBSIDIAN.getDefaultState());

			IBlockState state28 = world.getBlockState(pos28);
			IBlockState state29 = world.getBlockState(pos29);
			IBlockState state30 = world.getBlockState(pos30);
			IBlockState state31 = world.getBlockState(pos31);

			IBlockState state32 = world.getBlockState(pos32);
			IBlockState state33 = world.getBlockState(pos33);
			IBlockState state34 = world.getBlockState(pos34);
			IBlockState state35 = world.getBlockState(pos35);

			IBlockState state36 = world.getBlockState(pos36);
			IBlockState state37 = world.getBlockState(pos37);
			IBlockState state38 = world.getBlockState(pos38);
			IBlockState state39 = world.getBlockState(pos39);

			if (state28.getBlock() == BlockInit.GLOWING_OBSIDIAN && state29.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state30.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state31.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state32.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state33.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state34.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state35.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state36.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state37.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state38.getBlock() == BlockInit.GLOWING_OBSIDIAN
					&& state39.getBlock() == BlockInit.GLOWING_OBSIDIAN) 
			{
				this.world.setBlockState(pos1, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos2, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos3, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos4, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos5, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos6, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos7, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos8, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos9, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos10, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos12, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos13, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos14, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos15, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos16, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos17, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos18, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos19, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos20, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos21, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos22, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos23, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos24, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos25, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos26, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				this.world.setBlockState(pos27, BlockInit.GLOWING_OBSIDIAN.getDefaultState());
				active = true;
				if (block1 != BlockInit.GLOWING_OBSIDIAN && block2 != BlockInit.GLOWING_OBSIDIAN
						&& block3 != BlockInit.GLOWING_OBSIDIAN && block4 != BlockInit.GLOWING_OBSIDIAN
						&& block5 != BlockInit.GLOWING_OBSIDIAN && block6 != BlockInit.GLOWING_OBSIDIAN
						&& block7 != BlockInit.GLOWING_OBSIDIAN && block8 != BlockInit.GLOWING_OBSIDIAN
						&& block9 != BlockInit.GLOWING_OBSIDIAN && block10 != BlockInit.GLOWING_OBSIDIAN
						&& block12 != BlockInit.GLOWING_OBSIDIAN && block13 != BlockInit.GLOWING_OBSIDIAN
						&& block14 != BlockInit.GLOWING_OBSIDIAN && block15 != BlockInit.GLOWING_OBSIDIAN
						&& block16 != BlockInit.GLOWING_OBSIDIAN && block17 != BlockInit.GLOWING_OBSIDIAN
						&& block18 != BlockInit.GLOWING_OBSIDIAN && block19 != BlockInit.GLOWING_OBSIDIAN
						&& block20 != BlockInit.GLOWING_OBSIDIAN && block21 != BlockInit.GLOWING_OBSIDIAN
						&& block22 != BlockInit.GLOWING_OBSIDIAN && block23 != BlockInit.GLOWING_OBSIDIAN
						&& block24 != BlockInit.GLOWING_OBSIDIAN && block25 != BlockInit.GLOWING_OBSIDIAN
						&& block26 != BlockInit.GLOWING_OBSIDIAN && block27 != BlockInit.GLOWING_OBSIDIAN
						&& state28.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state29.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state30.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state31.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state32.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state33.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state34.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state35.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state36.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state37.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state38.getBlock() != BlockInit.GLOWING_OBSIDIAN
						&& state39.getBlock() != BlockInit.GLOWING_OBSIDIAN) 
				{
					active = false;
				}
			}
		}
	}

	public void netherReactorOn() 
	{
		int range;
		if (active == true) 
		{
			range = 100;
			System.out.println("Nether Reactor is active!");
		} 
		
		else if (active == false) 
		{
			range = 0;
			System.out.println("Nether Reactor is inactive!");
		}
	}

}
