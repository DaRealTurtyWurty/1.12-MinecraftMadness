package com.turtywurty.minecraftmadness.objects.items.food;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemTomatoSoup extends ItemFood implements IHasModel 
{
	public ItemTomatoSoup(String name, int amount, boolean isWolfFood) 
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
