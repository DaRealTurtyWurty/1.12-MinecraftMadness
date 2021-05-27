package com.turtywurty.minecraftmadness.objects.items.utility;

import java.util.List;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.commands.teleportDim.CustomTeleporter;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemRing extends Item implements IHasModel
{
	public ItemRing(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		if(player.dimension == 0 || player.dimension == 1)
		{
			CustomTeleporter.teleportToDimension(player, -1, player.posX, player.posY, player.posZ);
		}
		
		else if(player.dimension == -1)
		{
			CustomTeleporter.teleportToDimension(player, 0, player.posX, player.posY, player.posZ);
		}
		return super.onItemRightClick(world, player, hand);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("On right-clicking this ring it will bring you to the nether and visa-versa.");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
