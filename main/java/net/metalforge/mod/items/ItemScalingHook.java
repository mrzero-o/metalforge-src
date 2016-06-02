package net.metalforge.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemScalingHook extends ItemMF{
	
	public float power;
	
	public ItemScalingHook(float power, int durability){
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
		this.power = power;
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(side != 1){
			Vec3 vec = player.getLookVec();
			player.motionX += vec.xCoord * this.power;
			player.motionY += vec.yCoord * this.power;
			player.motionZ += vec.zCoord * this.power;
			player.fallDistance = 0.0F;
			itemstack.damageItem(1, player);
		}
        return true;
    }
}
