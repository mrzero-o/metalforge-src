package net.metalforge.mod.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.metalforge.mod.items.MFItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OvenRecipes{

	private static final OvenRecipes HEAT_TREATING_BASE = new OvenRecipes();

	private Map heatTreatingList = new HashMap();
	private Map experienceList = new HashMap();

	public static OvenRecipes heatTreating() {
		return HEAT_TREATING_BASE;
	}

	private OvenRecipes(){

		this.addOreRecipe("ingotIron", new ItemStack(MFItems.hotIron), 1.0F);
		this.addOreRecipe("ingotGold", new ItemStack(MFItems.hotGold), 1.0F);
		
		this.addOreRecipe("ingotCopper", new ItemStack(MFItems.hotCopper), 1.0F);
		this.addOreRecipe("ingotTungsten", new ItemStack(MFItems.hotTungsten), 1.0F);
		this.addOreRecipe("ingotSteel", new ItemStack(MFItems.hotSteel), 1.0F);
		this.addOreRecipe("ingotBerylBronze", new ItemStack(MFItems.hotBerylBronze), 1.0F);
		this.addOreRecipe("ingotXyrenium", new ItemStack(MFItems.hotXyrenium), 1.0F);
		this.addOreRecipe("ingotDragoonyte", new ItemStack(MFItems.hotDragoonyte), 1.0F);
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

	public void addLists(Item item, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
	}

	public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience){
		this.heatTreatingList.put(itemstack, itemstack2);
		this.experienceList.put(itemstack2, Float.valueOf(experience));
	}
	
	public Map getHeatTreatingList(){
		return heatTreatingList;
	}

	public ItemStack getHeatTreatingResult(ItemStack itemstack) {
		Iterator iterator = this.heatTreatingList.entrySet().iterator();
		Entry entry;

		do{
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeHeatTreated(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeHeatTreated(ItemStack itemstack, ItemStack itemstack2) {
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
		while(!this.canBeHeatTreated(itemstack, (ItemStack) entry.getKey()));

		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
				return itemstack.getItem().getSmeltingExperience(itemstack);
		}

		return ((Float) entry.getValue()).floatValue();
	}
}