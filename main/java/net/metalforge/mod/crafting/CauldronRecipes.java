package net.metalforge.mod.crafting;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.metalforge.mod.items.ItemHot;
import net.metalforge.mod.items.MFItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CauldronRecipes{

	private static final CauldronRecipes COOLING_BASE = new CauldronRecipes();

	private Map CoolingList = new HashMap();

	public static CauldronRecipes cooling() {
		return COOLING_BASE;
	}

	private CauldronRecipes(){

		this.addRecipe(MFItems.hotIron);
		this.addRecipe(MFItems.hotGold);
		
		this.addRecipe(MFItems.hotCopper);
		this.addRecipe(MFItems.hotTungsten);
		this.addRecipe(MFItems.hotSteel);
		this.addRecipe(MFItems.hotBerylBronze);
		this.addRecipe(MFItems.hotXyrenium);
		this.addRecipe(MFItems.hotDragoonyte);
		
	}
	
	public void addOreRecipe(String ore, ItemStack itemstack){
		ArrayList<ItemStack> oreList = OreDictionary.getOres(ore);
		if(!oreList.isEmpty()){
			for(int i = 0; i < oreList.size(); i++){
				this.putLists(oreList.get(i), itemstack);
			}
		}
	}

	public void addRecipe(Item item){
		if(item instanceof ItemHot){
			this.addLists(item, new ItemStack(((ItemHot)item).getCoolItem()));
		}
	}
	
	public void addRecipe(Item item, Item output){
		this.addLists(item, new ItemStack(output));
	}

	public void addLists(Item item, ItemStack itemstack){
		this.putLists(new ItemStack(item, 1, 32767), itemstack);
	}

	public void putLists(ItemStack itemstack, ItemStack itemstack2){
		this.CoolingList.put(itemstack, itemstack2);
	}
	
	public Map getCoolingList(){
		return CoolingList;
	}

	public ItemStack getCoolingResult(ItemStack itemstack) {
		Iterator iterator = this.CoolingList.entrySet().iterator();
		Entry entry;

		do{
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeCooled(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeCooled(ItemStack itemstack, ItemStack itemstack2) {
		return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
	}
}