package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import java.util.Random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MutatedFlower extends BlockFlower implements IHasModel
{
	public MutatedFlower(String name, Material material)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(0.01f);
		setResistance(2.0f);
		setHarvestLevel("hand", -1);
		setLightOpacity(0);
		setSoundType(SoundType.PLANT);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public EnumFlowerColor getBlockType() 
	{
		return EnumFlowerColor.YELLOW;
	}
	
	@Override
	public int quantityDropped(Random random) 
	{
		return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) 
	{
		if(state.getBlock() == this)
		{
			IBlockState soil = worldIn.getBlockState(pos.down());
			if(soil.getBlock() == BlockInit.MUTATED_GRASS || soil.getBlock() == BlockInit.MUTATED_DIRT)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
