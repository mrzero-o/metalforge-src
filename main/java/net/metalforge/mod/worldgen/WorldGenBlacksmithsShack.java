package net.metalforge.mod.worldgen;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.util.Random;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.random.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class WorldGenBlacksmithsShack extends WorldGenerator
{
	private boolean bypass;
	
	public WorldGenBlacksmithsShack(boolean bypass){
		this.bypass = bypass;
	}
	
	protected Block[] GetValidSpawnBlocks()
	{
		return new Block[]{Blocks.grass, Blocks.mycelium, MFBlocks.ancientGrass};
	}

	public boolean LocationIsValidSpawn(World world, int x, int y, int z)
	{
		if(bypass){
			return true;
		}
		int distanceToAir = 0;
		Block checkBlock = world.getBlock(x, y, z);

		while (checkBlock != Blocks.air)
		{
			distanceToAir++;
			checkBlock = world.getBlock(x, y + distanceToAir, z);
		}

		if (distanceToAir > 1)
		{
			return false;
		}

		y += distanceToAir - 1;

		Block block = world.getBlock(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);
		Block blockBelow = world.getBlock(x, y - 1, z);

		for (Block i : GetValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == i)
			{
				return true;
			}
			else if (block == Blocks.snow_layer && blockBelow == i){
				return true;
			}
			else if (block.getMaterial() == Material.plants && blockBelow == i)
			{
				return true;
			}
		}
		return false;
	}
	
	private int getMaybe(Random rand){
		int maybe = rand.nextInt(1);
		return maybe;
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int maybe = getMaybe(rand);
		switch(maybe){
		case 0:
			if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 8, y, z) || !LocationIsValidSpawn(world, x + 8, y, z + 8) || !LocationIsValidSpawn(world, x, y, z + 8))
			{
				return false;
			}build(rand, world, x, y, z);
			return true;
		default:
			if(!LocationIsValidSpawn(world, z, y, x) || !LocationIsValidSpawn(world, z + 8, y, x) || !LocationIsValidSpawn(world, z + 8, y, x + 8) || !LocationIsValidSpawn(world, z, y, x + 8))
			{
				return false;
			}build(rand, world, z, y, x);
			return true;
		}
	}
	
	public static void build(Random rand, World world, int x, int y, int z){
		world.setBlock(x + 0, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 0, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 1, Blocks.glowstone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 1, Blocks.glowstone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 1, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 2, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 5, Blocks.chest, 4, 3);
		world.setBlock(x + 7, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 7, Blocks.glowstone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 7, Blocks.glowstone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 1, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 2, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 3, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + -1, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 0, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.cobblestone_wall, 0, 3);
		world.setBlock(x + 2, y + 0, z + 1, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 0, z + 1, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 4, y + 0, z + 1, MFBlocks.blackwoodFenceGate, 2, 3);
		world.setBlock(x + 5, y + 0, z + 1, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 6, y + 0, z + 1, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 0, z + 1, Blocks.cobblestone_wall, 0, 3);
		world.setBlock(x + 8, y + 0, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.cauldron, 3, 3);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 0, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 8, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 3, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 3, Blocks.anvil, 2, 3);
		world.setBlock(x + 7, y + 0, z + 3, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 8, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 4, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.bed, 0, 3);
		world.setBlock(x + 3, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 0, z + 4, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 8, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 5, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 2, y + 0, z + 5, Blocks.bed, 8, 3);
		world.setBlock(x + 3, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 5, Blocks.crafting_table, 0, 3);
		world.setBlock(x + 7, y + 0, z + 5, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 8, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 2, y + 0, z + 6, Blocks.chest, 5, 3);
		world.setBlock(x + 3, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 6, Blocks.chest, 4, 3);
		world.setBlock(x + 7, y + 0, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 8, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 7, Blocks.cobblestone_wall, 0, 3);
		world.setBlock(x + 2, y + 0, z + 7, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 0, z + 7, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 4, y + 0, z + 7, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 5, y + 0, z + 7, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 6, y + 0, z + 7, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 0, z + 7, Blocks.cobblestone_wall, 0, 3);
		world.setBlock(x + 8, y + 0, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 0, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 1, z + 1, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 1, z + 1, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 1, MFBlocks.blackwoodPlanks, 1, 3);
		world.setBlock(x + 6, y + 1, z + 1, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 1, z + 1, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 8, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 8, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 3, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 8, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 2, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 4, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 8, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 5, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 2, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 5, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 8, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 2, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 8, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 7, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 1, z + 7, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 1, z + 7, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 4, y + 1, z + 7, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 5, y + 1, z + 7, Blocks.glass_pane, 0, 3);
		world.setBlock(x + 6, y + 1, z + 7, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 1, z + 7, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 8, y + 1, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 1, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 1, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 2, z + 1, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 4, y + 2, z + 1, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 5, y + 2, z + 1, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 6, y + 2, z + 1, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 2, y + 2, z + 2, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 2, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 7, y + 2, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 8, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 3, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 2, z + 3, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 8, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 4, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 3, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 2, z + 4, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 8, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 5, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 2, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 2, z + 5, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 8, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 2, y + 2, z + 6, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 3, y + 2, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 6, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 7, y + 2, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 8, y + 2, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 7, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 2, z + 7, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 4, y + 2, z + 7, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 5, y + 2, z + 7, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 6, y + 2, z + 7, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 2, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 2, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 2, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 1, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 5, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 3, z + 2, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 4, y + 3, z + 2, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 5, y + 3, z + 2, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 6, y + 3, z + 2, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 3, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 3, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 7, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 4, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 2, y + 3, z + 4, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 3, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 4, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 5, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 4, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 7, y + 3, z + 4, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 8, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 5, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 3, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 5, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 7, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 3, y + 3, z + 6, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 4, y + 3, z + 6, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 5, y + 3, z + 6, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 6, y + 3, z + 6, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 7, y + 3, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 7, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 5, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 3, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 2, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 5, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 3, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 4, y + 4, z + 3, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 5, y + 4, z + 3, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 6, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 4, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 3, y + 4, z + 4, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 4, y + 4, z + 4, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 5, y + 4, z + 4, MFBlocks.blackwoodLog, 9, 3);
		world.setBlock(x + 6, y + 4, z + 4, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 7, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 5, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 4, y + 4, z + 5, MFBlocks.blackwoodLog, 5, 3);
		world.setBlock(x + 5, y + 4, z + 5, MFBlocks.blackwoodLog, 1, 3);
		world.setBlock(x + 6, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 6, MFBlocks.blackwoodFence, 0, 3);
		world.setBlock(x + 5, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 7, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 7, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 8, y + 4, z + 8, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 2, Blocks.torch, 3, 3);
		world.setBlock(x + 2, y + 2, z + 4, Blocks.torch, 1, 3);
		world.setBlock(x + 6, y + 2, z + 4, Blocks.torch, 2, 3);
		world.setBlock(x + 4, y + 2, z + 6, Blocks.torch, 4, 3);
		
        Util.fillChest(world, x + 2, y + 0, z + 6, ChestGenHooks.VILLAGE_BLACKSMITH);
        Util.fillChest(world, x + 6, y + -1, z + 5, ChestGenHooks.PYRAMID_DESERT_CHEST);
        Util.fillChest(world, x + 6, y + 0, z + 6, ChestGenHooks.DUNGEON_CHEST);
	}
}