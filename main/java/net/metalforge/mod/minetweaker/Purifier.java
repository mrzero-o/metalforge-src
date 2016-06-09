package net.metalforge.mod.minetweaker;

import minetweaker.MineTweakerAPI;
import minetweaker.OneWayAction;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.metalforge.mod.crafting.PurifierRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

// Defines import... to put in scripts simply do -> import mods.metalforge.Purifier; <- in the zen script
@ZenClass("mods.metalforge.Purifier")
public class Purifier {
	
	// defines method to use after importing... ex: Purifier.addRecipe(<minecraft:diamond>, <minecraft:emerald>, 2.0); -- That would have emeralds turn into diamonds
	@ZenMethod()
	public static void addRecipe(IItemStack output, IIngredient input, double experience){
		MineTweakerAPI.apply(new PurifierAction(output, input, (float)experience));
	}
	
	// Class that defines how to add the recipe, it also holds the recipe just incase it needs to be removed
	public static class PurifierAction extends OneWayAction{
		
		IItemStack output;
		IIngredient input;
		float experience;
		
		public PurifierAction(IItemStack output, IIngredient input, float experience) {
			this.output = output;
			this.input = input;
			this.experience = experience;
		}
		
		// Actually adds the recipe
		@Override
		public void apply() {
			//IIngredients can contain ore dictionary items so we want to loop through the items
			for(IItemStack item : input.getItems()){
				ItemStack i = MineTweakerMC.getItemStack(item);
				PurifierRecipes.purifying().addRecipe(i, MineTweakerMC.getItemStack(output), experience);
			}
		}

		// Describes what we are doing...
		@Override
		public String describe() {
			return "Adding a Purifier Recipe";
		}
		
		
		// I just leave this null
		@Override
		public Object getOverrideKey() {
			return null;
		}
		
		
		
	}
		
}
