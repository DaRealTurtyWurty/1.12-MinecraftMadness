package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import java.util.Random;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MutatedFarmland extends Block implements IHasModel
{
	public static final PropertyInteger MOISTURE = PropertyInteger.create("moisture", 0, 7);
    protected static final AxisAlignedBB MUTATED_FARMLAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9375D, 1.0D);
    protected static final AxisAlignedBB field_194405_c = new AxisAlignedBB(0.0D, 0.9375D, 0.0D, 1.0D, 1.0D, 1.0D);
    //private final Block crops;

    public MutatedFarmland(String name)
    {
        super(Material.GROUND);
        this.setDefaultState(this.blockState.getBaseState().withProperty(MOISTURE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setLightOpacity(255);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
        
        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return MUTATED_FARMLAND_AABB;
    }
    
   /* @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
    {
    	ItemStack stack = playerIn.getHeldItem(hand);
		IBlockState state1 = worldIn.getBlockState(pos);
		ItemStack plantable = playerIn.getHeldItemMainhand();
		if(facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && worldIn.isAirBlock(pos.up()))
			{
				if(stack.getItem() instanceof IPlantable)
				{				
					worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
					stack.shrink(1);
					return true;
				}
			}
		return false;
    }*/
    
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
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

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int i = ((Integer)state.getValue(MOISTURE)).intValue();
 
        if (!this.hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up()))
        {
            if (i > 0)
            {
                worldIn.setBlockState(pos, state.withProperty(MOISTURE, Integer.valueOf(i - 1)), 2);
            }
            else if (!this.hasCrops(worldIn, pos))
            {
                turnToDirt(worldIn, pos);
            }
        }
        else if (i < 7)
        {
            worldIn.setBlockState(pos, state.withProperty(MOISTURE, Integer.valueOf(7)), 2);
        }
    }
    
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
    {
        IBlockState plant = plantable.getPlant(world, pos.offset(direction));
        net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));
 
        switch (plantType)
        {           
          case Crop:   
        	  return this == BlockInit.MUTATED_FARMLAND;
        case Beach:
            break;
        case Cave:
            break;
        case Desert:
            break;
        case Nether:
            break;
        case Plains:
            break;
        case Water:
            break;
        default:
            break;                 
        }
        return false;     
    }
    
    public static boolean onFarmlandTrample(World world, BlockPos pos, IBlockState state, float fallDistance, Entity entity)
    {

        if (entity.canTrample(world, state.getBlock(), pos, fallDistance))
        {
            BlockEvent.FarmlandTrampleEvent event = new BlockEvent.FarmlandTrampleEvent(world, pos, state, fallDistance, entity);
            MinecraftForge.EVENT_BUS.post(event);
            return !event.isCanceled();
        }
        return false;
    }
    
    public boolean canSustainBush(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
    {
        return false;
    }
    
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        if (onFarmlandTrample(worldIn, pos, BlockInit.MUTATED_FARMLAND.getDefaultState(), fallDistance, entityIn)) // Forge: Move logic to Entity#canTrample
        {
            turnToDirt(worldIn, pos);
        }
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }
    
    protected static void turnToDirt(World p_190970_0_, BlockPos worldIn)
    {
        p_190970_0_.setBlockState(worldIn, BlockInit.MUTATED_DIRT.getDefaultState());
        AxisAlignedBB axisalignedbb = field_194405_c.offset(worldIn);
 
        for (Entity entity : p_190970_0_.getEntitiesWithinAABBExcludingEntity((Entity)null, axisalignedbb))
        {
            double d0 = Math.min(axisalignedbb.maxY - axisalignedbb.minY, axisalignedbb.maxY - entity.getEntityBoundingBox().minY);
            entity.setPositionAndUpdate(entity.posX, entity.posY + d0 + 0.001D, entity.posZ);
        }
    }

    private boolean hasCrops(World worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.up()).getBlock();
        return block instanceof net.minecraftforge.common.IPlantable && canSustainPlant(worldIn.getBlockState(pos), worldIn, pos, net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)block);
    }

    private boolean hasWater(World worldIn, BlockPos pos)
    {
        for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4)))
        {
            if (worldIn.getBlockState(blockpos$mutableblockpos).getMaterial() == Material.WATER)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
 
        if (worldIn.getBlockState(pos.up()).getMaterial().isSolid())
        {
            turnToDirt(worldIn, pos);
        }
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
 
        if (worldIn.getBlockState(pos.up()).getMaterial().isSolid())
        {
            turnToDirt(worldIn, pos);
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        switch (side)
        {
            case UP:
                return true;
            case NORTH:
            case SOUTH:
            case WEST:
            case EAST:
                IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
                Block block = iblockstate.getBlock();
                return !iblockstate.isOpaqueCube() && block != BlockInit.MUTATED_FARMLAND && block != BlockInit.MUTATED_GRASS_PATH;
            default:
                return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlockInit.MUTATED_DIRT.getItemDropped(BlockInit.MUTATED_DIRT.getDefaultState(), rand, fortune);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(MOISTURE, Integer.valueOf(meta & 7));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(MOISTURE)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {MOISTURE});
    }

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     * 
     * @return an approximation of the form of the given face
     */
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }

	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
