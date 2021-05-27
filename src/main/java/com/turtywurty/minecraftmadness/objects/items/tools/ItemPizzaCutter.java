package com.turtywurty.minecraftmadness.objects.items.tools;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPizzaCutter extends Item implements IHasModel 
{
	public ItemPizzaCutter(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) 
	{
		return 110;
	}
	
	@Override
	public int getItemStackLimit() 
	{
		return 1;
	}
	
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
