package net.metalforge.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGhostItem extends Item{
	
	private Item realItem;
	
	public ItemGhostItem(Item realItem){
		super();
		this.realItem = realItem;
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		return this.realItem.getIcon(stack, pass);
	}
	
	public Item getRealItem() {
		return realItem;
	}

}
