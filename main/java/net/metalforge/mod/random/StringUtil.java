package net.metalforge.mod.random;

import net.minecraft.util.StatCollector;

public class StringUtil {
	
	private static String container = "metalforge.container.";
	
	public static String getPurifierGuiName(){
		return format("purifier");
	}
	
	public static String getMetalworkStationGuiName(){
		return format("metalwork");
	}
	
	public static String getOvenGuiName(){
		return format("oven");
	}
	
	public static String getSmelterGuiName(){
		return format("smelter");
	}

	public static String getCauldronGuiName(){
		return format("cauldron");
	}

	private static String format(String key, Object... params){
		return StatCollector.translateToLocalFormatted(container + key, params);
	}
}
