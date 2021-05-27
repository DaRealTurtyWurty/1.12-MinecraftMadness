package com.turtywurty.minecraftmadness.events;

import com.turtywurty.minecraftmadness.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CropFertilizedGrowthEvent
{
	@SubscribeEvent
	public void growOnFertlizedSoil(CropGrowEvent event)
	{
		World worldIn = event.getWorld();
			
		BlockPos pos = event.getPos().down();
		BlockPos pos1 = event.getPos();
		IBlockState state = worldIn.getBlockState(pos);
		Block block = event.getState().getBlock();
		if(block instanceof IGrowable)
		{
			 if(((IGrowable)block).canGrow(worldIn, pos1, state, worldIn.isRemote))
			 {
				 int age = ((Integer)state.getValue(BlockCrops.AGE)).intValue();
			 }
		}
	}
}