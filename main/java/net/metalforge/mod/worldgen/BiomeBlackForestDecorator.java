package net.metalforge.mod.worldgen;

import java.util.Random;

import net.metalforge.mod.blocks.MFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;

public class BiomeBlackForestDecorator extends BiomeDecorator {

	public BiomeBlackForestDecorator()
    {
		super();
        this.sandGen = new WorldGenSand(Blocks.clay, 7);
        this.gravelAsSandGen = new WorldGenSand(Blocks.gravel, 6);
        this.dirtGen = new WorldGenMinable(MFBlocks.ancientSoil, 32);
        this.gravelGen = new WorldGenMinable(Blocks.sand, 32);
        this.coalGen = new WorldGenMinable(Blocks.coal_ore, 24);
        this.ironGen = new WorldGenMinable(Blocks.iron_ore, 12);
        this.goldGen = new WorldGenMinable(Blocks.gold_ore, 12);
        this.redstoneGen = new WorldGenMinable(Blocks.redstone_ore, 11);
        this.diamondGen = new WorldGenMinable(Blocks.diamond_ore, 11);
        this.lapisGen = new WorldGenMinable(Blocks.lapis_ore, 9);
        this.flowersPerChunk = 7;
        this.grassPerChunk = 5;
        this.sandPerChunk = 0;
        this.sandPerChunk2 = 0;
        this.clayPerChunk = 5;
        this.generateLakes = true;
        this.treesPerChunk = 2;
    }
}
