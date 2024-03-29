package com.turtywurty.minecraftmadness.entity.beaver;

import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBeaver extends RenderLiving<EntityBeaver>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/beaver/beaver" + ".png");
	
	public RenderBeaver(RenderManager manager) 
	{
		super(manager, new ModelBeaver(), 0.1F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBeaver entity) 
	{
		return TEXTURES;
	}
}
