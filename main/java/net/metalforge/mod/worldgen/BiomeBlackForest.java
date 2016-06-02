package net.metalforge.mod.worldgen;

import java.util.Random;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeBlackForest extends BiomeGenBase {

	//spawn in bw forest, seed: 1208664017342226207
	
	private static Height biomeHeight = new Height(0.000005F, 0.01F);
	private static Block filler = MFBlocks.ancientSoil;
	private static Block top = MFBlocks.ancientGrass;
	
	public BiomeBlackForest() {
		super(MFConfiguration.blackForestID); 
		this.setBiomeName("Black Forest");
		this.setHeight(biomeHeight);
		this.setColor(2045987);
		this.setTemperatureRainfall(-0.875F, 0.875F);
		this.waterColorMultiplier = 13691127;
		this.setDisableRain();
		this.setEnableSnow();
		this.rainfall = 0.8275F;
		this.fillerBlock = filler;
		this.topBlock = top;
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 4));
	}
	
	public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return new WorldGenBlackwoodTree(false, false);
    }
	
	@Override
	public BiomeDecorator createBiomeDecorator()
    {
        return new BiomeBlackForestDecorator();
    }
	
	@Override
	public int getBiomeGrassColor(int x, int y, int z){
		return 2045987;
	}
	
	@Override
	public int getBiomeFoliageColor(int x, int y, int z){
		return 684800;
	}
	
	@Override 
	public int getSkyColorByTemp(float f){
		return 1742457;
	}
}
