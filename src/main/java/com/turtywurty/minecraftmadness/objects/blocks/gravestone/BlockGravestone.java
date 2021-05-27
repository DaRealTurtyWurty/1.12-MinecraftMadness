package com.turtywurty.minecraftmadness.objects.blocks.gravestone;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGravestone extends Block implements IHasModel
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)); 
	}
	
	public BlockGravestone(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(1.8f);
		setResistance(28.0f);
		setHarvestLevel("pickaxe", 0);
		setSoundType(SoundType.GROUND);
		
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
	
	private static final AxisAlignedBB ELEMENT1 = new AxisAlignedBB(0.188, 0, 0.062, 0.812, 0.062, 1);
	private static final AxisAlignedBB ELEMENT2 = new AxisAlignedBB(0.25, 0.562, 0.938, 0.75, 0.688, 1);
	private static final AxisAlignedBB ELEMENT3 = new AxisAlignedBB(0.312, 0.688, 0.938, 0.688, 0.75, 1);
	private static final AxisAlignedBB ELEMENT4 = new AxisAlignedBB(0.25, 0.062, 0.938, 0.75, 0.375, 1);
	private static final AxisAlignedBB ELEMENT5 = new AxisAlignedBB(0.688, 0.375, 0.938, 0.75, 0.562, 1);
	private static final AxisAlignedBB ELEMENT6 = new AxisAlignedBB(0.25, 0.375, 0.938, 0.312, 0.562, 1);
	private static final AxisAlignedBB ELEMENT7 = new AxisAlignedBB(0.312, 0.375, 0.944, 0.688, 0.562, 1);

	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(ELEMENT1, ELEMENT2, ELEMENT3, ELEMENT4, ELEMENT5, ELEMENT6, ELEMENT7);
	private static final AxisAlignedBB GRAVESTONE_AABB = new AxisAlignedBB(0.188, 0, 0.062, 0.812, 0.75, 1);

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return GRAVESTONE_AABB;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
	{
	    entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        if (entityBox.intersects(box))
	            collidingBoxes.add(box.offset(pos));
	    }
	}

	@Override
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end)
	{
	    double distanceSq;
	    double distanceSqShortest = Double.POSITIVE_INFINITY;
	    RayTraceResult resultClosest = null;
	    RayTraceResult result;
	    start = start.subtract(pos.getX(), pos.getY(), pos.getZ());
	    end = end.subtract(pos.getX(), pos.getY(), pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        result = box.calculateIntercept(start, end);
	        if (result == null)
	            continue;

	        distanceSq = result.hitVec.squareDistanceTo(start);
	        if (distanceSq < distanceSqShortest)
	        {
	            distanceSqShortest = distanceSq;
	            resultClosest = result;
	        }
	    }
	    return resultClosest == null ? null : new RayTraceResult(RayTraceResult.Type.BLOCK, resultClosest.hitVec.addVector(pos.getX(), pos.getY(), pos.getZ()), resultClosest.sideHit, pos);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
	{
		if(!canBlockStay(worldIn, fromPos))
		{
			worldIn.setBlockToAir(pos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
		}
	}
	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
