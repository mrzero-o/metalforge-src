package net.metalforge.mod.worldgen;

import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.WorldSpecificSaveHandler;

public class MFBiomes {
	
	public static BiomeGenBase blackForest;
	
	public static void init(){
		registerBiomes();
	}

	public static void registerBiomes() {
		
		blackForest = new BiomeBlackForest();
		
		BiomeDictionary.registerBiomeType(blackForest, Type.FOREST);
		
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(blackForest, MFConfiguration.blackForestRarity));
		
		BiomeManager.addSpawnBiome(blackForest);
	}
}
