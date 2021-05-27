package com.turtywurty.minecraftmadness.util.handlers;

import com.turtywurty.minecraftmadness.objects.blocks.blender.ContainerBlender;
import com.turtywurty.minecraftmadness.objects.blocks.blender.GuiBlender;
import com.turtywurty.minecraftmadness.objects.blocks.blender.TileEntityBlender;
import com.turtywurty.minecraftmadness.objects.blocks.cookie_jar.ContainerCookieJar;
import com.turtywurty.minecraftmadness.objects.blocks.cookie_jar.GuiCookieJar;
import com.turtywurty.minecraftmadness.objects.blocks.cookie_jar.TileEntityCookieJar;
import com.turtywurty.minecraftmadness.objects.blocks.cupboard.ContainerCupboard;
import com.turtywurty.minecraftmadness.objects.blocks.cupboard.GuiCupboard;
import com.turtywurty.minecraftmadness.objects.blocks.cupboard.TileEntityCupboard;
import com.turtywurty.minecraftmadness.objects.blocks.freezer.ContainerFreezer;
import com.turtywurty.minecraftmadness.objects.blocks.freezer.GuiFreezer;
import com.turtywurty.minecraftmadness.objects.blocks.freezer.TileEntityFreezer;
import com.turtywurty.minecraftmadness.objects.blocks.oven.ContainerOven;
import com.turtywurty.minecraftmadness.objects.blocks.oven.GuiOven;
import com.turtywurty.minecraftmadness.objects.blocks.oven.TileEntityOven;
import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_FREEZER)
		{
			return new ContainerFreezer(player.inventory, (TileEntityFreezer)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_CUPBOARD)
		{
			return new ContainerCupboard(player.inventory, (TileEntityCupboard)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_OVEN)
		{
			return new ContainerOven(player.inventory, (TileEntityOven)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == Reference.GUI_BLENDER)
		{
			return new ContainerBlender(player.inventory, (TileEntityBlender)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == Reference.GUI_COOKIE_JAR)
		{
			return new ContainerCookieJar(player.inventory, (TileEntityCookieJar)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_FREEZER)
		{
			return new GuiFreezer(player.inventory, (TileEntityFreezer)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_CUPBOARD)
		{
			return new GuiCupboard(player.inventory, (TileEntityCupboard)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_OVEN)
		{
			return new GuiOven(player.inventory, (TileEntityOven)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == Reference.GUI_BLENDER)
		{
			return new GuiBlender(player.inventory, (TileEntityBlender)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID == Reference.GUI_COOKIE_JAR)
		{
			return new GuiCookieJar(player.inventory, (TileEntityCookieJar)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		return null;
	}
	
	public static void registerGuis()
	{

	}
}

