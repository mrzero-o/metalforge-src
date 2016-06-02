package net.metalforge.mod.items;

import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulWand extends ItemMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon iconNight, iconCurse, iconSoul;

	public ItemSoulWand(){
		this.setFull3D();
		this.setMaxDamage(3);
		this.setMaxStackSize(1);
	}
	
	public boolean showDurabilityBar(ItemStack stack)
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
		final String base = MFMod.MODID + ":" + this.getUnlocalizedName().substring(5);
        this.itemIcon = icon.registerIcon(base);
        this.iconNight = icon.registerIcon(base + "Night");
        this.iconCurse = icon.registerIcon(base + "Curse");
        this.iconSoul = icon.registerIcon(base + "Soul");
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    { 
		switch(damage){
		case 1: return iconNight;
		case 2: return iconCurse;
		case 3: return iconSoul;
		default: return this.itemIcon;
		}
    }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		if(!player.isSneaking()){
			if(itemstack.getItemDamage() == 3){
				itemstack.setItemDamage(0);
			}else itemstack.damageItem(1, player);
		}return itemstack;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.rare;
    }
}
