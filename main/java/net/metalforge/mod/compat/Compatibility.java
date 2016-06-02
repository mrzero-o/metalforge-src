package net.metalforge.mod.compat;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.compat.nei.NEICompatibility;
import net.metalforge.mod.items.MFItems;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.relauncher.Side;

public class Compatibility {
	
	private static String NEI = "NotEnoughItems";
	private static String MT = "ModTweaker";
	
	//public static Item hotTin;
	//public static Item hotOsmium;
	
	public static void loadInit(FMLInitializationEvent event){
		//NEI
		if(Loader.isModLoaded(NEI)) printIsLoaded(NEI);
	}
	
	public static void loadPostInit(FMLPostInitializationEvent postEvent){
		//NEI
		if(postEvent.getSide() == Side.CLIENT && Loader.isModLoaded(NEI)){
			new NEICompatibility().loadConfig();
		}
	}
	
	public static void printIsLoaded(String mod){
		FMLLog.log(MFMod.MODID, Level.INFO, "Loading" + MFMod.NAME + "-" + mod + " compatability");
	}
	
	public static Item registerItem(Item item){
		return MFItems.register(item);
	}
}
