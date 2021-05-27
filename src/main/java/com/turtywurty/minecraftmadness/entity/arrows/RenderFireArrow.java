package com.turtywurty.minecraftmadness.entity.arrows;

import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFireArrow extends RenderArrow<EntityFireArrow>
{
	public RenderFireArrow(RenderManager manager) 
	{
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFireArrow entity) 
	{
		return new ResourceLocation(Reference.MOD_ID + ":textures/entity/arrows/fire_arrow.png");
	}
}
