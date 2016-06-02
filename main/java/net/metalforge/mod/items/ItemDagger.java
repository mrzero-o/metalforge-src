package net.metalforge.mod.items;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemDagger extends ItemSword{
	
	private float damageVsEntity;

	public ItemDagger(ToolMaterial mat) {
		super(mat);
		this.setMaxDamage(mat.getMaxUses());
		this.damageVsEntity = mat.getDamageVsEntity() - 1.0F;
		this.setFull3D();
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase attacked, EntityLivingBase attacking)
	{
		attacked.hurtResistantTime = 8;
		itemstack.damageItem(1, attacking);
	    return false;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		return itemstack;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
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
