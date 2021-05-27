package com.turtywurty.minecraftmadness.objects.items.orbs;

import java.util.List;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.entity.orbs.EntityRegenerationOrb;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class RegenerationOrb extends Item implements IHasModel
{
	public RegenerationOrb(String name)
	{
		this.maxStackSize = 16;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) 
	{
		ItemStack itemstack = player.getHeldItem(handIn);
		if (player.isSneaking())
        {
            EntityRegenerationOrb entityregenerationorb = new EntityRegenerationOrb(worldIn, player);
            entityregenerationorb.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityregenerationorb);
    		player.getHeldItem(handIn).shrink(1);
        }
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1200, 2));
		player.getHeldItem(handIn).shrink(1);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add("Shift + Right-Click to throw(Can only give effect to vanilla mobs!), Right-Click to use on yourself!");
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
