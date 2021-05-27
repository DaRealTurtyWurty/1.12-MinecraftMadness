package com.turtywurty.minecraftmadness.tabs;

import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class MadnessTab extends CreativeTabs
{
	public MadnessTab(String label) 
	{
		super("minecraftmadnesstab");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.MADNESS_LOGO);
	}
	
	@Override
	public ResourceLocation getBackgroundImage() 
	{
		return new ResourceLocation(Reference.MOD_ID + ":textures/gui/container/creative_inventory/tab_minecraftmadness.png");
	}
	
	@Override
	public boolean hasSearchBar() 
	{
		return true;
	}
	
	@Override
	public int getSearchbarWidth() 
	{
		return 89;
	}
}
