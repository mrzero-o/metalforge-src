package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class ItemArmorMF extends ItemArmor{
	
	public String texture;
	public ArmorMaterial material;

	public ItemArmorMF(ArmorMaterial material, int part, String texture) {
		super(material, 4, part);
		this.setCreativeTab(MFMod.metalforgeTab);
		this.texture = texture;
		this.material = material;
	}
	
	@Override
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
    public String getArmorTexture (ItemStack itemstack, Entity entity, int slot, String layer)
    {
		String thingymajob = MFMod.MODID + ":textures/armor/" + this.texture;
		return thingymajob + (this.armorType == 2 ? "2" : "1") + ".png";
    }
	
	public boolean getIsRepairable(ItemStack armor, ItemStack material)
	{
		if(armor.getItem() instanceof ItemArmorMF){
			if(material.getItem() == this.getRepairMaterial()){
				return true;
			}
		}return false;
	}
	
	public Item getRepairMaterial(){
		if(this.material == MFMaterials.AMSteel) return MFItems.ingotSteel;
		if(this.material == MFMaterials.AMBerylliumBronze) return MFItems.ingotBerylBronze;
		if(this.material == MFMaterials.AMXyrenium) return MFItems.ingotXyrenium;
		return null;
	}
	
	public static class TNTVest extends ItemArmorMF{
		
		public float power;

		public TNTVest(String texture, float power) {
			super(MFMaterials.AMSteel, 1, texture);
			this.power = power;
		}

	}
}
