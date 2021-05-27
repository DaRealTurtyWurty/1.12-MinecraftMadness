package com.turtywurty.minecraftmadness.objects.blocks.world.dimension;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.init.ItemInit;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.interfaces.IHasModel;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MutatedLilyPad extends BlockBush implements IHasModel
{
	protected static final AxisAlignedBB LILY_PAD_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.09375D, 0.9375D);
	
	public MutatedLilyPad(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
        if (!(entityIn instanceof EntityBoat))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, LILY_PAD_AABB);
        }
    }
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);

        if (entityIn instanceof EntityBoat)
        {
            worldIn.destroyBlock(new BlockPos(pos), true);
        }
    }
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return LILY_PAD_AABB;
    }
	
	protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == BlockInit.MUTATED_WATER_FLUID;
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (pos.getY() >= 0 && pos.getY() < 256)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());
            Material material = iblockstate.getMaterial();
            return material == Material.WATER && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) 
    {
    	return new ItemStack(ItemInit.MUTATED_LILYPAD);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) 
    {
    	return ItemInit.MUTATED_LILYPAD;
    }
    
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
    {
    	return new ItemStack(ItemInit.MUTATED_LILYPAD);
    }
    
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
	
	@Override
	public void registerModels() 
	{
		MinecraftMadness.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
