package net.metalforge.mod.compat.nei;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.blocks.MFBlocks;
import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEICompatibility implements IConfigureNEI{

	@Override
	public String getName() {
		return MFMod.MODID;
	}

	@Override
	public String getVersion() {
		return MFMod.VERSION;
	}

	@Override
	public void loadConfig() {
		
		//Recipe Handlers
        API.registerRecipeHandler(new CauldronRecipeHandler());
        
        API.registerRecipeHandler(new MWShapedRecipeHandler());
        API.registerRecipeHandler(new MWShapelessRecipeHandler());
        
        API.registerRecipeHandler(new PurifierRecipeHandler());
        API.registerRecipeHandler(new HTOvenRecipeHandler());
        API.registerRecipeHandler(new HTSmelterRecipeHandler());
        
        //Usage Handlers
        API.registerUsageHandler(new CauldronRecipeHandler());
        
        API.registerUsageHandler(new MWShapedRecipeHandler());
        API.registerUsageHandler(new MWShapelessRecipeHandler());
        
        API.registerUsageHandler(new PurifierRecipeHandler());
        API.registerUsageHandler(new HTOvenRecipeHandler());
        API.registerUsageHandler(new HTSmelterRecipeHandler());
        
        hideItemsInNEI();
        
	}
	
	private void hideItemsInNEI(){
		MFMod.CommonProxy.hideItemInNEI(new ItemStack(MFBlocks.HTOvenActive));
		MFMod.CommonProxy.hideItemInNEI(new ItemStack(MFBlocks.HTSmelterActive));
		MFMod.CommonProxy.hideItemInNEI(new ItemStack(MFBlocks.PurifierActive));
		MFMod.CommonProxy.hideItemInNEI(new ItemStack(MFBlocks.LampActive));
		MFMod.CommonProxy.hideItemInNEI(new ItemStack(MFBlocks.LampOff));
	}
}
