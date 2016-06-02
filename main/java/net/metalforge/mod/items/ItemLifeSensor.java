package net.metalforge.mod.items;

import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLifeSensor extends ItemMF{
	
	 @SideOnly(Side.CLIENT)
	 private IIcon[] icons;
	
	 public ItemLifeSensor(){
		super();
		this.setMaxStackSize(1);
		this.setFull3D();
	 }
		
   	 public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase livingbase)
	 {
   		 if(!player.worldObj.isRemote){
   			 if(livingbase instanceof EntityPlayerMP){
   				 EntityPlayerMP player2 = (EntityPlayerMP)livingbase;
   				 String playername = player2.getDisplayName();
   				 player.addChatMessage(new ChatComponentText(MFMod.SIGNATURE + (EnumChatFormatting.RED + playername)
   				 + " has " + (int)livingbase.getHealth() + "/" + (int)livingbase.getMaxHealth() + " healthpoints"));		   		 
   			 }
   			 player.addChatMessage(new ChatComponentText(MFMod.SIGNATURE + livingbase.getClass().getSimpleName().substring(6)
   			 + "'s Healthpoints: " + (int)livingbase.getHealth() + "/" + (int)livingbase.getMaxHealth()));
   		 }
   		 
 		 if(livingbase.getHealth() != livingbase.getMaxHealth()){
		   	  int i = -((int)(livingbase.getHealth() - livingbase.getMaxHealth()));
		   	  itemstack.setItemDamage(i);
   		 }
	     return true;
	}
   	 
   	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
   		if(!world.isRemote) player.addChatMessage(new ChatComponentText(MFMod.SIGNATURE + "Your healthpoints: " 
   		+ (int)player.getHealth() + "/" + (int)player.getMaxHealth()));		  
        return itemstack;
    }
}
