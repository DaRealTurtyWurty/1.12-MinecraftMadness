package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.objects.items.tools.ToolHoe;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class MutatedDirt extends Block implements IHasModel
{
	public MutatedDirt(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(0.5f);
		setResistance(2.5f);
		setHarvestLevel("hand", -1);
		setLightLevel(0.0f);
		setLightOpacity(0);
		setSoundType(SoundType.GROUND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		if(plantable.getPlant(world, pos).getBlock() == BlockInit.MUTATED_GRASS_PLANT || plantable.getPlant(world, pos).getBlock() == BlockInit.MUTATED_SUGARCANE || plantable.getPlant(world, pos).getBlock() == BlockInit.MUTATED_FLOWER)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		Item item = playerIn.getHeldItemMainhand().getItem();
		ItemStack itemstack = playerIn.getHeldItemMainhand();
		if (!playerIn.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return false;
        }
		
		if(item instanceof ToolHoe || item instanceof ItemHoe)
		{
			worldIn.setBlockState(pos, BlockInit.MUTATED_FARMLAND.getDefaultState(), 11);
			worldIn.playSound(playerIn, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
			itemstack.damageItem(1, playerIn);
			return true;
		}
		return false;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
