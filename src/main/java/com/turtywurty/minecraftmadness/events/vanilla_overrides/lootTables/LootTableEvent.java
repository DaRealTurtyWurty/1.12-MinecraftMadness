package com.turtywurty.minecraftmadness.events.vanilla_overrides.lootTables;

import java.util.Random;

import com.turtywurty.minecraftmadness.entity.frog.EntityFrog;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableEvent 
{
	@SubscribeEvent
	public void customLootTableEvent(LivingDropsEvent event)
	{
		Random rand = new Random();
		if(event.getEntityLiving() instanceof EntityFrog)
		{
			if(rand.nextInt(5) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(ItemInit.FROG_LEGS), 0.0f);
			}
		}
		
		if(event.getEntityLiving() instanceof EntityEndermite)
		{
			if(rand.nextInt(10) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(ItemInit.ENDER_SHARD), 0.0f);
			}
		}
	}
}
