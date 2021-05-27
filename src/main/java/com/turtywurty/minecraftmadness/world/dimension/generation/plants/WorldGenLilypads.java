package com.turtywurty.minecraftmadness.world.dimension.generation.plants;

import java.util.Random;

import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.objects.blocks.world.dimension.MutatedLilyPad;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLilypads extends WorldGenerator
{
	public boolean generate(World worldIn, Random rand, BlockPos position)
    {
		IBlockState state = worldIn.getBlockState(position);
        for (int i = 0; i < 10; ++i)
        {
            int j = position.getX() + rand.nextInt(8) - rand.nextInt(8);
            int k = position.getY() + rand.nextInt(4) - rand.nextInt(4);
            int l = position.getZ() + rand.nextInt(8) - rand.nextInt(8);

            if (worldIn.isAirBlock(new BlockPos(j, k, l)) && ((MutatedLilyPad)BlockInit.MUTATED_LILYPAD).canBlockStay(worldIn, new BlockPos(j, k, l), state))
            {
                worldIn.setBlockState(new BlockPos(j, k, l), BlockInit.MUTATED_LILYPAD.getDefaultState(), 2);
            }
        }

        return true;
    }
}
