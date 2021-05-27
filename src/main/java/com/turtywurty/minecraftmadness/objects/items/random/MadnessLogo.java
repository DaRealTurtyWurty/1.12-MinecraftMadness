package com.turtywurty.minecraftmadness.objects.items.random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class MadnessLogo extends Item implements IHasModel
{
	public MadnessLogo(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}