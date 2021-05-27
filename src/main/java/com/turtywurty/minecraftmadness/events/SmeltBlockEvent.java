package com.turtywurty.minecraftmadness.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class SmeltBlockEvent 
{
	/**Things that should not be auto smelted because they break*/
	static List<Block> blacklist = new ArrayList<Block>();
	
	/**Primary way to make Tools/Items that can auto smelt*/
	static List<Item> tools = new ArrayList<Item>();
	
	/**Secondary way to make Tools/Items that can auto smelt*/
	public interface IAutoSmelt {}
	
	static Random rand = new Random();
	
	/**
	 * Fill Arrays
	 */
	static
	{
		blacklist.add(Blocks.GRASS);
		tools.add(ItemInit.PICKAXE_MAGMATIC);
		tools.add(ItemInit.AXE_MAGMATIC);
		tools.add(ItemInit.SHOVEL_MAGMATIC);
		tools.add(ItemInit.HOE_MAGMATIC);
		tools.add(ItemInit.SWORD_MAGMATIC);
	}	
	
	/**
	 * Handle the actual event
	 */
	@SubscribeEvent
	public static void onHarvest(HarvestDropsEvent event)
	{
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		Block block = world.getBlockState(pos).getBlock();
		if(blacklist.contains(block)) 
		{
			return;
		}
		
		EntityPlayer harvester = event.getHarvester();
		if(harvester==null) 
		{
			return;
		}
		
		ItemStack stack = harvester.getHeldItemMainhand();
		if(harvester.isCreative() || !harvester.canPlayerEdit(pos, harvester.getHorizontalFacing(), stack)) 
		{
			return;
		}
		
		if(!tools.contains(stack.getItem()) && !(stack.getItem() instanceof IAutoSmelt))
		{
			return;
		}
		
		IBlockState state = event.getState();
		int fortune = event.getFortuneLevel();
		ItemStack result = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(state.getBlock().getItemDropped(state, rand, fortune)));
		if(result==ItemStack.EMPTY) 
		{
			return;
		}
		
		event.getDrops().clear();
        event.getDrops().add(result);
	}
}
