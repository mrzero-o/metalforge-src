package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorDragoon extends ItemArmorMF{

	public ItemArmorDragoon(int part) {
		super(MFMaterials.AMDragoonyte, part, "");
	}
	
	@Override
	public String getArmorTexture (ItemStack itemstack, Entity entity, int slot, String layer)
    {
		if(this.armorType == 2){
			return MFMod.MODID + ":textures/armor/dragoonarmor.png";
		}else if(this.armorType == 0){
			return MFMod.MODID + ":textures/models/dragoonhelmet.png";
		}else return MFMod.MODID + ":textures/models/dragoonbodyarmor.png";
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack itemstack, int armorSlot)
	{
		ModelBiped model = null;
		if(itemstack != null){
			if(itemstack.getItem() == MFItems.DragoonChestplate) model = MFMod.CommonProxy.getDragoonBodyArmorModel();
			if(itemstack.getItem() == MFItems.DragoonHelmet) model = MFMod.CommonProxy.getDragoonHelmetModel();
		}if(model != null){ 
			model.bipedHead.showModel = armorSlot == 0;
			model.bipedHeadwear.showModel = armorSlot == 0;
			model.bipedBody.showModel = armorSlot == 1 || armorSlot == 2; 
			model.bipedRightArm.showModel = armorSlot == 1; 
			model.bipedLeftArm.showModel = armorSlot == 1; 
			model.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3; 
			model.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3; 
			model.isSneak = living.isSneaking();
			model.isRiding = living.isRiding();
			model.isChild = living.isChild();
			model.heldItemRight = living.getEquipmentInSlot(0) != null ? 1 : 0; 
			if(living instanceof EntityPlayer) model.aimedBow =((EntityPlayer)living).getItemInUseDuration() > 2;
		}return model; 
	}
}
