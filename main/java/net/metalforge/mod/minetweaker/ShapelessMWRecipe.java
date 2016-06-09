package net.metalforge.mod.minetweaker;

import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapelessMWRecipe implements IRecipe{
	
	private IIngredient[] input;
	private IItemStack output;
	
	public ShapelessMWRecipe(IIngredient[] input, IItemStack output) {
		this.input = input;
		this.output = output;
	}
	
	@Override
	public boolean matches(InventoryCrafting inv, World w) {
		boolean matches[] = new boolean[this.input.length];
		boolean items[][] = new boolean[3][3];
		for(int a = 0; a < this.input.length; a++){
			IIngredient i = this.input[a];
			if(i == null) return false;
			for(IItemStack s : i.getItems()){
				ItemStack ingred = MineTweakerMC.getItemStack(s);
				boolean found = false;
				for(int x = 0; x < 3; x++){
					for(int y = 0; y < 3; y++){
						ItemStack stack = inv.getStackInRowAndColumn(x, y);
						if(stack == null) continue;
						if(stack.getItem() == ingred.getItem() && stack.getItemDamage() == ingred.getItemDamage() && !items[x][y]){
							matches[a] = true;
							items[x][y] = true;
							found = true;
							break;
						}
					}
					if(found)break;
				}
				if(found)break;
			}
		}
		boolean isMatch = true;
		for(boolean b : matches) if(!b) isMatch = false;
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(!items[x][y] && inv.getStackInRowAndColumn(x, y) != null) isMatch = false;
			}
		}
		return isMatch;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return this.getRecipeOutput().copy();
	}

	@Override
	public int getRecipeSize() {
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return MineTweakerMC.getItemStack(output).copy();
	}
	
}
