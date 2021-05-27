package com.turtywurty.minecraftmadness.objects.items.seeds;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemMutatedSugarcane extends Item implements IHasModel, IPlantable 
{
	public ItemMutatedSugarcane(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		ItemStack itemstack = player.getHeldItem(hand);
		net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
		if(facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) 
		{
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
				IBlockState iblockstate = worldIn.getBlockState(pos.offset(enumfacing));

                if (iblockstate.getMaterial() == Material.WATER || iblockstate.getBlock() == Blocks.FROSTED_ICE)
                {
                	IBlockState state1 = worldIn.getBlockState(pos);
        			worldIn.playSound(player, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0f, 0.8f);
        			worldIn.setBlockState(pos.up(), BlockInit.MUTATED_SUGARCANE.getDefaultState());
        			itemstack.shrink(1);
        			return EnumActionResult.SUCCESS;
                }
            }
		} 	
		else 
		{
			return EnumActionResult.FAIL;
		}
		return EnumActionResult.FAIL;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return EnumPlantType.Beach;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) 
	{
		return BlockInit.MUTATED_SUGARCANE.getDefaultState();
	}
}
