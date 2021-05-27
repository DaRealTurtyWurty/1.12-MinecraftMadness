package com.turtywurty.minecraftmadness.entity.beaver;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBeaver extends EntityAnimal
{
	public EntityBeaver(World world) 
	{
		super(world);
		this.setSize(0.6f, 1.6f);
	}
	
	@Override
	protected void initEntityAI()
	{
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIPanic(this, 2.2D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityMob.class, 4.0F, 2.2D, 2.2D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
        this.tasks.addTask(1, new EntityAIWander(this, 0.3D));
	}
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
    protected void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(7.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D); 
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		this.setSize(0.5f, 0.5f);
		return new EntityBeaver(world);
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return null;
	}
}
