package net.metalforge.mod.random;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.metalforge.mod.blocks.BlockOres;
import net.minecraftforge.common.config.Configuration;

public class MFConfiguration {
	
	public static boolean useMetalworkStation;
	
	public static boolean thunderEdgeDamagesOnLeap;

	public static boolean addStructureSpawner;
	
	public static int coalCokeBurnTime;
	public static int purifyingExtraOutput;
	public static int venomizerConversionCost;
	
	public static int blackForestRarity;
	public static int blackForestID;
	public static int shackRarity;
	public static int templeRarity;
	
	public static float heavyOrbDamage;
	public static float carbonDiabloPower;
	
	public static boolean doSpawnCopper;
	public static boolean doSpawnTungsten;
	public static boolean doSpawnXyrenite;
	public static boolean doSpawnBrownCoal;
	public static boolean doSpawnRichCoal;
	
	public static boolean doSpawnBeryl;
	public static boolean doSpawnMagnetite;
	
	private static Configuration config;
	
	public static void load(File file){
		
		config = new Configuration(file);
		
		config.load();
		
		doConfigStuff(config);
		
		config.save();
		
	}
	
	private static void doConfigStuff(Configuration config){
		//Categories
		String ID = "id stuff";
		String RANDOM = "random stuff";
		String SPECIAL = "special stuff";
		//Booleans
			//Ore Spawn
			doSpawnCopper = config.get(SPECIAL, "enable copper ore spawn", true).getBoolean();
			doSpawnTungsten = config.get(SPECIAL, "enable tungsten ore spawn", true).getBoolean();
			doSpawnXyrenite = config.get(SPECIAL, "enable xyrenite ore spawn", true).getBoolean();
			doSpawnBrownCoal = config.get(SPECIAL, "enable brown coal ore spawn", true).getBoolean();
			doSpawnRichCoal = config.get(SPECIAL, "enable rich coal ore spawn", true).getBoolean();
			
			doSpawnBeryl = config.get(SPECIAL, "enable beryl crystal spawn", true).getBoolean();
			doSpawnMagnetite = config.get(SPECIAL, "enable magnetite spawn", true).getBoolean();
			//Other
			useMetalworkStation = config.get(SPECIAL, "metalwork station enabled", true).getBoolean();
			addStructureSpawner = config.get(SPECIAL, "add the structure spawner item", false).getBoolean();
		//thunderEdgeDamagesOnLeap = config.get(RANDOM, "Whether the Thunder Edge is damaged when using it to fly", true).getBoolean();
		//Integers
		coalCokeBurnTime = config.get(RANDOM, "coal coke burn time", 3200).getInt();
		purifyingExtraOutput = config.get(RANDOM, "extra pure shards", 1).getInt();
		//venomizerConversionCost = config.get(RANDOM, "How many TU are required to venomize one Raw Beryllium item", 200).getInt();
		//Special Integers
		blackForestRarity = config.get(RANDOM, "black forest rarity", 6).getInt();
		blackForestID = config.get(ID, "black forest biome id", 100).getInt();
		shackRarity = config.get(ID, "blacksmith shack rarity", 2864).getInt();
		templeRarity = config.get(ID, "magnetite temple rarity", 3248).getInt();
		//Floats
		heavyOrbDamage = (float)config.get(RANDOM, "damage dealt by heavy orbs", 7.5F).getDouble();
		carbonDiabloPower = (float)config.get(RANDOM, "carbon diablo explosion multiplier", 1.0F).getDouble();
	}

}
