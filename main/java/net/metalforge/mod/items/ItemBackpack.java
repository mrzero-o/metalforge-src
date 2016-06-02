package net.metalforge.mod.items;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.inventory.MFGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBackpack extends ItemMF{
	
	public int tier;

    public ItemBackpack(int tier) {
        super();
        this.setMaxStackSize(1);
        this.tier = tier;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        if(!world.isRemote && !player.isSneaking()){
        	player.openGui(MFMod.INSTANCE, MFGuiHandler.BACKPACK, world, 0, 0, 0);
        }return itemstack;
    }
}