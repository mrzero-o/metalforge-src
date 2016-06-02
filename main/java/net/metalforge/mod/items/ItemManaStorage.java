package net.metalforge.mod.items;

import net.minecraft.item.ItemStack;

public class ItemManaStorage extends ItemMF {
	
	public ItemManaStorage(int capacity){
		super();
		this.setMaxDamage(capacity);
	}
	
	public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}

}
