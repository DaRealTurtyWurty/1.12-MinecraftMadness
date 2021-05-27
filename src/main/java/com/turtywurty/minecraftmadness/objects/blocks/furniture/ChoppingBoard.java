package com.turtywurty.minecraftmadness.objects.blocks.furniture;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ChoppingBoard extends BlockContainer implements IHasModel
{
	public static final AxisAlignedBB CHOPPING_BOARD = new AxisAlignedBB(0.125D, 0.0D, 0.25D, 0.875D, 0.0625D, 0.75D);
	public static final AxisAlignedBB CHOPPING_BOARD_WE = new AxisAlignedBB(0.25D, 0.0D, 0.125D, 0.75D, 0.0625D, 0.875D);
	
	public ChoppingBoard(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(2.0f);
		setHarvestLevel("axe", -1);
		setResistance(15.0f);
		setSoundType(SoundType.WOOD);
		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH)); 
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
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
			if(block == BlockInit.OAK_CHOPPING_BOARD)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.OAK_CHOPPING_BOARD, 1));
			}
			if(block == BlockInit.BIRCH_CHOPPING_BOARD)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.BIRCH_CHOPPING_BOARD, 1));
			}
			if(block == BlockInit.SPRUCE_CHOPPING_BOARD)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.SPRUCE_CHOPPING_BOARD, 1));
			}
			if(block == BlockInit.JUNGLE_CHOPPING_BOARD)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.JUNGLE_CHOPPING_BOARD, 1));
			}
			if(block == BlockInit.ACACIA_CHOPPING_BOARD)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ACACIA_CHOPPING_BOARD, 1));
			}
			if(block == BlockInit.DARK_OAK_CHOPPING_BOARD)
			{
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.DARK_OAK_CHOPPING_BOARD, 1));
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
                return CHOPPING_BOARD;
            case NORTH:
                return CHOPPING_BOARD;
            case EAST:
                return CHOPPING_BOARD_WE;
            case WEST:
                return CHOPPING_BOARD_WE;
        }
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		//return new TileEntityChoppingBoard();
		return null;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		playerIn.openGui(MinecraftMadness.instance, Reference.GUI_CHOPPING_BOARD, worldIn, pos.getX(), pos.getY(), pos.getX());
		return true;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
