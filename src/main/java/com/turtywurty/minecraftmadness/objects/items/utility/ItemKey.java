package com.turtywurty.minecraftmadness.objects.items.utility;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemKey extends Item implements IHasModel 
{
	public ItemKey(String name) 
	{
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	/*@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if (facing != EnumFacing.UP)
        {
            return EnumActionResult.FAIL;
        }
		else
		{
			IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            ItemStack itemStack = player.getHeldItem(hand);
            if(itemStack == new ItemStack(this))
            {
            	if(block instanceof BlockDoor)
            	{
            		if(block.getDefaultState().getProperty() == block.getDefaultState().getPropertyBool(CLOSED))
            		{
            			block.setDefaultState().withProperty(PropertyBool.CLOSED, OPEN);
            		}
            		else
            		{
            			return EnumActionResult.FAIL;
            		}
            	}
            }
		}
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	*/
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
