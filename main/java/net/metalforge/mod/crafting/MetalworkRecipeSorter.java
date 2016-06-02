package net.metalforge.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MetalworkRecipeSorter implements Comparator {

	final MetalworkingManager metalwork;

	public MetalworkRecipeSorter(MetalworkingManager metalworkCraftingManager) {
		this.metalwork = metalworkCraftingManager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		
		if(isShapeless(irecipe1) && isShaped(irecipe2)){
			return 1;
		}else if(isShapeless(irecipe2) && isShaped(irecipe1)){
			return -1;
		}else if(irecipe2.getRecipeSize() < irecipe1.getRecipeSize()){
			return -1;
		}else if(irecipe2.getRecipeSize() > irecipe1.getRecipeSize()){
			return 1;
		}else return 0;
		
	}
	
	private boolean isShapeless(IRecipe irecipe){
		return irecipe instanceof ShapelessRecipes || irecipe instanceof ShapelessOreRecipe;
	}
	
	private boolean isShaped(IRecipe irecipe){
		return irecipe instanceof ShapedRecipes || irecipe instanceof ShapedOreRecipe;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}