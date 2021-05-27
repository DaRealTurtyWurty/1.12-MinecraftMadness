package com.turtywurty.minecraftmadness.events;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class MapCauldronEvent
{
	@SubscribeEvent
	public static void getEmptyMapFromCauldron(RightClickBlock event)
	{
		EntityPlayer player = event.getEntityPlayer();
		Item item = player.getHeldItemMainhand().getItem();
		ItemStack stack = player.getHeldItemMainhand();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		int count = stack.getCount();
		if(block == Blocks.CAULDRON && item == Items.FILLED_MAP)
		{
			int i = ((Integer)state.getValue(BlockCauldron.LEVEL)).intValue();
			if(i > 0)
			{
				player.addStat(StatList.CAULDRON_USED);
				world.setBlockState(pos, state.withProperty(BlockCauldron.LEVEL, i - 1));
				player.addItemStackToInventory(new ItemStack(Items.MAP));
				stack.shrink(1);
			}
		}
	}
}
