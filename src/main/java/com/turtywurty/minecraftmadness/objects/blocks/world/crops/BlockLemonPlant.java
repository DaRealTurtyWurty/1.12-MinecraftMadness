package com.turtywurty.minecraftmadness.objects.blocks.world.crops;

import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLemonPlant extends BlockCrops 
{
	private static final AxisAlignedBB[] lemon_plant= new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
	
	public BlockLemonPlant(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
		BlockInit.BLOCKS.add(this);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if (!worldIn.isRemote)
		{
			if(this.isMaxAge(state))
			{
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.LEMON_SEEDS, 2)));
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.LEMON, 1)));
				worldIn.setBlockState(pos, this.withAge(0));
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected Item getSeed() 
	{
		return ItemInit.LEMON_SEEDS;
	}
	
	@Override
	protected Item getCrop() 
	{
		return ItemInit.LEMON_SEEDS;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return lemon_plant[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
}
