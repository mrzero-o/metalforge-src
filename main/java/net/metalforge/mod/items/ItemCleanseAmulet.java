package net.metalforge.mod.items;

import java.util.Collection;

import net.metalforge.mod.random.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.world.World;

public class ItemCleanseAmulet extends ItemMF{
	
	private EnumAmuletType amuletType;

	public ItemCleanseAmulet(EnumAmuletType type){
		super();
		this.amuletType = type;
		this.setFull3D();
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		Collection effects = player.getActivePotionEffects();
		if(!effects.isEmpty()){
			//if(!removeOnlyBadEffects)
			if(this.amuletType == EnumAmuletType.WITHER && player.isPotionActive(Potion.wither.getId()) && Util.attemptManaConsumption(player, 20)){
				player.removePotionEffect(Potion.wither.getId());
			}else if(this.amuletType == EnumAmuletType.ALL) player.clearActivePotions();
		}
        return itemstack;
    }
	
	public enum EnumAmuletType{
		WITHER, ALL
	}
}
