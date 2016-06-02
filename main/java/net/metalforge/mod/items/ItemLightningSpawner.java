package net.metalforge.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.metalforge.mod.MFMod;
import net.metalforge.mod.random.Util;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemLightningSpawner extends ItemMF implements IItemCP{
	
	@SideOnly(Side.CLIENT)
	private IIcon chargedIcon;
	
	public ItemLightningSpawner(){
		super();
		this.setMaxDamage(5000);
		this.setMaxStackSize(1);
	}
	
	public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(world.isRaining() || world.isThundering()){
			if(!player.isSneaking()){
				if(itemstack.getItemDamage() == 0){
					world.spawnEntityInWorld(new EntityLightningBolt(world, x + 0.5F, y + 0.5F, z + 0.5F));
					int drain = world.isThundering() ? 2500 : 5000;
					itemstack.damageItem(drain, player);
				}
			}
		}return false;
    }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	return Util.eatCoal(player);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		super.registerIcons(icon);
	   	this.chargedIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5) + "Charged");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		return damage == 0 ? this.chargedIcon : this.itemIcon;
	}
}
