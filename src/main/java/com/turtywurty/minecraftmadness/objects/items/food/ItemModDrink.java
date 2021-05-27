package com.turtywurty.minecraftmadness.objects.items.food;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemModDrink extends ItemFood implements IHasModel
{

	public ItemModDrink(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
	   return EnumAction.DRINK;
	}
	
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
