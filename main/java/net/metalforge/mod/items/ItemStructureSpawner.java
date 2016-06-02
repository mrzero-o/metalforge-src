package net.metalforge.mod.items;

import java.util.List;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.worldgen.WorldGenBlacksmithsShack;
import net.metalforge.mod.worldgen.WorldGenBlackwoodTree;
import net.metalforge.mod.worldgen.WorldGenMagnetiteTemple;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;

public class ItemStructureSpawner extends ItemMF{
	
	private String structure0 = "Blackwood Tree", structure1 = "Blacksmith Shack", structure2 = "Magnetite Temple";
	
	private String getMode(int mode){
		switch(mode) {
			case 1: return structure1;
			case 2: return structure2;
			default: return structure0;
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking()){
			toggleMode(player, itemstack);
		}
		return itemstack;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float f1, float f2, float f3) {
		if(player.isSneaking()){
			toggleMode(player, itemstack);
		}else if(itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("MFStructureSpawnerMode")){
			int mode = itemstack.getTagCompound().getInteger("MFStructureSpawnerMode");
			if(getMode(mode) == structure0) new WorldGenBlackwoodTree(true, true).generate(world, world.rand, x, y + 1, z);
			if(getMode(mode) == structure1) new WorldGenBlacksmithsShack(true).generate(world, world.rand, x, y + 1, z);
			if(getMode(mode) == structure2) new WorldGenMagnetiteTemple(true).generate(world, world.rand, x, y + 1, z);
			return true; 
		}
		return false;
	}
	
	private void toggleMode(EntityPlayer player, ItemStack itemstack){
		if(!itemstack.hasTagCompound()){
			itemstack.setTagCompound(new NBTTagCompound());
		}
		if(!itemstack.getTagCompound().hasKey("MFStructureSpawnerMode")){
			itemstack.getTagCompound().setInteger("MFStructureSpawnerMode", 0);
		}
		
		int mode = itemstack.getTagCompound().getInteger("MFStructureSpawnerMode");
		if(mode < 2) ++mode;
		else mode = 0;
		itemstack.getTagCompound().setInteger("MFStructureSpawnerMode", mode);
		if(!player.worldObj.isRemote) player.addChatMessage(new ChatComponentText("Set to " + getMode(mode)));	
		
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List datalist, boolean bool) {
		datalist.add("Creative only");
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		NBTTagCompound nbt = itemstack.getTagCompound();
		itemstack.setTagCompound(nbt);
		return super.getContainerItem(itemstack);
	}

}
