package net.metalforge.mod.minetweaker;

import minetweaker.MineTweakerAPI;
import minetweaker.OneWayAction;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.metalforge.mod.crafting.CauldronRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.metalforge.Cauldron")
public class Cauldron {
	
	
	//DOES NOT WORK.... NEEDS TO BE EDITED
	
	@ZenMethod
	public static void addRecipe(IItemStack output, IIngredient input){
		MineTweakerAPI.apply(new CauldronAction(output, input));
	}
	
	public static class CauldronAction extends OneWayAction{

		private IItemStack output;
		private IIngredient input;
		
		public CauldronAction(IItemStack output, IIngredient input) {
			this.output = output;
			this.input = input;
		}
		
		@Override
		public void apply() {
			for(IItemStack i : this.input.getItems()){
				ItemStack stack = MineTweakerMC.getItemStack(i);
				CauldronRecipes.cooling().putLists(stack, MineTweakerMC.getItemStack(output));
			}
		}

		@Override
		public String describe() {
			return "Adding cauldron recipe...";
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
		
	}
	
}
