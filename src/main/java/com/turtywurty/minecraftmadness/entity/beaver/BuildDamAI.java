package com.turtywurty.minecraftmadness.entity.beaver;

import com.turtywurty.minecraftmadness.objects.blocks.world.BlockDam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.lang.Math;

public class BuildDamAI extends EntityAIBase
{
    protected EntityBeaver entity;
    protected BlockPos damPosition = BlockPos.ORIGIN;
    protected BlockDam damBlock;
	boolean builtDam;
	float entityPositionX;
    float entityPositionZ;
    World worldIn;
    protected BlockPos entityPosition = entity.getPosition();
    		
    public BuildDamAI(EntityBeaver entityIn) 
    {
    	this.entity = entityIn;
    	if(!(entityIn.getNavigator() instanceof PathNavigateGround))
        {
            throw new IllegalArgumentException("Unsupported mob type for Building Dam!");
        }
	}
	
	@Override
	public boolean shouldExecute() 
	{
		PathNavigateGround pathnavigateground = (PathNavigateGround)this.entity.getNavigator();
        Path path = pathnavigateground.getPath();
		if(entity.collidedVertically)
		{
			if(worldIn.getBlockState(entityPosition) == Blocks.WATER)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return builtDam;
	}
	
	private BlockDam getBlockDam(BlockPos pos)
    {
        IBlockState iblockstate = this.entity.world.getBlockState(pos);
        Block block = iblockstate.getBlock();
        return block instanceof BlockDam && iblockstate.getMaterial() == Material.WOOD ? (BlockDam)block : null;
    }
}
