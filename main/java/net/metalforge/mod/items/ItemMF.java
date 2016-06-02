package net.metalforge.mod.items;

import java.util.List;

import net.metalforge.mod.MFMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMF extends Item{
	
	private EnumRarity rarity = EnumRarity.common;
	
	public ItemMF(){
		super();
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float f1, float f2, float f3)
    {
        return false;
    }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        return itemstack;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return this.rarity;
    }
	
	public Item setRarity(EnumRarity rarity)
    {
		this.rarity = rarity;
        return this;
    }
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean bool) {}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List datalist, boolean bool){
		if(itemstack.getItem() instanceof IItemCP){
			IItemCP item = (IItemCP)itemstack.getItem();
			GameSettings settings = Minecraft.getMinecraft().gameSettings;
		}else super.addInformation(itemstack, player, datalist, bool);
    }
}
