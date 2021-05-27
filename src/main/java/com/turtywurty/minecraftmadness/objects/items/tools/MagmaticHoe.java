package com.turtywurty.minecraftmadness.objects.items.tools;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;

public class MagmaticHoe extends ToolHoe
{
	public MagmaticHoe(String name, ToolMaterial material) 
	{
		super(name, material);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
	}
}
