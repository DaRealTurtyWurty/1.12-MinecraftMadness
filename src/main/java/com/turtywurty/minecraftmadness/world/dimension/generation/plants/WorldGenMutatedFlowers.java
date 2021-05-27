package com.turtywurty.minecraftmadness.world.dimension.generation.plants;

import java.util.Random;

import com.turtywurty.minecraftmadness.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMutatedFlowers extends WorldGenerator
{
	public final Block block = BlockInit.MUTATED_FLOWER;
	
	public boolean generate(World worldIn, Random rand, BlockPos position)
    {
		IBlockState state = worldIn.getBlockState(position);
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && this.block.canPlaceBlockAt(worldIn, position))        
            {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }

        return true;
    }
}
