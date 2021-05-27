package com.turtywurty.minecraftmadness.objects.blocks.random;

import java.util.Random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class FertilizedFarmland extends BlockFarmland implements IHasModel 
{
	public FertilizedFarmland(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this.setRegistryName(this.getRegistryName())));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
	{
		Block block = state.getBlock();
		BlockPos pos1 = pos.up();
		IBlockState state1 = worldIn.getBlockState(pos1);
		Block block1 = state1.getBlock();
		if(block1 instanceof IGrowable || block1 instanceof IPlantable || block1 == Blocks.MYCELIUM || block1 == Blocks.CHORUS_FLOWER) 
		{
			worldIn.scheduleBlockUpdate(pos1, block1, 0, 1);
		}
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
