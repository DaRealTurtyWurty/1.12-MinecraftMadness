package com.turtywurty.minecraftmadness.objects.blocks.world;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockDam extends Block implements IHasModel 
{
	public BlockDam(String name, Material material) 
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(7.0f);
		setHarvestLevel("axe", -1);
		setResistance(1.4f);
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
