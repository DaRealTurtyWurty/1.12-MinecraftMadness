package com.turtywurty.minecraftmadness.objects.items.bows;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class ItemLeatherBow extends ItemBow implements IHasModel
{
	public ItemLeatherBow(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setMaxDamage(50);
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemEnchantability() 
	{
		return 3;
	}
	
	@Override
	public void setDamage(ItemStack stack, int damage) 
	{
		damage = 2;
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
