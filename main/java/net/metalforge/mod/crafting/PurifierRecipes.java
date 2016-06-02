package net.metalforge.mod.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class PurifierRecipes{

	private static final PurifierRecipes PURIFYING_BASE = new PurifierRecipes();

	private Map purifyingList = new HashMap();
	private Map experienceList = new HashMap();

	public static PurifierRecipes purifying() {
		return PURIFYING_BASE;
	}

	private PurifierRecipes(){
		int oreOutput = MFConfiguration.purifyingExtraOutput + 1;
		this.addRecipe(Blocks.diamond_ore, 0, new ItemStack(Items.diamond, oreOutput), 0.5F);
		this.addRecipe(Blocks.redstone_ore, 0, new ItemStack(Items.redstone, 10), 0.5F);
		this.addRecipe(Blocks.lapis_ore, 0, new ItemStack(Items.dye, oreOutput + 8, 4), 0.5F);
		this.addRecipe(Blocks.emerald_ore, 0, new ItemStack(Items.emerald, oreOutput), 0.5F);
		this.addRecipe(Blocks.iron_ore, 0, new ItemStack(MFItems.dustIron, oreOutput), 0.5F);
		this.addRecipe(Blocks.gold_ore, 0, new ItemStack(MFItems.dustGold, oreOutput), 0.5F);
		
		this.addOreRecipe("oreCopper", new ItemStack(MFItems.dustCopper, oreOutput), 0.75F);
		this.addOreRecipe("oreTungsten", new ItemStack(MFItems.dustTungsten, oreOutput), 0.75F);
		this.addOreRecipe("oreXyrenite", new ItemStack(MFItems.xyrenite, oreOutput), 1.25F);
		this.addOreRecipe("oreBrownCoal", new ItemStack(MFItems.brownCoal, oreOutput + 1), 0.25F);
		this.addOreRecipe("oreRichCoal", new ItemStack(Items.coal, oreOutput + 4), 0.75F);

		this.addRecipe(Blocks.coal_ore, 0, new ItemStack(Items.coal, oreOutput + 1), 0.5F);
		this.addRecipe(Blocks.quartz_ore, 0, new ItemStack(Items.quartz, oreOutput + 1), 0.5F);
		this.addRecipe(Items.wheat, new ItemStack(Items.wheat_seeds, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.coal, 1, 0), new ItemStack(MFItems.coalCoke), 1.0F);
		this.addRecipe(Blocks.gravel, 0, new ItemStack(Items.flint, 1), 0.1F);
		
		this.addRecipe(MFBlocks.berylAll,  0,  new ItemStack(MFItems.berylliumRaw), 0.6F);
		this.addRecipe(MFBlocks.berylAll,  1,  new ItemStack(MFItems.berylliumRaw), 0.6F);
		this.addRecipe(MFBlocks.berylAll,  2,  new ItemStack(MFItems.berylliumRaw), 0.6F);
		this.addRecipe(Items.emerald,  new ItemStack(MFItems.berylliumRaw, 4), 2.0F);
		this.addRecipe(Items.rotten_flesh, new ItemStack(Items.leather), 0.5F);
	}
	
	public void addOreRecipe(String ore, ItemStack itemstack, float experience){
		ArrayList<ItemStack> oreList = OreDictionary.getOres(ore);
		if(!oreList.isEmpty()){
			for(int i = 0; i < oreList.size(); i++){
				this.putLists(oreList.get(i), itemstack, experience);
			}
		}
	}

	public void addRecipe(Item item, ItemStack itemstack, float experience){
		this.addLists(item, itemstack, experience);
	}
	
	public void addRecipe(Block block, int meta, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(Item.getItemFromBlock(block), 0, meta), itemstack, experience);
	}
	
	public void addRecipe(ItemStack input, ItemStack ouput, float experience){
		this.putLists(input, ouput, experience);
	}

	public void addLists(Item item, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
	}

	public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience){
		this.purifyingList.put(itemstack, itemstack2);
		this.experienceList.put(itemstack2, Float.valueOf(experience));
	}
	
	public Map getPurifyingList(){
		return purifyingList;
	}

	public ItemStack getPurifyingResult(ItemStack itemstack) {
		Iterator iterator = this.purifyingList.entrySet().iterator();
		Entry entry;

		do{
			if(!iterator.hasNext()) return null;
			entry = (Entry)iterator.next();
		}while(!canBePurified(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack)entry.getValue();
	}

	private boolean canBePurified(ItemStack itemstack, ItemStack itemstack2) {
		return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
	}

	public float giveExperience(ItemStack itemstack){
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do{
			if(!iterator.hasNext()){
				return 0.0f;
			}

			entry = (Entry) iterator.next();
		}
		while(!this.canBePurified(itemstack, (ItemStack) entry.getKey()));

		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
				return itemstack.getItem().getSmeltingExperience(itemstack);
		}

		return ((Float) entry.getValue()).floatValue();
	}
}