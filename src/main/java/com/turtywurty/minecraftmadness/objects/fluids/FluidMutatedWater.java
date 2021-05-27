package com.turtywurty.minecraftmadness.objects.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidMutatedWater extends Fluid 
{
	public FluidMutatedWater(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay) 
	{
		super(name, still, flow, overlay);
		this.setUnlocalizedName(name);
	}
}
