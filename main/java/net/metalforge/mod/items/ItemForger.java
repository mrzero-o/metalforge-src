package net.metalforge.mod.items;

import java.util.List;

import net.metalforge.mod.MFMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemForger extends ItemMF{
	
	public int tier;
	
	public ItemForger(int durability, int tier) {
		super();
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
		this.tier = tier;
	}
	
	public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity entity)
    {
		System.out.println("Clicked " + entity.toString());
        return false;
    }
}
