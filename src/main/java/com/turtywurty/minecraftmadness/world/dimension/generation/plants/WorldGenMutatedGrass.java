package com.turtywurty.minecraftmadness.world.dimension.generation.plants;

import java.util.Random;

import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.objects.blocks.world.dimension.MutatedGrass;
import com.turtywurty.minecraftmadness.objects.blocks.world.dimension.MutatedGrassBlock;

import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMutatedGrass extends WorldGenerator
{
	private final IBlockState mutatedGrassState;

    public WorldGenMutatedGrass()
    {
        this.mutatedGrassState = BlockInit.MUTATED_GRASS_PLANT.getDefaultState();
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
        {
            position = position.down();
        }

        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && ((MutatedGrass)BlockInit.MUTATED_GRASS_PLANT).canBlockStay(worldIn, blockpos, this.mutatedGrassState))
            {
                worldIn.setBlockState(blockpos, this.mutatedGrassState, 2);
            }
        }

        return true;
    }
}
