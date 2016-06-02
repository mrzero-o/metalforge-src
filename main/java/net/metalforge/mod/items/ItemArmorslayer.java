package net.metalforge.mod.items;

import com.google.common.collect.Multimap;

import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorslayer extends ItemSword{
	
	public float damageVsEntity;

	public ItemArmorslayer() {
		super(ToolMaterial.STONE);
		this.damageVsEntity = ToolMaterial.STONE.getDamageVsEntity() + 1;
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity entity)
    {
		if(entity instanceof EntityLivingBase){
			EntityLivingBase livingbase = (EntityLivingBase)entity;
			itemstack.damageItem(1, player);
			if(livingbase.getTotalArmorValue() > 0){
				livingbase.attackEntityFrom(DamageSource.causePlayerDamage(player).setDamageBypassesArmor(), damageVsEntity);
				return true;
			}else return false;
		}else return false;
    }
	
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        String key = SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName();
        multimap.removeAll(key);
        multimap.put(key, new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
}
