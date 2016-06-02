package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLifeTakerScythe extends ItemSwordMF{
	
	public ItemLifeTakerScythe(){
		super(null);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase attacked, EntityLivingBase attacking)
    {
        itemstack.damageItem(1, attacking);
        if(attacking.getHealth() < attacked.getMaxHealth()){
        	if(attacked.prevHealth > attacked.getHealth()){
        		float heal = (attacked.prevHealth - attacked.getHealth()) / 3;
        		attacking.heal(heal);
        		attacking.worldObj.spawnParticle("explode", attacking.posX, attacking.posY, attacking.posZ, 0.0F, 0.0F, 0.0F);
        	}
        }
        return true;
    }
	
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.none;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }
}
