package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import java.util.Random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MutatedGrass extends BlockBush implements IHasModel
{
	public MutatedGrass(String name, Material material) 
	{
		super(Material.VINE);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == BlockInit.MUTATED_DIRT || state.getBlock() == BlockInit.MUTATED_GRASS;
    }
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) 
	{
		IBlockState iBlockState = worldIn.getBlockState(pos);
		if(iBlockState.getBlock() == BlockInit.MUTATED_GRASS || iBlockState.getBlock() == BlockInit.MUTATED_DIRT)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
	{
		IBlockState state1 = worldIn.getBlockState(pos.down());
		if(state1.getBlock() != BlockInit.MUTATED_GRASS|| state1.getBlock() == BlockInit.MUTATED_DIRT)
		{
			worldIn.setBlockToAir(pos);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return null;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}