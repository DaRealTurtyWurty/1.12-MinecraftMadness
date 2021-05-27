package com.turtywurty.minecraftmadness.objects.blocks.random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LandmineBlock extends Block implements IHasModel
{
	public LandmineBlock(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(blockHardness);
		setResistance(blockResistance);
		setLightLevel(lightValue);
		setLightOpacity(lightOpacity);
		setSoundType(blockSoundType);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) 
	{
		IBlockState state = worldIn.getBlockState(pos);
		if(entityIn instanceof EntityPlayer)
		{
			if(state.getBlock() == this)
			{
				worldIn.setBlockToAir(pos);
				worldIn.createExplosion(entityIn, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, 1.5F, true);
			}
		}
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
