package com.turtywurty.minecraftmadness.objects.blocks.plushies;

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

public class PlushieBase extends Block implements IHasModel
{
	public static final AxisAlignedBB PLAYER_PLUSHIE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.6D, 0.875D);
	public static final AxisAlignedBB SNOWGOLEM_PLUSHIE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.8125D, 0.875D);
	public static final AxisAlignedBB ZOMBIEVILLAGER_PLUSHIE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);
	public static final AxisAlignedBB HARRYTALKS_PLUSHIE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.75D, 0.875D);
	public static final AxisAlignedBB IRONGOLEM_PLUSHIE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);
	
	public PlushieBase(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		setHardness(2.0f);
		setHarvestLevel("axe", -1);
		setResistance(2.5f);
		setSoundType(SoundType.CLOTH);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)); 
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	  
	  public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	    {
	        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;       
	    }

	    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, EntityPlayer player)
	    {    
	    	if(block == BlockInit.TURTYWURTY_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.TURTYWURTY_PLUSHIE, 1));
		 	        } 
	    		}
	    	}
	    	
	    	else if(block == BlockInit.CJMINECRAFT01_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.CJMINECRAFT01_PLUSHIE, 1));
		 	        } 
	    		}
	    	}
	    	
	    	else if(block == BlockInit.FAPDOS_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.FAPDOS_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.HUSKYTHEARTIST_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.HUSKYTHEARTIST_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.IVANDPF_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.IVANDPF_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.SALRADAHN_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.SALRADAHN_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.VIKTORP04_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.VIKTORP04_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.MRCRAYFISH_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.MRCRAYFISH_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.INTIVI_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.INTIVI_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.STEVE_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.STEVE_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.ALEX_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ALEX_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.SMELLYSOX345_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.SMELLYSOX345_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.FELIX__ARGYLE_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.FELIX__ARGYLE_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.SNOW_GOLEM_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.SNOW_GOLEM_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.BUTTER_BOI_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.BUTTER_BOI_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.ZOMBIEVILLAGER_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.ZOMBIEVILLAGER_PLUSHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.HARRYTALKS_PLSUHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.HARRYTALKS_PLSUHIE, 1));
		 	        } 
	    		} 
	    	}
	    	
	    	else if(block == BlockInit.IRON_GOLEM_PLUSHIE)
	    	{
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			if (!this.canBlockStay(world, pos))
		 	        {    
		 	            world.setBlockToAir(pos);
		 	            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.IRON_GOLEM_PLUSHIE, 1));
		 	        } 
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
		if(state.getBlock() == BlockInit.SNOW_GOLEM_PLUSHIE)
		{
			return SNOWGOLEM_PLUSHIE_AABB;
		}
		else if(state.getBlock() == BlockInit.ZOMBIEVILLAGER_PLUSHIE)
		{
			return ZOMBIEVILLAGER_PLUSHIE_AABB;
		}
		else if(state.getBlock() == BlockInit.HARRYTALKS_PLSUHIE)
		{
			return HARRYTALKS_PLUSHIE_AABB;
		}
		else if(state.getBlock() == BlockInit.IRON_GOLEM_PLUSHIE)
		{
			return IRONGOLEM_PLUSHIE_AABB;
		}
		return PLAYER_PLUSHIE_AABB;
	}

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
