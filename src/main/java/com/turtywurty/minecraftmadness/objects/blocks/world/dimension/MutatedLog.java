package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MutatedLog extends BlockRotatedPillar implements IHasModel
{
	public static final PropertyEnum<MutatedLog.EnumAxis> LOG_AXIS = PropertyEnum.<MutatedLog.EnumAxis>create("axis", MutatedLog.EnumAxis.class);
	
	public MutatedLog(String name) 
	{
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
		this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = 4;
        int j = 5;

        if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }
	
	public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot)
        {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch ((MutatedLog.EnumAxis)state.getValue(LOG_AXIS))
                {
                    case X:
                        return state.withProperty(LOG_AXIS, MutatedLog.EnumAxis.Z);
                    case Z:
                        return state.withProperty(LOG_AXIS, MutatedLog.EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }
	
	@Override 
	public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
	{ 
		return true; 
	}
	
    @Override 
    public boolean isWood(IBlockAccess world, BlockPos pos)
    { 
    	return true; 
    }
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	public static enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");

        private final String name;

        private EnumAxis(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public static MutatedLog.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (axis)
            {
                case X:
                    return X;
                case Y:
                    return Y;
                case Z:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String getName()
        {
            return this.name;
        }
    }
}
