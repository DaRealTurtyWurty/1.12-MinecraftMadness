package com.turtywurty.minecraftmadness.objects.blocks.machines;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.commands.teleportDim.CustomTeleporter;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTeleporter extends Block implements IHasModel
{
	public BlockTeleporter(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(2.0f);
		setHarvestLevel("pickaxe", 0);
		setResistance(30.0f);
		setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			if(playerIn.dimension == 0)
			{
				CustomTeleporter.teleportToDimension(playerIn, -1, pos.getX(), pos.getY(), pos.getY());
				return true;
			}
			if(playerIn.dimension == -1)
			{
				CustomTeleporter.teleportToDimension(playerIn, 0, pos.getX(), pos.getY(), pos.getY());
				return true;
			}
			if(playerIn.dimension == 1)
			{
				CustomTeleporter.teleportToDimension(playerIn, 0, pos.getX(), pos.getY(), pos.getY());
				return true;
			}
			if(playerIn.dimension == 2)
			{
				CustomTeleporter.teleportToDimension(playerIn, 0, pos.getX(), pos.getY(), pos.getY());
				return true;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) 
	{
		CustomTeleporter.teleportToDimension(playerIn, 1, pos.getX(), pos.getY(), pos.getY());
		super.onBlockClicked(worldIn, pos, playerIn);
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
