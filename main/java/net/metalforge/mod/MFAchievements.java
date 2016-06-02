package net.metalforge.mod;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.MFItems;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MFAchievements {
	
	public static void init(){
		registerAchivements();
	}
	
	public static Achievement getCopper;
	public static Achievement getCoalCoke;
	public static Achievement getXyrenite;
	
	public static Achievement craftHTOven;
	public static Achievement craftPurifier;
	public static Achievement craftHTSmelter;
	public static Achievement craftCauldron;
	public static Achievement craftMetalworkStation;

	public static Achievement makeTongs;
	public static Achievement makeSteelBow;
	public static Achievement makeBerylliumBow;
	
	public static Achievement alloySteel;
	public static Achievement alloyBerylBronze;
	public static Achievement alloyXyrenium;
	public static Achievement alloyElecBrass;
	
	public static void registerAchivements(){
		
		getCopper = new Achievement("achievement.getCopper", "getCopper", 0, 0, MFItems.ingotCopper, (Achievement)null).registerStat().initIndependentStat();
		getXyrenite = new Achievement("achievement.getXyrenite", "getXyrenite", 2, 0, MFItems.xyrenite, (Achievement)null).registerStat().initIndependentStat();
		craftPurifier = new Achievement("achievement.craftPurifier", "craftPurifier", 0, -2, MFBlocks.PurifierActive, MFAchievements.getCopper).registerStat();
		getCoalCoke = new Achievement("achievement.getCoalCoke", "getCoalCoke", -2, -4, MFItems.coalCoke, MFAchievements.craftPurifier).registerStat();

		craftHTOven = new Achievement("achievement.craftOven", "craftOven", 0, 2, MFBlocks.HTOvenActive, MFAchievements.getCopper).registerStat();
		craftHTSmelter = new Achievement("achievement.craftSmelter", "craftSmelter", -1, -3, MFBlocks.HTSmelterActive, MFAchievements.getCoalCoke).registerStat();
		craftMetalworkStation = new Achievement("achievement.craftMetalworkStation", "craftMetalworkStation", -2, 2, MFBlocks.MetalworkStation, (Achievement)null).initIndependentStat().registerStat().setSpecial();

		alloySteel = new Achievement("achievement.alloySteel", "alloySteel", -4, -4, MFItems.ingotSteel, MFAchievements.getCoalCoke).registerStat();
		alloyBerylBronze = new Achievement("achievement.alloyBerylBronze", "alloyBerylBronze", -2, -2, MFItems.ingotBerylBronze, MFAchievements.craftPurifier).registerStat();
		alloyXyrenium = new Achievement("achievement.alloyXyrenium", "alloyXyrenium", 2, 2, MFItems.ingotXyrenium, MFAchievements.getXyrenite).setSpecial();
		
		makeTongs = new Achievement("achievement.makeTongs", "makeTongs", -2, 2, MFItems.Tongs, MFAchievements.getCopper).registerStat();
		makeSteelBow = new Achievement("achievement.makeSteelBow", "makeSteelBow", -4, -2, MFItems.SteelBow, MFAchievements.alloySteel).registerStat();
		makeBerylliumBow = new Achievement("achievement.makeBerylliumBow", "makeBerylliumBow", -2, 0, MFItems.BerylliumBow, MFAchievements.alloyBerylBronze).registerStat().setSpecial();

		craftCauldron = new Achievement("achievement.craftCauldron", "craftCauldron", -5, -3, Items.cauldron, MFAchievements.alloySteel).initIndependentStat().registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Metalforge", new Achievement[]{getCopper, getXyrenite, craftPurifier, getCoalCoke,craftHTOven, craftHTSmelter, craftCauldron, craftMetalworkStation, makeTongs, 
				alloySteel, alloyBerylBronze, alloyXyrenium, alloyElecBrass, makeSteelBow, makeBerylliumBow}));
	}
}
