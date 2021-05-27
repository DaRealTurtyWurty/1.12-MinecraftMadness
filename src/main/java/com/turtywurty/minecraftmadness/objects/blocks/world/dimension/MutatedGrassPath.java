package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.BlockGrassPath;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MutatedGrassPath extends BlockGrassPath implements IHasModel
{
	public MutatedGrassPath(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
