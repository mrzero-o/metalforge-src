package net.metalforge.mod.items;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.random.MFDamageSources;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemRedButton extends ItemMF{
	
	public ItemRedButton(){
		super();
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		ItemStack chestplate = player.inventory.armorItemInSlot(2);
		if(!world.isRemote && chestplate != null && chestplate.getItem() instanceof ItemArmorMF.TNTVest){
			float kill = player.getHealth() * 99.9F;
			float power = ((ItemArmorMF.TNTVest)chestplate.getItem()).power;
			if(power > 0){
				--itemstack.stackSize;
				chestplate = null;
				player.attackEntityFrom(MFDamageSources.kamikaze, kill);
				if(!world.isRemote) world.createExplosion(player, player.posX, player.posY, player.posZ, power, player.capabilities.allowEdit);
			}world.updateEntities();
		}else if(chestplate == null || (chestplate != null && !(chestplate.getItem() instanceof ItemArmorMF.TNTVest))){
			if(!player.worldObj.isRemote) player.addChatMessage(new ChatComponentText(MFMod.SIGNATURE + "You don't have a TNT Vest equipped"));
		}
		return itemstack;
    }
}
