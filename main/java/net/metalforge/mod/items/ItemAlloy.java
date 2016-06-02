package net.metalforge.mod.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAlloy extends ItemMF{
	
	public int tierNeeded;
	public Item resultItem;
	
	public ItemAlloy(int tierNeeded, Item resultItem){
		super();
		this.tierNeeded = tierNeeded;
		this.resultItem = resultItem;
	}
	
	public int getEntityLifespan(ItemStack itemStack, World world)
    {
        return 200000;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List datalist, boolean bool){
		datalist.add("Tier " + this.tierNeeded + " alloy");
	}
}
