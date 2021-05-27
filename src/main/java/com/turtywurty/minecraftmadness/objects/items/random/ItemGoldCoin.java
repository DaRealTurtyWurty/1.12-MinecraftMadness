package com.turtywurty.minecraftmadness.objects.items.random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class ItemGoldCoin extends Item implements IHasModel
{
	public int value;
	
	public ItemGoldCoin(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		value = 10;
		
		ItemInit.ITEMS.add(this);
	}	
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
