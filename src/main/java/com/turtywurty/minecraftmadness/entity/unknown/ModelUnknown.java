package com.turtywurty.minecraftmadness.entity.unknown;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelUnknown extends ModelBase 
{
	private final ModelRenderer Feet;
	private final ModelRenderer Legs;
	private final ModelRenderer MainBody;
	private final ModelRenderer Tail;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightArm;
	private final ModelRenderer Head;

	public ModelUnknown() 
	{
		textureWidth = 128;
		textureHeight = 128;

		Feet = new ModelRenderer(this);
		Feet.setRotationPoint(0.0F, 24.0F, 0.0F);
		Feet.cubeList.add(new ModelBox(Feet, 0, 125, -4.0F, -1.0F, -1.0F, 3, 1, 2, 0.0F, false));
		Feet.cubeList.add(new ModelBox(Feet, 20, 126, -2.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
		Feet.cubeList.add(new ModelBox(Feet, 32, 126, -4.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
		Feet.cubeList.add(new ModelBox(Feet, 24, 126, 3.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
		Feet.cubeList.add(new ModelBox(Feet, 28, 126, 1.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
		Feet.cubeList.add(new ModelBox(Feet, 10, 125, 1.0F, -1.0F, -1.0F, 3, 1, 2, 0.0F, false));

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
		Legs.cubeList.add(new ModelBox(Legs, 0, 118, 2.0F, -3.0F, 0.0F, 1, 2, 1, 0.0F, false));
		Legs.cubeList.add(new ModelBox(Legs, 4, 118, -3.0F, -3.0F, 0.0F, 1, 2, 1, 0.0F, false));

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		MainBody.cubeList.add(new ModelBox(MainBody, 0, 106, -3.0F, -7.0F, -2.0F, 6, 4, 5, 0.0F, false));
		MainBody.cubeList.add(new ModelBox(MainBody, 22, 107, -3.0F, -12.0F, -1.0F, 6, 5, 3, 0.0F, false));
		MainBody.cubeList.add(new ModelBox(MainBody, 40, 108, 3.0F, -7.0F, -1.0F, 1, 4, 3, 0.0F, false));
		MainBody.cubeList.add(new ModelBox(MainBody, 48, 108, -4.0F, -7.0F, -1.0F, 1, 4, 3, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Tail, 0.6109F, 0.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 95, -2.0F, -2.0F, 4.0F, 3, 4, 1, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(0.0F, 24.0F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 37, 0, 3.0F, -11.0F, -0.5F, 2, 3, 2, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 24, 0, 5.0F, -11.0F, -3.5F, 2, 3, 4, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 0, 5.0F, -11.0F, 0.5F, 2, 3, 1, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(RightArm, 0.0F, 0.0F, 3.1416F);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 7, 3.0F, 8.0F, -0.5F, 2, 3, 2, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 10, 0, 5.0F, 8.0F, -3.5F, 2, 3, 4, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 15, 5.0F, 8.0F, 0.5F, 2, 3, 1, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 78, -2.0F, -16.0F, -2.0F, 4, 4, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 74, -1.0F, -17.0F, -2.0F, 2, 1, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		Feet.render(f5);
		Legs.render(f5);
		MainBody.render(f5);
		Tail.render(f5);
		LeftArm.render(f5);
		RightArm.render(f5);
		Head.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}