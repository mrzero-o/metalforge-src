package net.metalforge.mod.tileentity;

import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCarbonDiablo extends TileEntity {
	
	public int fuel;
	public final int maxFuel = 5000;
	
	public void updateEntity(){
		if(fuel > maxFuel) fuel = maxFuel;
	}
	
	public void explode(){
		if(worldObj.isRemote){
			return;
		}
		if(fuel > 0){
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
			worldObj.setTileEntity(xCoord, yCoord, zCoord, null);
			worldObj.newExplosion((Entity)null, xCoord + 0.5F, yCoord + 0.5F, zCoord + 0.5F, (fuel / 100) * MFConfiguration.carbonDiabloPower, true, true);
		}
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.fuel = ((int)nbt.getShort("Charge"));
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("Charge", (short)this.fuel);
	}
}
