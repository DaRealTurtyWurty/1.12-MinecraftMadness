package com.turtywurty.minecraftmadness.util.handlers;

import com.turtywurty.minecraftmadness.events.vanilla_overrides.leaves.ApplesFromLeavesEvent;
import com.turtywurty.minecraftmadness.events.vanilla_overrides.seeds.SeedsFromGrassEvent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsHandler 
{	
	public static void registerEvents()
	{
		SeedsFromGrassEvent seedEvent = new SeedsFromGrassEvent();
		ApplesFromLeavesEvent appleEvent = new ApplesFromLeavesEvent();
		
		MinecraftForge.EVENT_BUS.register(seedEvent);
		MinecraftForge.EVENT_BUS.register(appleEvent);
	}
}
