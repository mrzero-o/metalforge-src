package net.metalforge.mod.minetweaker;

import minetweaker.MineTweakerAPI;

public class MetalTweaker {
	
	public static void initTweaks(){
		// See the purifier class to see descriptions for what is happening
		
		//Just registry things to make things work
		MineTweakerAPI.registerClass(Purifier.class);
		MineTweakerAPI.registerClass(Cauldron.class);
		MineTweakerAPI.registerClass(Oven.class);
		MineTweakerAPI.registerClass(MetalWorkStation.class);
	}
	
}
