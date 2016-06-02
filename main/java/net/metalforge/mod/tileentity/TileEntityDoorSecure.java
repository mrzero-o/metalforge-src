package net.metalforge.mod.tileentity;

import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDoorSecure extends TileEntity{
	
	private String ownername = "None";
	
	public void readFromNBT(NBTTagCompound nbt)
    {
		super.readFromNBT(nbt);
		this.ownername = nbt.getString("OwnerName");
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
    	super.writeToNBT(nbt);
    	nbt.setString("OwnerName", ownername);
    }
	
	public boolean isOwner(EntityPlayer player){
		return player.getDisplayName() == this.ownername;
	}

	public TileEntity setOwner(EntityPlayer player){
		this.ownername = player.getDisplayName();
		return this;
	}
}
