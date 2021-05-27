package com.turtywurty.minecraftmadness.world.dimension.madness;

import javax.annotation.Nullable;

import com.turtywurty.minecraftmadness.init.DimensionInit;
import com.turtywurty.minecraftmadness.world.dimension.biomes.BiomeProviderCustom;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DimensionMadness extends WorldProvider 
{
	@Override
	public void init() 
	{
		this.biomeProvider = new BiomeProviderCustom(this.world.getSeed());
	}

	public DimensionType getDimensionType() 
	{
		return DimensionInit.MADNESS;
	}

	@Override
	public IChunkGenerator createChunkGenerator() 
	{
		return new MadnessGenTemplate(this.world, this.world.getSeed());
	}

	@Override
	public boolean isSurfaceWorld() 
	{
		return true;
	}

	@Override
	public boolean canRespawnHere() 
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_)
    {
		return new Vec3d(190D/255D, 204D/255D, 78D/255D);
    }
	
	@Override
	public float getCloudHeight() 
	{
		return 255.0f;
	}
	
	@Override
	public boolean shouldMapSpin(String entity, double x, double z, double rotation) 
	{
		return true;
	}
	
	@Override
	public double getMovementFactor() 
	{
		return 16.0f;
	}
	
	@Override
	protected void generateLightBrightnessTable() 
	{
		float f = 0.5F;
		for (int i = 0; i <= 15; ++i) 
		{
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
}
