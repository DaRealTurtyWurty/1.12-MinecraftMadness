package com.turtywurty.minecraftmadness.objects.items.mod_book;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemModBook extends Item implements IHasModel
{
	public ItemModBook(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn, BlockPos pos) 
	{
		playerIn.openGui(MinecraftMadness.instance, Reference.GUI_MOD_BOOK, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
