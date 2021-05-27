package com.turtywurty.minecraftmadness.objects.items.food;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemDorito extends ItemFood implements IHasModel
{

	public ItemDorito(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		ItemInit.ITEMS.add(this);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return 35;
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	/*@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		BlockPos bedLocation = playerIn.getBedLocation() == null ? worldIn.getSpawnPoint() : playerIn.getBedLocation();
		while((!worldIn.canBlockSeeSky(bedLocation) || worldIn.getLight(bedLocation) < 9) && !worldIn.getBlockState(bedLocation).isFullBlock())
		{
			bedLocation = bedLocation.up();
		}
		playerIn.setPositionAndUpdate(bedLocation.getX(), bedLocation.getY(), bedLocation.getZ());
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}*/
}

