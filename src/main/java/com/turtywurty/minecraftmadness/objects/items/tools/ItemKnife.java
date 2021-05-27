package com.turtywurty.minecraftmadness.objects.items.tools;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemKnife extends ItemSword implements IHasModel
{
	public ItemKnife(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemStackLimit() 
	{
		return 1;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}