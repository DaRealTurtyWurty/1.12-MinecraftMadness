package com.turtywurty.minecraftmadness.objects.blocks.blender;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlenderRecipes 
{
	private static final BlenderRecipes INSTANCE = new BlenderRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> blendingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	
	public static BlenderRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private BlenderRecipes() 
	{
		addBlendingRecipe(new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.BANANA), new ItemStack(ItemInit.KIWI_BANANA_S));
		addBlendingRecipe(new ItemStack(ItemInit.BANANA), new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.KIWI_BANANA_S));
		addBlendingRecipe(new ItemStack(ItemInit.KIWI), new ItemStack(Items.APPLE), new ItemStack(ItemInit.KIWI_APPLE_S));
		addBlendingRecipe(new ItemStack(Items.APPLE), new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.KIWI_APPLE_S));
		addBlendingRecipe(new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.GREEN_APPLE), new ItemStack(ItemInit.KIWI_GAPPLE_S));
		addBlendingRecipe(new ItemStack(ItemInit.GREEN_APPLE), new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.KIWI_GAPPLE_S));
		addBlendingRecipe(new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.ORANGE), new ItemStack(ItemInit.KIWI_ORANGE_S));
		addBlendingRecipe(new ItemStack(ItemInit.ORANGE), new ItemStack(ItemInit.KIWI), new ItemStack(ItemInit.KIWI_ORANGE_S));
	}
	
	public void addBlendingRecipe(ItemStack input1, ItemStack input2, ItemStack result) 
	{
		if(getBlendingResult(input1, input2) != ItemStack.EMPTY) return;
		this.blendingList.put(input1, input2, result);
	}
	
	public ItemStack getBlendingResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.blendingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualBlendingList() 
	{
		return this.blendingList;
	}
}
