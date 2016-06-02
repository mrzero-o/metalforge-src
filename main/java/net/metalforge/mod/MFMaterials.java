package net.metalforge.mod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MFMaterials {
	
	public static ToolMaterial TMSteel = EnumHelper.addToolMaterial("STEEL", 3, 472, 7.5F, 3.0F, 12);
	public static ToolMaterial TMBBronze = EnumHelper.addToolMaterial("BERYLLIUM", 4, 924, 8.75F, 4.0F, 16);
	public static ToolMaterial TMXyrenium = EnumHelper.addToolMaterial("XYRENIUM", 5, 1896, 10.0F, 5.0F, 19);
	public static ToolMaterial TMDragoonyte = EnumHelper.addToolMaterial("DRAGOONYTE", 7, 2896, 13.0F, 6.0F, 6);
	
	public static ArmorMaterial AMUnused = EnumHelper.addArmorMaterial("UNUSED", 0, new int[]{0, 0, 0, 0}, 0);
	public static ArmorMaterial AMSolarsteel = EnumHelper.addArmorMaterial("SOLARSTEEL", 21, new int[]{4, 6, 5, 4}, 24);
	public static ArmorMaterial AMDoomlord = EnumHelper.addArmorMaterial("DOOMLORD", 26, new int[]{3, 6, 5, 4}, 14);
	public static ArmorMaterial AMMutant = EnumHelper.addArmorMaterial("MUTANT", 14, new int[]{3, 5, 4, 3}, 14);

	public static ArmorMaterial AMSteel = EnumHelper.addArmorMaterial("STEEL", 21, new int[]{3, 6, 5, 3}, 12);
	public static ArmorMaterial AMBerylliumBronze = EnumHelper.addArmorMaterial("BERYLLIUM", 26, new int[]{3, 7, 6, 3}, 16);
	public static ArmorMaterial AMXyrenium = EnumHelper.addArmorMaterial("XYRENIUM", 31, new int[]{4, 8, 6, 4}, 19);
	public static ArmorMaterial AMDragoonyte = EnumHelper.addArmorMaterial("DRAGOONYTE", 41, new int[]{6, 9, 7, 6}, 8);
}
