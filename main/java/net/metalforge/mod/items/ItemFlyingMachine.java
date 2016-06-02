package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.metalforge.mod.models.ModelFlyingMachine;
import net.metalforge.mod.random.Util;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlyingMachine extends ItemArmorMF implements ISpecialArmor, IItemCP{
	
	public ItemFlyingMachine(){
		super(MFMaterials.AMUnused, 1, "");
		this.setMaxDamage(5000);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, 0, 0);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 3;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {}
	
	@Override
	public String getArmorTexture (ItemStack itemstack, Entity entity, int slot, String layer)
    {
		return MFMod.MODID + ":textures/models/flyingmachine.png";
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack itemStack, int armorSlot)
	{
		ModelFlyingMachine model = MFMod.CommonProxy.getFlyingMachineModel();
		
		if(model != null){
			model.bipedBody.showModel = true;
			model.bipedRightArm.showModel = true;
			model.bipedLeftArm.showModel = true;
			
			model.isSneak = living.isSneaking();
			model.isRiding = living.isRiding();
			model.isChild = living.isChild();
			model.heldItemRight = living.getEquipmentInSlot(0) != null ? 1 : 0;
			if(living instanceof EntityPlayer) model.aimedBow = ((EntityPlayer)living).getItemInUseDuration() > 2;
			return model;
		}return model;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		if(!player.isSneaking()) super.onItemRightClick(itemstack, world, player);
    	return Util.eatCoal(player);
    }
    
    public boolean showDurabilityBar(ItemStack stack)
    {
        return true;
    }
}