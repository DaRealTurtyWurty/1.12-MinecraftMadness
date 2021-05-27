package com.turtywurty.minecraftmadness.recipes;

import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRecipes 
{
	public static void init()
	{
		//Tomato
		ItemStack tomato_seeds = new ItemStack(ItemInit.TOMATO_SEEDS, 3);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "tomato_seeds"), null, tomato_seeds, Ingredient.fromStacks(new ItemStack(ItemInit.TOMATO, 1)));
		
		//Lemon
		ItemStack lemon_seeds = new ItemStack(ItemInit.LEMON_SEEDS, 3);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "lemon_seeds"), null, lemon_seeds, Ingredient.fromStacks(new ItemStack(ItemInit.LEMON, 1)));
		
		//Sugarcane
		ItemStack sugarcane = new ItemStack(Items.REEDS, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "sugarcane"), null, sugarcane, Ingredient.fromStacks(new ItemStack(BlockInit.SUGARCANE_BLOCK, 1)));
				
		//Charcoal
		ItemStack charcoal = new ItemStack(Items.COAL, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "charcoal"), null, charcoal, Ingredient.fromStacks(new ItemStack(BlockInit.CHARCOAL_BLOCK, 1)));
		
		//Ruby
		ItemStack ruby = new ItemStack(ItemInit.RUBY, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "ruby"), null, ruby, Ingredient.fromStacks(new ItemStack(BlockInit.RUBY_BLOCK, 1)));
		
		//Tin
		ItemStack tin = new ItemStack(ItemInit.TIN_INGOT, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "tin"), null, tin, Ingredient.fromStacks(new ItemStack(BlockInit.TIN_BLOCK, 1)));
				
		//Sapphire
		ItemStack sapphire = new ItemStack(ItemInit.SAPPHIRE, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "sapphire"), null, sapphire, Ingredient.fromStacks(new ItemStack(BlockInit.SAPPHIRE_BLOCK, 1)));
		
		//Copper
		ItemStack copper = new ItemStack(ItemInit.COPPER_INGOT, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "copper"), null, copper, Ingredient.fromStacks(new ItemStack(BlockInit.COPPER_BLOCK, 1)));
						
		//Silver
		ItemStack silver = new ItemStack(ItemInit.SILVER_INGOT, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "silver"), null, silver, Ingredient.fromStacks(new ItemStack(BlockInit.SILVER_BLOCK, 1)));
		
		//Silver
		ItemStack uranium = new ItemStack(ItemInit.URANIUM_INGOT, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "uranium"), null, uranium, Ingredient.fromStacks(new ItemStack(BlockInit.URANIUM_BLOCK, 1)));
		
		//Ruby Chunk
		ItemStack rubyc = new ItemStack(ItemInit.RUBY_CHUNK, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "rubyc"), null, rubyc, Ingredient.fromStacks(new ItemStack(ItemInit.RUBY, 1)));
				
		//Tin Nugget
		ItemStack tinn = new ItemStack(ItemInit.TIN_NUGGET, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "tinn"), null, tinn, Ingredient.fromStacks(new ItemStack(ItemInit.TIN_INGOT, 1)));
						
		//Sapphire Chunk
		ItemStack sapphirec = new ItemStack(ItemInit.SAPPHIRE_CHUNK, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "sapphirec"), null, sapphirec, Ingredient.fromStacks(new ItemStack(ItemInit.SAPPHIRE, 1)));
				
		//Copper Nugget
		ItemStack coppern = new ItemStack(ItemInit.COPPER_NUGGET, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "coppern"), null, coppern, Ingredient.fromStacks(new ItemStack(ItemInit.COPPER_INGOT, 1)));
								
		//Silver Nugget
		ItemStack silvern = new ItemStack(ItemInit.SILVER_NUGGET, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "silvern"), null, silvern, Ingredient.fromStacks(new ItemStack(ItemInit.SILVER_INGOT, 1)));		
	
		//Uranium Nugget
		ItemStack uraniumn = new ItemStack(ItemInit.URANIUM_NUGGET, 1, 9);
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID + "uraniumn"), null, uraniumn, Ingredient.fromStacks(new ItemStack(ItemInit.URANIUM_INGOT, 1)));	
	}
}