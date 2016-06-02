package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightningBlade extends ItemSwordMF{

	public boolean isActivated;
	
	public ItemLightningBlade(boolean isActivated) {
		super(null);
		this.isActivated = isActivated;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		if(this.isActivated){
			Vec3 vec = player.getLookVec();
			if(player.isSneaking()) super.onItemRightClick(itemstack, world, player);
			else{
				player.motionX += vec.xCoord * 1.1;
				player.motionY += vec.yCoord * 1.1;
				player.motionZ += vec.zCoord * 1.1;
				player.fallDistance = 0.0F;
				player.swingItem();
				if(MFConfiguration.thunderEdgeDamagesOnLeap) itemstack.damageItem(1, player);
			}
		}else super.onItemRightClick(itemstack, world, player);
        return itemstack;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return this.isActivated ? EnumRarity.epic : EnumRarity.rare;
    }
}
