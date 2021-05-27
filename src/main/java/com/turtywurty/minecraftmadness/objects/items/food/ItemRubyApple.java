package com.turtywurty.minecraftmadness.objects.items.food;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRubyApple extends ItemFood implements IHasModel
{
	public ItemRubyApple(int amount, float saturation, boolean isWolfFood, String name) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, EntityPlayer player, World worldIn, EntityLivingBase entityLiving) 
	{
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 7000, 2));
		player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 7000, 4));
		return super.onItemUseFinish(stack, worldIn, player);
	}
	
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
