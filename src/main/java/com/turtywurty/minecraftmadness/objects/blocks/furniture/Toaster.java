package com.turtywurty.minecraftmadness.objects.blocks.furniture;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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

public class Toaster extends Block implements IHasModel
{
	public static final AxisAlignedBB TOASTER = new AxisAlignedBB(0.1875D, 0.0D, 0.3125D, 0.8125D, 0.4375D, 0.6875D);
	public static final AxisAlignedBB TOASTER_WE = new AxisAlignedBB(0.3125D, 0.0D, 0.1875D, 0.6875D, 0.4375D, 0.8125D);
	
	public Toaster(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(8.0f);
		setHarvestLevel("pickaxe", -1);
		setResistance(40.0f);
		setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH)); 
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
    {
		EnumFacing facing = EnumFacing.getFront(meta);

		if(facing.getAxis()==EnumFacing.Axis.Y) 
		{
			facing=EnumFacing.SOUTH;
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

	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
	{    
		if (!this.canBlockStay(world, pos))
	    {    
			world.setBlockToAir(pos);
			if(block == BlockInit.TOASTER)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.TOASTER, 1));
			}
	    }      
	}

	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	  
	@Override
    public BlockRenderLayer getBlockLayer() 
	{
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		switch(((EnumFacing)state.getValue(FACING)))
        {
            case SOUTH:
            default:
                return TOASTER;
            case NORTH:
                return TOASTER;
            case EAST:
                return TOASTER_WE;
            case WEST:
                return TOASTER_WE;
        }
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
