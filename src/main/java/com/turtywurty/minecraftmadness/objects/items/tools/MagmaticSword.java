package com.turtywurty.minecraftmadness.objects.items.tools;

import com.turtywurty.minecraftmadness.MinecraftMadness;
import com.turtywurty.minecraftmadness.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MagmaticSword extends ToolSword
{
	public MagmaticSword(String name, ToolMaterial material) 
	{
		super(name, material);
		setCreativeTab(MinecraftMadness.MINECRAFTMADNESSTAB);
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        target.setFire(15);
        return true;
    }
}
