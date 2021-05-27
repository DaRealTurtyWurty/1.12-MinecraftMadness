package com.turtywurty.minecraftmadness.init;

import com.turtywurty.minecraftmadness.objects.fluids.FluidMutatedWater;
import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit 
{
	public static final Fluid MUTATED_WATER_FLUID = new FluidMutatedWater("mutated_water", new ResourceLocation("minecraftmadness:blocks/mutated_water_still"), new ResourceLocation("minecraftmadness:blocks/mutated_water_flow"), new ResourceLocation("minecraftmadness:blocks/mutated_water_overlay"));
	
	public static void registerFluids()
	{
		registerFluid(MUTATED_WATER_FLUID);
	}
	
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
