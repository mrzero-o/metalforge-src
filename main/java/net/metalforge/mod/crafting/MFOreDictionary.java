package net.metalforge.mod.crafting;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.MFItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MFOreDictionary {
	
	public static void init(){
		registerOreDictionaryEntries();
	}

	public static void registerOreDictionaryEntries() {
		
		OreDictionary.registerOre("blockCopper", new ItemStack(MFBlocks.metalBlockAll, 1, 0));
		OreDictionary.registerOre("blockTungsten", new ItemStack(MFBlocks.metalBlockAll, 1, 1));
		OreDictionary.registerOre("blockXyrenium", new ItemStack(MFBlocks.metalBlockAll, 1, 2));
		OreDictionary.registerOre("blockSteel", new ItemStack(MFBlocks.metalBlockAll, 1, 3));
		OreDictionary.registerOre("blockBerylBronze", new ItemStack(MFBlocks.metalBlockAll, 1, 4));
		OreDictionary.registerOre("blockDragoonyte", new ItemStack(MFBlocks.metalBlockAll, 1, 5));
		
		OreDictionary.registerOre("oreCopper", new ItemStack(MFBlocks.oreAll, 1, 0));
		OreDictionary.registerOre("oreTungsten", new ItemStack(MFBlocks.oreAll, 1, 1));
		OreDictionary.registerOre("oreXyrenite", new ItemStack(MFBlocks.oreAll, 1, 2));
		OreDictionary.registerOre("oreBrownCoal", new ItemStack(MFBlocks.oreAll, 1, 3));
		OreDictionary.registerOre("oreRichCoal", new ItemStack(MFBlocks.oreAll, 1, 4));

		register("blockFuelCoke", MFBlocks.cokeBlock);

		register("ingotGold", Items.gold_ingot);
		register("ingotIron", Items.iron_ingot);
		register("ingotCopper", MFItems.ingotCopper);
		register("ingotTungsten", MFItems.ingotTungsten);
		register("ingotXyrenium", MFItems.ingotXyrenium);
		register("ingotDragoonyte", MFItems.ingotDragoonyte);
		register("ingotSteel", MFItems.ingotSteel);
		register("ingotBerylBronze", MFItems.ingotBerylBronze);
		
		register("dustCopper", MFItems.dustCopper);
		register("dustTungsten", MFItems.dustTungsten);
		register("dustIron", MFItems.dustIron);
		register("dustGold", MFItems.dustGold);
		register("dustCoal", MFItems.dustCoal);

		register("dyeBlack", MFItems.dustCoal);
		register("dyeGreen", MFItems.bioplantmass);
		
		register("fuelCoke", MFItems.coalCoke);
		register("nuggetGold", Items.gold_nugget);
		register("nuggetIron", MFItems.nuggetIron);
		register("nuggetCopper", MFItems.nuggetCopper);
		register("nuggetTungsten", MFItems.nuggetTungsten);
		register("nuggetXyrenium", MFItems.nuggetXyrenium);
		register("nuggetDragoonyte", MFItems.nuggetDragoonyte);
		register("nuggetSteel", MFItems.nuggetSteel);
		register("nuggetBerylBronze", MFItems.nuggetBerylBronze);
		
		register("itemSpring", MFItems.Spring);
		register("gearSteel", MFItems.gearSteel);
		register("gearBBronze", MFItems.gearBBronze);


		register("stickWood", MFItems.blackwoodStick);
		register("plankWood", MFBlocks.blackwoodPlanks);
		register("logWood", MFBlocks.blackwoodLog);
	}
	
	private static void register(String codename, Item item){
		OreDictionary.registerOre(codename, item);
	}
	
	private static void register(String codename, Block block){
		OreDictionary.registerOre(codename, block);
	}
}
