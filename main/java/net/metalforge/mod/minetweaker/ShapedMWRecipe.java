package net.metalforge.mod.minetweaker;

import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapedMWRecipe implements IRecipe{
	
	private IIngredient[][] input;
	private IItemStack output;
	
	public ShapedMWRecipe(IIngredient[][] input, IItemStack output) {
		this.input = input;
		this.output = output;
	}
	
	@Override
	public boolean matches(InventoryCrafting inv, World w) {
		boolean matches = true;
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(!matches) return false;
				ItemStack stack = inv.getStackInRowAndColumn(x, y);
				
				if(stack == null && this.input[y][x] == null){
					continue;
				}
				boolean hasMatch = false;
				if(stack != null && this.input[y][x] != null){
					for(IItemStack i : this.input[y][x].getItems()){
						ItemStack ingred = MineTweakerMC.getItemStack(i);
						if(stack.getItem() == ingred.getItem() && stack.getItemDamage() == stack.getItemDamage()){
							hasMatch = true;
						}
					}
				}else{
					matches = false;
				}
				if(!hasMatch) matches = false;
			}
		}
		return matches;
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
