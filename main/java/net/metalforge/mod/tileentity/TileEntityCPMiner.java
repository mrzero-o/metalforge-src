package net.metalforge.mod.tileentity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCPMiner extends TileEntity {
	
	public int fuel;
	public int cooldown;
	private int maxCooldown = 15;
	
	public int fortune;
	
	@Override
	public void updateEntity(){
		
		if(fuel > 1000) fuel = 1000;
		
		if(cooldown > 0){
			--cooldown;
			return;
		}
		
		if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
			for(int yLevel = yCoord - 1; yLevel > 0; --yLevel){
				Block block = worldObj.getBlock(xCoord, yLevel, zCoord);
				if(attemptMining(xCoord, yLevel, zCoord)){
					fuel -= 15;
					cooldown += maxCooldown;
					continue;
				}
			}
		}
	}
	
	private boolean attemptMining(int x, int y, int z){
		Random rand = worldObj.rand;
		int meta = worldObj.getBlockMetadata(x, y, z);
		Block block = worldObj.getBlock(x, y, z);
		ItemStack drop = new ItemStack(block.getItemDropped(meta, rand, fortune), block.quantityDropped(rand), block.damageDropped(meta));
		if(!canMine(x, y, z)) return false;
		else{
			
			worldObj.setBlockToAir(x, y, z);
	        float f = 0.7F;
	        double a = rand.nextFloat() * f + (1.0F - f) * 0.5D;
	        double b = rand.nextFloat() * f + (1.0F - f) * 0.5D;
	        double c = rand.nextFloat() * f + (1.0F - f) * 0.5D;
	        EntityItem entityitem = new EntityItem(worldObj, xCoord + a, yCoord + 1 + b, zCoord + c, drop);
	        entityitem.delayBeforeCanPickup = 10;
	        if(!worldObj.isRemote) worldObj.spawnEntityInWorld(entityitem);
		}
		return false;
	}
	
	private boolean canMine(int x, int y, int z){
		Block block = worldObj.getBlock(x, y, z);
		if(block.isCollidable() || block.getBlockHardness(worldObj, x, y, z) >= 0.0F || fuel >= 15){
			return false;
		}
		return true;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.fuel = ((int)nbt.getShort("CPFuel"));
		this.cooldown = ((int)nbt.getShort("Cooldown"));
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("CPFuel", (short)this.fuel);
		nbt.setShort("Cooldown", (short)this.cooldown);
	}
}
