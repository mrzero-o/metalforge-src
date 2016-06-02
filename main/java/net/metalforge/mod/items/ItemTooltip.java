package net.metalforge.mod.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTooltip extends ItemMF{
	
	public String tooltip;
	
	public ItemTooltip(String tooltip){
		super();
		this.tooltip = tooltip;
	}

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List datalist, boolean bool){
    	datalist.add(this.tooltip);
    }
}
