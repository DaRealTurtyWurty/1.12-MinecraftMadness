package com.turtywurty.minecraftmadness.objects.items.random;

import javax.annotation.Nullable;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnderShard extends Item implements IHasModel
{
	public ItemEnderShard(String name) 
	{	
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		addPropertyOverride(new ResourceLocation(Reference.MOD_ID + ":ender_shard"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                ItemStack itemStack = new ItemStack(ItemInit.ENDER_SHARD);
                if(itemStack.getCount() == 1)
                {
                	return 0.0f;
                }
                if(itemStack.getCount() == 2)
                {
                	return 0.125f;
                }
                if(itemStack.getCount() == 3)
                {
                	return 0.25f;
                }
                return 0;
            }
        });
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
