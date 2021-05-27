package com.turtywurty.minecraftmadness.objects.blocks.oven;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OvenRecipes 
{
	private static final OvenRecipes COOKING_BASE = new OvenRecipes();
	private final Map<ItemStack, ItemStack> cookingList = Maps.<ItemStack, ItemStack>newHashMap();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static OvenRecipes instance()
    {
        return COOKING_BASE;
    }
	
	private OvenRecipes()
	{
		this.addCooking(ItemInit.RAW_BURGER, new ItemStack(ItemInit.COOKED_BURGER), 0.35f);
		this.addCooking(ItemInit.RAW_SAUSAGE, new ItemStack(ItemInit.SAUSAGE), 0.35f);
		this.addCooking(ItemInit.RAW_VENISON, new ItemStack(ItemInit.COOKED_VENISON), 0.35f);
		this.addCooking(ItemInit.SKINNED_FROG_LEGS, new ItemStack(ItemInit.COOKED_FROG_LEGS), 0.35f);
		this.addCooking(ItemInit.BACON, new ItemStack(ItemInit.COOKED_BACON), 0.35f);
		this.addCooking(Items.BEEF, new ItemStack(Items.COOKED_BEEF), 0.3f);
		this.addCooking(Items.RABBIT, new ItemStack(Items.COOKED_RABBIT), 0.3f);
		this.addCooking(Items.CHICKEN, new ItemStack(Items.COOKED_CHICKEN), 0.3f);
		this.addCooking(Items.FISH, new ItemStack(Items.COOKED_FISH), 0.3f);
		this.addCooking(Items.MUTTON, new ItemStack(Items.COOKED_MUTTON), 0.3f);
		this.addCooking(Items.PORKCHOP, new ItemStack(Items.COOKED_PORKCHOP), 0.3f);
		this.addCooking(Items.CHORUS_FRUIT, new ItemStack(Items.CHORUS_FRUIT_POPPED), 0.8f);
		this.addCooking(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.3f);
	}
	
	public void addCookingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addCooking(Item.getItemFromBlock(input), stack, experience);
    }
	
	public void addCooking(Item input, ItemStack stack, float experience)
    {
        this.addCookingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }
	
	public void addCookingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getCookingResult(input) != ItemStack.EMPTY) 
        { 
        	net.minecraftforge.fml.common.FMLLog.log.info("Ignored cooking recipe with conflicting input: {} = {}", input, stack); return; 
        }
        this.cookingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }
	
	public ItemStack getCookingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.cookingList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCookingList()
    {
        return this.cookingList;
    }

    public float getCookingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
