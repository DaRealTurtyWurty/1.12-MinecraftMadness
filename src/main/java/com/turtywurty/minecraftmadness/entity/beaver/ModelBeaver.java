package com.turtywurty.minecraftmadness.entity.beaver;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelBeaver extends ModelBase
{
  //fields
    ModelRenderer Nose;
    ModelRenderer BackLeftFoot;
    ModelRenderer BackRightFoot;
    ModelRenderer FrontLeftFoot;
    ModelRenderer FrontRightFoot;
    ModelRenderer MainBody;
    ModelRenderer Head;
    ModelRenderer Tail;
    ModelRenderer Teeth;
  
  public ModelBeaver()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Nose = new ModelRenderer(this, 16, 0);
      Nose.addBox(0F, 0F, 0F, 2, 2, 1);
      Nose.setRotationPoint(-1F, 20F, -8.1F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      BackLeftFoot = new ModelRenderer(this, 20, 20);
      BackLeftFoot.addBox(0F, 0F, 0F, 2, 2, 2);
      BackLeftFoot.setRotationPoint(1F, 22F, 3F);
      BackLeftFoot.setTextureSize(64, 32);
      BackLeftFoot.mirror = true;
      setRotation(BackLeftFoot, 0F, 0F, 0F);
      BackRightFoot = new ModelRenderer(this, 28, 20);
      BackRightFoot.addBox(0F, 0F, 0F, 2, 2, 2);
      BackRightFoot.setRotationPoint(-3F, 22F, 3F);
      BackRightFoot.setTextureSize(64, 32);
      BackRightFoot.mirror = true;
      setRotation(BackRightFoot, 0F, 0F, 0F);
      FrontLeftFoot = new ModelRenderer(this, 0, 20);
      FrontLeftFoot.addBox(0F, 0F, 0F, 2, 2, 2);
      FrontLeftFoot.setRotationPoint(1F, 22F, -5F);
      FrontLeftFoot.setTextureSize(64, 32);
      FrontLeftFoot.mirror = true;
      setRotation(FrontLeftFoot, 0F, 0F, 0F);
      FrontRightFoot = new ModelRenderer(this, 8, 20);
      FrontRightFoot.addBox(0F, 0F, 0F, 2, 2, 2);
      FrontRightFoot.setRotationPoint(-3F, 22F, -5F);
      FrontRightFoot.setTextureSize(64, 32);
      FrontRightFoot.mirror = true;
      setRotation(FrontRightFoot, 0F, 0F, 0F);
      MainBody = new ModelRenderer(this, 43, 0);
      MainBody.addBox(0F, 0F, 0F, 6, 6, 10);
      MainBody.setRotationPoint(-3F, 16F, -5F);
      MainBody.setTextureSize(64, 32);
      MainBody.mirror = true;
      setRotation(MainBody, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 4, 4, 3);
      Head.setRotationPoint(-2F, 17F, -8F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 112, 0);
      Tail.addBox(0F, 0F, 0F, 4, 1, 4);
      Tail.setRotationPoint(-2F, 20F, 5F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      Teeth = new ModelRenderer(this, 16, 5);
      Teeth.addBox(0F, 0F, 0F, 2, 1, 1);
      Teeth.setRotationPoint(-1F, 19F, -8.5F);
      Teeth.setTextureSize(64, 32);
      Teeth.mirror = true;
      setRotation(Teeth, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Nose.render(f5);
    BackLeftFoot.render(f5);
    BackRightFoot.render(f5);
    FrontLeftFoot.render(f5);
    FrontRightFoot.render(f5);
    MainBody.render(f5);
    Head.render(f5);
    Tail.render(f5);
    Teeth.render(f5);
  }
  
  	private void setRotation(ModelRenderer model, float x, float y, float z)
  	{
  		model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
  	}
  
  	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
  	{
  		this.BackLeftFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.BackRightFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.FrontLeftFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount; 
        this.FrontRightFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
  	}
}
