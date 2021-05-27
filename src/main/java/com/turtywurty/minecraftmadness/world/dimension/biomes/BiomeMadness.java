package com.turtywurty.minecraftmadness.world.dimension.biomes;

import java.util.Random;

import com.turtywurty.minecraftmadness.entity.beaver.EntityBeaver;
import com.turtywurty.minecraftmadness.entity.frog.EntityFrog;
import com.turtywurty.minecraftmadness.entity.scorpion.EntityScorpion;
import com.turtywurty.minecraftmadness.entity.tadpole.EntityTadpole;
import com.turtywurty.minecraftmadness.init.BlockInit;
import com.turtywurty.minecraftmadness.world.dimension.generation.plants.WorldGenBigMushrooms;
import com.turtywurty.minecraftmadness.world.dimension.generation.plants.WorldGenMutatedGrass;
import com.turtywurty.minecraftmadness.world.dimension.generation.plants.WorldGenMutatedSugarcane;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeMadness extends Biome 
{
	public BiomeMadness() 
	{
		super(new BiomeProperties("Madness").setBaseHeight(0.125f).setRainDisabled().setTemperature(0.6f).setHeightVariation(0.9f).setWaterColor(16757504));
		
		topBlock = BlockInit.MUTATED_GRASS.getDefaultState();
		fillerBlock = BlockInit.MUTATED_DIRT.getDefaultState();
		
		decorator = new MadnessBiomeDecorator();
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityScorpion.class, 100, 2, 10));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityTadpole.class, 170, 20, 50));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityFrog.class, 150, 1, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityBeaver.class, 100, 4, 10));
		
		Random rand = new Random();
        decorator.reedGen = new WorldGenMutatedSugarcane();
        decorator.reedsPerChunk = rand.nextInt(100) + 20;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return new WorldGenMutatedGrass();
    }
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) 
	{
		return 8781568;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) 
	{
		return new WorldGenBigMushrooms();
	}
}