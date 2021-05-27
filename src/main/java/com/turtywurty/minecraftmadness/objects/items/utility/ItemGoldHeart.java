package com.turtywurty.minecraftmadness.objects.items.utility;

import java.util.List;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemGoldHeart extends Item implements IHasModel
{
	public ItemGoldHeart(String name)
	{
		this.maxStackSize = 1;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add("This will add 8 hearts for 7 minutes if you right click. Can only hold stack of 1!");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) 
	{
		player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 8000, 3));
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 8000, 3));
		player.getHeldItem(handIn).shrink(1);
		return super.onItemRightClick(worldIn, player, handIn);
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
