package com.turtywurty.minecraftmadness.objects.blocks.furniture;

import java.util.Random;

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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Lamp extends Block implements IHasModel 
{
	private final boolean isOn;
	public static final AxisAlignedBB LAMP = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.8125, 0.75D);
	
	public Lamp(String name, Material material, boolean isOn) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(1.8f);
		setResistance(12.0f);
		setSoundType(SoundType.STONE);
		setHarvestLevel("axe", -1);
		this.isOn = isOn;
        if(isOn)
        {
            this.setLightLevel(1.0F);
        }
		
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
        {
            if(this.isOn)
            {
                worldIn.setBlockState(pos, BlockInit.LAMP_OFF.getDefaultState(), 2);
            }
            else if(!this.isOn)
            {
                worldIn.setBlockState(pos, BlockInit.LAMP_ON.getDefaultState(), 2);
            }
        }
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if(!worldIn.isRemote)
        {
            if(this.isOn)
            {
                worldIn.setBlockState(pos, BlockInit.LAMP_OFF.getDefaultState(), 2);
            }
        }
    }
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockInit.LAMP_OFF);
    }
	
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(BlockInit.LAMP_OFF);
    }

    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(BlockInit.LAMP_OFF);
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
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.LAMP_ON, 1));
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
		return LAMP;
	}
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
