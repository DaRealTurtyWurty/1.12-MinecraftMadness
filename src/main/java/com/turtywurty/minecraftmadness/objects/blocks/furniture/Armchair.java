package com.turtywurty.minecraftmadness.objects.blocks.furniture;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Armchair extends Block implements IHasModel 
{
	public static final AxisAlignedBB ARMCHAIR = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)); 
	}
	
	public Armchair(String name, Material material) 
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
    {
		EnumFacing facing = EnumFacing.getFront(meta);

		if(facing.getAxis()==EnumFacing.Axis.Y) 
		{
			facing=EnumFacing.NORTH;
		}
		return getDefaultState().withProperty(FACING, facing);
    }
	
	@Override
	public int getMetaFromState(IBlockState state) 
    {
	    return ((EnumFacing) state.getValue(FACING)).getIndex();
    }
	    
	@Override
	protected BlockStateContainer createBlockState() 
    {
	    return new BlockStateContainer(this, new IProperty[]{FACING});
    }
	   
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	  
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
	    return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;       
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos)
	{    
		if (!this.canBlockStay(worldIn, pos))
	    {    
			worldIn.setBlockToAir(pos);
			if(block == BlockInit.ARMCHAIR_BLACK)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_BLACK, 1));
			}
			if(block == BlockInit.ARMCHAIR_BLUE)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_BLUE, 1));
			}
			if(block == BlockInit.ARMCHAIR_BROWN)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_BROWN, 1));
			}
			if(block == BlockInit.ARMCHAIR_CYAN)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_CYAN, 1));
			}
			if(block == BlockInit.ARMCHAIR_GRAY)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_GRAY, 1));
			}
			if(block == BlockInit.ARMCHAIR_GREEN)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_GREEN, 1));
			}
			if(block == BlockInit.ARMCHAIR_LIGHT_BLUE)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_LIGHT_BLUE, 1));
			}
			if(block == BlockInit.ARMCHAIR_LIGHT_GRAY)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_LIGHT_GRAY, 1));
			}
			if(block == BlockInit.ARMCHAIR_LIME)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_LIME, 1));
			}
			if(block == BlockInit.ARMCHAIR_MAGENTA)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_MAGENTA, 1));
			}
			if(block == BlockInit.ARMCHAIR_ORANGE)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_ORANGE, 1));
			}
			if(block == BlockInit.ARMCHAIR_PINK)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_PINK, 1));
			}
			if(block == BlockInit.ARMCHAIR_PURPLE)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_PURPLE, 1));
			}
			if(block == BlockInit.ARMCHAIR_RED)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_RED, 1));
			}
			if(block == BlockInit.ARMCHAIR_WHITE)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_WHITE, 1));
			}
			if(block == BlockInit.ARMCHAIR_YELLOW)
			{
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ARMCHAIR_YELLOW, 1));
			}
	    }      
	}

	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return ARMCHAIR;
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}