package com.turtywurty.minecraftmadness.util.handlers;

import com.turtywurty.minecraftmadness.objects.blocks.blender.TileEntityBlender;
import com.turtywurty.minecraftmadness.objects.blocks.cookie_jar.TileEntityCookieJar;
import com.turtywurty.minecraftmadness.objects.blocks.cupboard.TileEntityCupboard;
import com.turtywurty.minecraftmadness.objects.blocks.freezer.TileEntityFreezer;
import com.turtywurty.minecraftmadness.objects.blocks.nether_reactor.TileEntityNetherReactor;
import com.turtywurty.minecraftmadness.objects.blocks.oven.TileEntityOven;
import com.turtywurty.minecraftmadness.objects.blocks.quarry.TileEntityQuarryBasic;
import com.turtywurty.minecraftmadness.objects.blocks.quarry.TileEntityQuarryTier1;
import com.turtywurty.minecraftmadness.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityFreezer.class, new ResourceLocation(Reference.MOD_ID + ":freezer"));
		GameRegistry.registerTileEntity(TileEntityCupboard.class, new ResourceLocation(Reference.MOD_ID + ":cupboard"));
		GameRegistry.registerTileEntity(TileEntityQuarryBasic.class, new ResourceLocation(Reference.MOD_ID + ":quarry_basic"));
		GameRegistry.registerTileEntity(TileEntityQuarryTier1.class, new ResourceLocation(Reference.MOD_ID + ":quarry_tier1"));
		GameRegistry.registerTileEntity(TileEntityNetherReactor.class, new ResourceLocation(Reference.MOD_ID + ":nether_reactor_core"));
		GameRegistry.registerTileEntity(TileEntityOven.class, new ResourceLocation(Reference.MOD_ID + ":oven"));
		GameRegistry.registerTileEntity(TileEntityBlender.class, new ResourceLocation(Reference.MOD_ID + ":blender"));
		GameRegistry.registerTileEntity(TileEntityCookieJar.class, new ResourceLocation(Reference.MOD_ID + ":cookie_jar"));
	}
}
