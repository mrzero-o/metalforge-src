package net.metalforge.mod.minetweaker;

import minetweaker.MineTweakerAPI;
import minetweaker.OneWayAction;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.metalforge.mod.crafting.MetalworkingManager;
import net.minecraft.item.crafting.IRecipe;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.metalforge.MetalWorkStation")
public class MetalWorkStation {
	
	@ZenMethod
	public static void addShaped(IItemStack output, IIngredient[][] input){
		MineTweakerAPI.apply(new MetalWorkAction(output, input));
	}
	
	@ZenMethod
	public static void addShapeless(IItemStack output, IIngredient[] input){
		MineTweakerAPI.apply(new MetalWorkAction(output, input));
	}
	
	public static class MetalWorkAction extends OneWayAction{
		
		private IItemStack output;
		private IIngredient[][] input;
		private IIngredient[] input2;
		private boolean shaped;
		
		public MetalWorkAction(IItemStack output, IIngredient[][] input) {
			this.output = output;
			this.input = input;
			shaped = true;
		}
		
		public MetalWorkAction(IItemStack output, IIngredient[] input) {
			this.output = output;
			this.input2 = input;
			shaped = false;
		}
		
		@Override
		public void apply() {
			if(shaped){
				IRecipe r = new ShapedMWRecipe(input, output);
				MetalworkingManager.getInstance().addRecipe(r);
			}else{
				IRecipe r = new ShapelessMWRecipe(input2, output);
				MetalworkingManager.getInstance().addRecipe(r);
			}
		}

		@Override
		public String describe() {
			return "Adding a Metal Work Station Recipe..";
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
		
	}
	
}
