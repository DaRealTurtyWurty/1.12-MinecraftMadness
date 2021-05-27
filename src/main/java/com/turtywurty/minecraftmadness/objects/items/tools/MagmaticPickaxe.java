package com.turtywurty.minecraftmadness.objects.items.tools;

import java.util.Random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagmaticPickaxe extends ToolPickaxe
{
	public MagmaticPickaxe(String name, ToolMaterial material) 
	{
		super(name, material);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
	}
}
