package com.turtywurty.minecraftmadness;

import java.io.File;

import com.turtywurty.minecraftmadness.commands.teleportDim.CommandTeleportDimension;
import com.turtywurty.minecraftmadness.init.BiomeInit;
import com.turtywurty.minecraftmadness.init.DimensionInit;
import com.turtywurty.minecraftmadness.init.EntityInit;
import com.turtywurty.minecraftmadness.init.FluidInit;
import com.turtywurty.minecraftmadness.proxy.CommonProxy;
import com.turtywurty.minecraftmadness.recipes.CraftingRecipes;
import com.turtywurty.minecraftmadness.recipes.SmeltingRecipes;
import com.turtywurty.minecraftmadness.tabs.MadnessTab;
import com.turtywurty.minecraftmadness.util.MadnessOreDictionary;
import com.turtywurty.minecraftmadness.util.Reference;
import com.turtywurty.minecraftmadness.util.handlers.EventsHandler;
import com.turtywurty.minecraftmadness.util.handlers.RegistryHandler;
import com.turtywurty.minecraftmadness.util.handlers.RenderHandler;
import com.turtywurty.minecraftmadness.util.handlers.SoundsHandler;
import com.turtywurty.minecraftmadness.world.gen.WorldGenCustomOres;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

//Declaring that classes are a mod!
@Mod(modid= Reference.MOD_ID, version = Reference.VERSION, name = Reference.NAME)
public class MinecraftMadness 
{
	//Mod Instance
	@Instance
	public static MinecraftMadness instance;
	
	//Register Proxy
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	//Tab
	public static final CreativeTabs MINECRAFTMADNESSTAB = new MadnessTab("minecraftmadnesstab");
		
	public static File config;
	
	static 
	{
		FluidRegistry.enableUniversalBucket();
	}
	
	//Pre-Initialization Registration
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FluidInit.registerFluids();
		BiomeInit.registerBiomes();
		DimensionInit.registerDimensions();
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 3);
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		RenderHandler.registerCustomMeshesAndStates();
		SoundsHandler.registerSounds();
		EventsHandler.registerEvents();
	}
	
	//Initialization Registration
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
		MadnessOreDictionary.registerOreDictionary();
		SmeltingRecipes.init();
		CraftingRecipes.init();
	}
	
	//Post-Initialization Registration
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandTeleportDimension());
	}
}
