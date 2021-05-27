package com.turtywurty.minecraftmadness.objects.blocks.cupboard;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.objects.blocks.freezer.TileEntityFreezer;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
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
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CupboardBlock extends BlockContainer implements IHasModel
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

	public static final AxisAlignedBB CUPBOARD_SOUTH = new AxisAlignedBB(0.125D, 0.0D, 0.625D, 0.875D, 0.8125D, 0.0D);
	public static final AxisAlignedBB CUPBOARD_NORTH = new AxisAlignedBB(0.125D, 0.0D, 1.0D, 0.875D, 0.8125D, 0.375D);
	public static final AxisAlignedBB CUPBOARD_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.125D, 0.625D, 0.8125D, 0.875D);
	public static final AxisAlignedBB CUPBOARD_EAST = new AxisAlignedBB(1.0D, 0.0D, 0.125D, 0.375D, 0.8125D, 0.875D);

	public CupboardBlock(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(2.0f);
		setHarvestLevel("axe", -1);
		setResistance(15.0f);
		setSoundType(SoundType.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityCupboard();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		playerIn.openGui(MinecraftMadness.instance, Reference.GUI_CUPBOARD, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityCupboard tileentity = (TileEntityCupboard)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		if(stack.hasDisplayName())
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if(tileentity instanceof TileEntityCupboard)
			{
				((TileEntityCupboard)tileentity).setCustomName(stack.getDisplayName());
			}
		}	
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();
        state = state.withProperty(FACING, EnumFacing.getFront(meta));
        return state;
    }
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos, EnumFacing side)
    {
        return super.canPlaceBlockAt(worldIn, pos) ? this.canPlaceBlockOnSide(worldIn, pos, side) : false;       
    }

	 public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	    {
	        if (blockIn != this)
	        {
	        	EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

	            if (!this.canPlaceBlockOnSide(worldIn, pos, enumfacing))
	            {
	            	this.dropBlockAsItem(worldIn, pos, state, 0);
	                worldIn.setBlockToAir(pos);
	            }
	        }
	    }

    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        EnumFacing enumfacing = side.getOpposite();
        BlockPos blockpos = pos.offset(enumfacing);
        IBlockState iblockstate = worldIn.getBlockState(blockpos);
        boolean flag = isExceptBlockForAttachWithPiston(iblockstate.getBlock());
        return !flag && side.getAxis().isHorizontal() && iblockstate.getBlockFaceShape(worldIn, blockpos, side) == BlockFaceShape.SOLID && !iblockstate.canProvidePower();
    }
	
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	    
	@Override
	protected BlockStateContainer createBlockState() 
    {
	    return new BlockStateContainer(this, new IProperty[]{FACING});
    }
	
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos.offset(facing.getOpposite()));
        if (iblockstate.getBlock() == this)
        {
            EnumFacing enumfacing = (EnumFacing)iblockstate.getValue(FACING);
            if (enumfacing == facing)
            {
                return this.getDefaultState().withProperty(FACING, facing.getOpposite());
            }
        }
        return this.getDefaultState().withProperty(FACING, facing);
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
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch(((EnumFacing)state.getValue(FACING)))
        {
            case SOUTH:
            default:
                return CUPBOARD_SOUTH;
            case NORTH:
                return CUPBOARD_NORTH;
            case EAST:
                return CUPBOARD_WEST;
            case WEST:
                return CUPBOARD_EAST;
        }
    }

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
