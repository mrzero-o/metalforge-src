package net.metalforge.mod.crafting;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.MFItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class MFCrafting {
	
	public static void init(){
		removeRecipes();
		addRecipes();
	}
	
	public static void removeRecipes(){
		Map<ItemStack, ItemStack> smeltingRecipes = FurnaceRecipes.smelting().getSmeltingList();
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> remover = recipes.iterator();
		//Remove smelting
		/*for (Iterator<Map.Entry<ItemStack,ItemStack>> entries = smeltingRecipes.entrySet().iterator(); entries.hasNext(); ){
			Map.Entry<ItemStack,ItemStack> entry = entries.next();
			ItemStack result = entry.getValue();
			if(ItemStack.areItemStacksEqual(result, new ItemStack(Items.iron_ingot))) entries.remove();
			if(ItemStack.areItemStacksEqual(result, new ItemStack(Items.gold_ingot))) entries.remove();
			//Ore Dic shit
			ArrayList<ItemStack> copperinoList = OreDictionary.getOres("ingotCopper");
			ArrayList<ItemStack> tungstenList = OreDictionary.getOres("ingotTungsten");
			if(!copperinoList.isEmpty()){
				for(int i = 0; i < copperinoList.size(); i++){
					if(ItemStack.areItemStacksEqual(result, copperinoList.get(i))) entries.remove();
				}
			}if(!tungstenList.isEmpty()){
				for(int i = 0; i < tungstenList.size(); i++){
					if(ItemStack.areItemStacksEqual(result, tungstenList.get(i))) entries.remove();
				}
			}
		}*/
		//Remove crafting
		while(remover.hasNext()){
			ItemStack itemstack = remover.next().getRecipeOutput();
			if(itemstack != null){
				if(itemstack.getItem() == Items.minecart) remover.remove();
				else if(itemstack.getItem() == Items.flint_and_steel) remover.remove();
				else if(itemstack.getItem() == Items.cauldron) remover.remove();
				else if(itemstack.getItem() == Item.getItemFromBlock(Blocks.rail)) remover.remove();
				else if(itemstack.getItem() == Item.getItemFromBlock(Blocks.activator_rail)) remover.remove();
				else if(itemstack.getItem() == Item.getItemFromBlock(Blocks.anvil)) remover.remove();
			}
		}
	}
	
	public static void addRecipes() {
		newRecipe(new ShapedOreRecipe(new ItemStack(Items.flint_and_steel), new Object[]{"SS", " F", 'S', "nuggetSteel", 'F', Items.flint}));
		newRecipe(new ItemStack(MFBlocks.blackwoodStairs, 4), new Object[]{"W  ", "WW ", "WWW", 'W', MFBlocks.blackwoodPlanks});
		newRecipe(new ItemStack(MFBlocks.blackwoodSlab, 6), new Object[]{"WWW", 'W', MFBlocks.blackwoodPlanks});
		
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.DrinkingHelmet), new Object[]{"IBI", "C C", 'I', "ingotIron", 'C', "ingotCopper", 'B', Items.bucket}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.SpringBoots), new Object[]{"I I", "S S", 'I', "ingotSteel", 'S', "itemSpring"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.MetalBall), new Object[]{"nuggetIron", "nuggetIron", "nuggetBerylBronze", "nuggetTungsten"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(Blocks.rail, 16), new Object[]{"ISI", "ISI", "ISI", 'I', "ingotSteel", 'S', "stickWood"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.SpringRail, 3), new Object[]{"ISI", "IPI", "ISI", 'I', "ingotSteel", 'S', "stickWood", 'P', new ItemStack(MFBlocks.SpringPad, 1, 2)}));
		newRecipe(new ShapedOreRecipe(new ItemStack(Blocks.activator_rail, 6), new Object[]{"ISI", "IPI", "ISI", 'I', "ingotSteel", 'S', "stickWood", 'P', Blocks.stone_pressure_plate}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.CarbonDiablo), new Object[]{"TGT", "TPT", "SFS", 'T', "ingotTungsten", 'G', "gearBBronze", 'P', Items.gunpowder, 'F', Blocks.furnace, 'S', "stickWood"}));
		newRecipe(new ItemStack(MFBlocks.magnetiteAll, 4, 3), new Object[]{"MM", "MM", 'M', new ItemStack(MFBlocks.magnetiteAll, 1, 5)});
		newRecipe(new ItemStack(MFBlocks.magnetiteAll, 4, 5), new Object[]{"MM", "MM", 'M', new ItemStack(MFBlocks.magnetiteAll, 1, 2)});
		newRecipe(new ItemStack(MFBlocks.magnetiteAll, 4, 2), new Object[]{"MM", "MM", 'M', new ItemStack(MFBlocks.magnetiteAll, 1, 4)});
		newRecipe(new ItemStack(MFBlocks.magnetiteAll, 4, 4), new Object[]{"MM", "MM", 'M', new ItemStack(MFBlocks.magnetiteAll, 1, 0)});
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.dustCoal, 2), new Object[]{new ItemStack(Items.coal, 1, 0), Items.flint}));
		newRecipe(new ShapedOreRecipe(MFItems.T1RockShovel, new Object[]{" SS", "GFS", "II ", 'S', "ingotIron", 'G', "gearSteel", 'F', Blocks.furnace, 'I', "ingotCopper"}));
		newRecipe(new ShapedOreRecipe(MFItems.T2RockShovel, new Object[]{" TT", "GFT", "II ", 'T', "ingotTungsten", 'G', "gearBBronze", 'F', Blocks.furnace, 'I', "ingotIron"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.SteelBow), new Object[]{" IS", "IBS", " IS", 'I', "ingotSteel", 'S', Items.string, 'B', Items.bow}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.BerylliumBow), new Object[]{" IS", "IBS", " IS", 'I', "ingotBerylBronze", 'S', Items.string, 'B', MFItems.SteelBow}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.XyreniumBow), new Object[]{" IS", "IBS", " IS", 'I', "ingotXyrenium", 'S', Items.string, 'B', MFItems.BerylliumBow}));
		newRecipe(new ItemStack(MFItems.blackwoodStick, 4), new Object[]{"W", "W", 'W', MFBlocks.blackwoodPlanks});
		newRecipe(new ItemStack(MFBlocks.blackwoodFence, 2), new Object[]{"SSS", "SSS", 'S', MFItems.blackwoodStick});
		newRecipe(new ItemStack(MFBlocks.blackwoodFenceGate), new Object[]{"SWS", "SWS", 'S', MFItems.blackwoodStick, 'W', MFBlocks.blackwoodPlanks});
		newRecipe(new ItemStack(MFBlocks.LampOff, 1, 0), new Object[]{"WWW", "S S", "WWW", 'W', MFBlocks.blackwoodPlanks, 'S', MFItems.blackwoodStick});
    	
		//Tools n shits
		toolRecipes("ingotSteel", MFItems.SteelSword, MFItems.SteelPickaxe, MFItems.SteelAxe, MFItems.SteelSpade, MFItems.SteelHoe, MFItems.SteelDagger, MFItems.SteelSkogAxe);
		toolRecipes("ingotBerylBronze", MFItems.BBSword, MFItems.BBPickaxe, MFItems.BBAxe, MFItems.BBSpade, MFItems.BBHoe, MFItems.BBDagger, MFItems.BBSkogAxe);
		toolRecipes("ingotXyrenium", MFItems.XyreniumSword, MFItems.XyreniumPickaxe, MFItems.XyreniumAxe, MFItems.XyreniumSpade, MFItems.XyreniumHoe, MFItems.XyreniumDagger, MFItems.XyreniumSkogAxe);
    	//Armors n shits
		armorRecipes("ingotSteel", MFItems.SteelHelmet, MFItems.SteelChestplate, MFItems.SteelLeggings, MFItems.SteelBoots);
	 	armorRecipes("ingotBerylBronze", MFItems.BBHelmet, MFItems.BBChestplate, MFItems.BBLeggings, MFItems.BBBoots);
    	armorRecipes("ingotXyrenium", MFItems.XyreniumHelmet, MFItems.XyreniumChestplate, MFItems.XyreniumLeggings, MFItems.XyreniumBoots);
		
    	//Other shits
    	newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.xyreniteX), new Object[]{MFItems.berylliumRaw,  MFItems.berylliumRaw, MFItems.xyrenite, new ItemStack(Items.dye, 1, 4)}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.MetalworkStation), new Object[]{"III", "NCN", "III", 'I', "ingotIron", 'C', Blocks.crafting_table, 'N', "nuggetIron"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.blastWall, 8), new Object[]{"STS", "TST", "STS", 'S', "ingotSteel", 'T', "ingotTungsten"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.SpringPad, 1, 0), new Object[]{"CWC", "SPS", "CCC", 'C', Blocks.cobblestone, 'W', Blocks.piston, 'S', "itemSpring", 'P', "ingotCopper"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.SpringPad, 1, 1), new Object[]{" P ", "SWS", 'S', "itemSpring", 'P', "ingotIron", 'W', new ItemStack(MFBlocks.SpringPad, 1, 0)}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.SpringPad, 1, 2), new Object[]{" P ", "SWS", 'S', "itemSpring", 'P', "ingotGold", 'W', new ItemStack(MFBlocks.SpringPad, 1, 1)}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.Spring), new Object[]{"NN ", " NN", "NN ", 'N', "nuggetBerylBronze"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.HTOvenIdle), new Object[]{"BCB", "S S", "BIB", 'C', "ingotCopper", 'S', Items.coal, 'B', Blocks.brick_block, 'I', "ingotIron"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.HTSmelterIdle), new Object[]{"BCB", "S S", "BIB", 'C', "ingotCopper", 'S', "itemCoalCoke", 'B', Blocks.brick_block, 'I', "ingotIron"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.PurifierIdle), new Object[]{"BCB", "S S", "BIB", 'C', "ingotCopper", 'S', new ItemStack(Items.potionitem, 1, 0), 'B', Blocks.brick_block, 'I', "ingotIron"}));

		newRecipe(new ShapedOreRecipe (new ItemStack(MFBlocks.cokeBlock), new Object[]{"CCC", "CCC", "CCC", 'C', "itemCoalCoke"}));

		newShapelessRecipe(new ItemStack(MFItems.coalCoke, 9), new Object[]{MFBlocks.cokeBlock});
		newShapelessRecipe(new ItemStack(MFBlocks.blackwoodPlanks, 4), new Object[]{MFBlocks.blackwoodLog});
		
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.biofertilizer), new Object[]{MFItems.bioplantmass, Blocks.dirt, "dustCoal"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.biofertilizer, 2), new Object[]{MFItems.bioplantmass, MFBlocks.ancientSoil, "dustCoal"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.bioplantmass), new Object[]{"treeSapling"}));
		
		//Blocks to ingots
		GameRegistry.addShapelessRecipe(new ItemStack(MFItems.ingotCopper, 9), new Object[]{new ItemStack(MFBlocks.metalBlockAll, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(MFItems.ingotTungsten, 9), new Object[]{new ItemStack(MFBlocks.metalBlockAll, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(MFItems.ingotXyrenium, 9), new Object[]{new ItemStack(MFBlocks.metalBlockAll, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(MFItems.ingotSteel, 9), new Object[]{new ItemStack(MFBlocks.metalBlockAll, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(MFItems.ingotBerylBronze, 9), new Object[]{new ItemStack(MFBlocks.metalBlockAll, 1, 4)});
		GameRegistry.addShapelessRecipe(new ItemStack(MFItems.ingotDragoonyte, 9), new Object[]{new ItemStack(MFBlocks.metalBlockAll, 1, 5)});
		//Ingots to blocks
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.metalBlockAll, 1, 0), new Object[]{"III", "III", "III", 'I', "ingotCopper"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.metalBlockAll, 1, 1), new Object[]{"III", "III", "III", 'I', "ingotTungsten"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.metalBlockAll, 1, 2), new Object[]{"III", "III", "III", 'I', "ingotXyrenium"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.metalBlockAll, 1, 3), new Object[]{"III", "III", "III", 'I', "ingotSteel"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.metalBlockAll, 1, 4), new Object[]{"III", "III", "III", 'I', "ingotBerylBronze"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.metalBlockAll, 1, 5), new Object[]{"III", "III", "III", 'I', "ingotDragoonyte"}));
		//Ingots to nuggets
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetIron, 9), new Object[]{"ingotIron"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetCopper, 9), new Object[]{"ingotCopper"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetTungsten, 9), new Object[]{"ingotTungsten"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetXyrenium, 9), new Object[]{"ingotXyrenium"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetDragoonyte, 9), new Object[]{"ingotDragoonyte"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetSteel, 9), new Object[]{"ingotSteel"}));
		newRecipe(new ShapelessOreRecipe(new ItemStack(MFItems.nuggetBerylBronze, 9), new Object[]{"ingotBerylBronze"}));
		//Nuggets to ingots
		newRecipe(new ShapedOreRecipe(Items.iron_ingot, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetIron"}));
		newRecipe(new ShapedOreRecipe(MFItems.ingotCopper, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetCopper"}));
		newRecipe(new ShapedOreRecipe(MFItems.ingotTungsten, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetTungsten"}));
		newRecipe(new ShapedOreRecipe(MFItems.ingotXyrenium, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetXyrenium"}));
		newRecipe(new ShapedOreRecipe(MFItems.ingotDragoonyte, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetDragoonyte"}));
		newRecipe(new ShapedOreRecipe(MFItems.ingotSteel, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetSteel"}));
		newRecipe(new ShapedOreRecipe(MFItems.ingotBerylBronze, new Object[]{"NNN", "NNN", "NNN", 'N', "nuggetBerylBronze"}));
		//Ex-Metalwork station shit
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.Armorslayer), new Object[]{" BB", "BTB", "TB ", 'T', "ingotTungsten", 'B', "ingotBerylBronze"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(MFBlocks.HeatCoil), new Object[]{"CTC", "CTC", "CTC", 'C', "ingotCopper", 'T', "nuggetTungsten"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.GrapplingHook), new Object[]{"II", " I", "I ", 'I', "ingotSteel"}));
    	
		newRecipe(new ShapedOreRecipe(new ItemStack(Items.minecart), new Object[]{"I I", "III", 'I', "ingotSteel"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(Items.cauldron), new Object[]{"I I", "I I", "III", 'I', "ingotSteel"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(Blocks.anvil)), new Object[]{"PPP", " I ", "III", 'P', "ingotSteel",'I', "blockSteel"}));
		
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.Tongs), new Object[]{" C ", "C C", "C C", 'C', "ingotCopper"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(MFBlocks.WorldAnchor)), new Object[]{" I ", " I ", "PPP", 'I', "ingotSteel", 'P', "blockSteel"}));

		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.gearSteel), new Object[]{" S ", "SIS", " S ", 'I', "ingotIron", 'S', "ingotSteel"}));
		newRecipe(new ShapedOreRecipe(new ItemStack(MFItems.gearBBronze), new Object[]{" T ", "TIT", " T ", 'I', "ingotIron", 'T', "ingotBerylBronze"}));
		
	}
	
	private static void toolRecipes(String ingot, Item sword, Item pick, Item axe, Item spade, Item hoe, Item dagger, Item skogaxe){

		newRecipe(new ShapedOreRecipe(new ItemStack(sword), new Object[]{"S", "S", "R", 'S', ingot, 'R', "stickWood"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(pick), new Object[]{"SSS", " R ", " R ", 'S', ingot, 'R', "stickWood"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(axe), new Object[]{"SS", "RS", "R ", 'S', ingot, 'R', "stickWood"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(spade), new Object[]{"S", "R", "R", 'S', ingot, 'R', "stickWood"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(hoe), new Object[]{"SS", "R ", "R ", 'S', ingot, 'R', "stickWood"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(dagger), new Object[]{"S", "R", 'S', ingot, 'R', "stickWood"}));
    	newRecipe(new ShapedOreRecipe(new ItemStack(skogaxe), new Object[]{"SSS", "RSS", "R  ", 'S', ingot, 'R', "stickWood"}));
    	
	}
	
	private static void armorRecipes(String ingot, Item helmet, Item chest, Item pants, Item boots){
		newRecipe(new ShapedOreRecipe(new ItemStack(helmet), new Object[]{"MMM", "M M", 'M', ingot}));
		newRecipe(new ShapedOreRecipe(new ItemStack(chest), new Object[]{"M M", "MMM", "MMM", 'M', ingot}));
		newRecipe(new ShapedOreRecipe(new ItemStack(pants), new Object[]{"MMM", "M M", "M M", 'M', ingot}));
		newRecipe(new ShapedOreRecipe(new ItemStack(boots), new Object[]{"M M", "M M", 'M', ingot}));
    }
	
	private static ItemStack getEmpty(Item item){
		return new ItemStack(item, item.getMaxDamage());
	}
	
	private static void newShapelessRecipe(ItemStack output, Object... params){
		GameRegistry.addShapelessRecipe(output, params);
	}
	
	private static void newRecipe(ItemStack output, Object... params){
		GameRegistry.addRecipe(output, params);
	}
	
	private static void newRecipe(IRecipe irecipe){
		GameRegistry.addRecipe(irecipe);
	}
}
