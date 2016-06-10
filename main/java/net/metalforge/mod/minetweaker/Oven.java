package net.metalforge.mod.minetweaker;

import minetweaker.MineTweakerAPI;
import minetweaker.OneWayAction;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.metalforge.mod.crafting.OvenRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.metalforge.Oven")
public class Oven {
	
	@ZenMethod
	public static void addRecipe(IItemStack output, IIngredient input, double exp){
		MineTweakerAPI.apply(new OvenAction(output, input, (float)exp));
	}
	
	public static class OvenAction extends OneWayAction{
		
		IItemStack output;
		IIngredient input;
		float exp;
		
		public OvenAction(IItemStack output, IIngredient input, float exp) {
			this.output = output;
			this.input = input;
			this.exp = exp;
		}
		
		@Override
		public void apply() {
			for(IItemStack i : input.getItems()){
				ItemStack stack = MineTweakerMC.getItemStack(i);
				OvenRecipes.heatTreating().putLists(stack, MineTweakerMC.getItemStack(output), exp);
			}
		}

		@Override
		public String describe() {
			return "Adding Oven Recipe...";
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
		
	}
	
}
