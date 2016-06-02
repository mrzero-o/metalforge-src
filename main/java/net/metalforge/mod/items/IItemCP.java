package net.metalforge.mod.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;

public interface IItemCP {
	
	public String hidden = (EnumChatFormatting.GRAY + "Press ") + (EnumChatFormatting.RED + "SHIFT") + (EnumChatFormatting.GRAY + " for more information");
	
	public String showing = "CP Items can be refueled by shift-rightclicking with any kind of coal in your inventory";

}
