package com.turtywurty.minecraftmadness.recipes;

import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes
{
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(Items.EGG), new ItemStack(ItemInit.FRIED_EGG), 0.6F); //TODO Frying Pan
		GameRegistry.addSmelting(new ItemStack(Items.BREAD), new ItemStack(ItemInit.TOAST), 0.6F); //TODO Toaster
		GameRegistry.addSmelting(new ItemStack(BlockInit.RUBY_ORE), new ItemStack(ItemInit.RUBY), 1.2F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.COPPER_ORE), new ItemStack(ItemInit.COPPER_INGOT), 1.2F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.AMETHYST_ORE), new ItemStack(ItemInit.AMETHYST), 1.2F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.TIN_ORE), new ItemStack(ItemInit.TIN_INGOT), 1.2F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.URANIUM_ORE), new ItemStack(ItemInit.URANIUM_INGOT), 1.2F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.SAPPHIRE_ORE), new ItemStack(ItemInit.SAPPHIRE), 1.2F);
		GameRegistry.addSmelting(new ItemStack(Blocks.OBSIDIAN), new ItemStack(ItemInit.OBSIDIAN_INGOT), 1.0F);
	}
}