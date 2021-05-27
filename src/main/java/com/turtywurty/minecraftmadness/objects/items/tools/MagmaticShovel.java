package com.turtywurty.minecraftmadness.objects.items.tools;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;

public class MagmaticShovel extends ToolShovel
{
	public MagmaticShovel(String name, ToolMaterial material) 
	{
		super(name, material);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
	}
}
