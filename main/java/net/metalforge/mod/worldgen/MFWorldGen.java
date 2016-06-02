package net.metalforge.mod.worldgen;

import java.util.Random;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSavanna;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MFWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case 0: generateSurface(world, rand, chunkX * 16, chunkZ * 16);
			case 1: generateEnd(world, rand, chunkX * 16, chunkZ * 16);
			case -1: generateNether(world, rand, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random rand, int x, int z) {
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		//Beryl
		if (MFConfiguration.doSpawnBeryl) this.spawnBeryls(world, x, z, rand.nextInt(16) + 36, 7, 0, 88);
		//Copper
		if (MFConfiguration.doSpawnCopper) this.addOreSpawn(MFBlocks.oreAll, 0, world, x, z, 7 + rand.nextInt(4), 11, 48, 96);
		//Tungsten
		if (MFConfiguration.doSpawnTungsten) this.addOreSpawn(MFBlocks.oreAll, 1, world, x, z, 2 + rand.nextInt(4), 4, 0, 24);
		//Brown coal
		if (MFConfiguration.doSpawnBrownCoal) this.addOreSpawn(MFBlocks.oreAll, 3, world, x, z, 12 + rand.nextInt(6), 16, 48, 80);
		//Rich coal
		if (MFConfiguration.doSpawnRichCoal) this.addOreSpawn(Blocks.coal_ore, MFBlocks.oreAll, 4, world, x, z, 4 + rand.nextInt(4), 8, 0, 128);
		//Extra coal
		this.addOreSpawn(Blocks.stone, Blocks.coal_ore, 0, world, x, z, 4 + rand.nextInt(4), 8, 0, 60);
		
		//Magnetite
		if (MFConfiguration.doSpawnMagnetite) this.addOreSpawn(MFBlocks.magnetiteAll, 0, world, x, z, 16 + rand.nextInt(12), 8, 0, 164);
		
		//Xyrenite
		if (MFConfiguration.doSpawnXyrenite) this.addOreSpawn(MFBiomes.blackForest, Blocks.stone, MFBlocks.oreAll, 2, world, x, z, 8 + rand.nextInt(4), 9, 0, 96);
		
		for(int xi = 0; xi < 1; xi++){
			int rarity = MFConfiguration.shackRarity;
			int i = x + rand.nextInt(rarity);
			int k = z + rand.nextInt(rarity);
			int j = world.getHeightValue(i, k);
			new WorldGenBlacksmithsShack(false).generate(world, rand, i, j, k);
		}
		
		for(int xi = 0; xi < 1; xi++){
			int rarity = MFConfiguration.templeRarity;
			int i = x + rand.nextInt(rarity);
			int k = z + rand.nextInt(rarity);
			int j = world.getHeightValue(i, k);
			if(biome.isEqualTo(MFBiomes.blackForest)){
				new WorldGenMagnetiteTemple(false).generate(world, rand, i, j, k);
			}
		}
	}
	
	private void generateEnd(World world, Random rand, int x, int z) {}
	
	private void generateNether(World world, Random rand, int x, int z) {}
	
	private void addOreSpawn(Block block, int metadata, World world, int x, int z,int maxV, int chance, int minY, int maxY) {
		this.addOreSpawn(Blocks.stone, block, metadata, world, x, z, maxV, chance, minY, maxY);
	}
	
	private void addOreSpawn(Block spawnsIn, Block block, int metadata, World world, int x, int z, int maxV, int chance, int minY, int maxY) {
		Random rand = world.rand;
		for(int i = 0; i < chance; i++){
			int posX = x + rand.nextInt(16);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = z + rand.nextInt(16);
			(new WorldGenMinable(block, metadata, maxV, spawnsIn)).generate(world, rand, posX, posY, posZ);
		}
	}
	
	private void addOreSpawn(BiomeGenBase biome, Block spawnsIn, Block block, int metadata, World world, int x, int z, int maxV, int chance, int minY, int maxY) {
		Random rand = world.rand;
		for(int i = 0; i < chance; i++){
			if(world.getBiomeGenForCoords(x, z).isEqualTo(biome)){
				int posX = x + rand.nextInt(16);
				int posY = minY + rand.nextInt(maxY - minY);
				int posZ = z + rand.nextInt(16);
				(new WorldGenMinable(block, metadata, maxV, spawnsIn)).generate(world, rand, posX, posY, posZ);
			}
		}
	}
	
	private void spawnBeryls(World world, int x, int z, int maxV, int chance, int minY, int maxY) {
		Random rand = world.rand;
		for(int i = 0; i < chance; i++){
			int meta = getBerylMeta(world, x, z);
			int posX = x + rand.nextInt(16);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = z + rand.nextInt(16);
			if(meta >= 0){
				(new WorldGenMinable(MFBlocks.berylAll, meta, maxV, Blocks.stone)).generate(world, rand, posX, posY, posZ);
			}
		}
	}
	
	private int getBerylMeta(World world, int x, int z){
		int meta = -1;
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		if(biome instanceof BiomeGenDesert || biome instanceof BiomeGenSavanna) meta = 0;
		else if(biome instanceof BiomeGenForest) meta = 1;
		else if(biome instanceof BiomeGenOcean || biome instanceof BiomeGenRiver) meta = 2;
		return meta;
	}
}
