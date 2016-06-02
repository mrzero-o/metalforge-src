package net.metalforge.mod.tileentity;

import net.minecraft.block.BlockFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;


public class TileEntityHeatPipe extends TileEntity {
	
	public int burnTime;
	
	public void updateEntity()
    {
    	this.shareBurnTime(xCoord, yCoord - 1, zCoord);
    	this.shareBurnTime(xCoord, yCoord + 1, zCoord);
    	this.shareBurnTime(xCoord, yCoord, zCoord - 1);
    	this.shareBurnTime(xCoord, yCoord, zCoord + 1);
    	this.shareBurnTime(xCoord - 1, yCoord, zCoord);
    	this.shareBurnTime(xCoord + 1, yCoord, zCoord);
    }
	
	public void shareBurnTime(int x, int y, int z){
		if(worldObj.getTileEntity(x, y, z) != null){
    		TileEntity tileentity = worldObj.getTileEntity(x, y, z);
    		if(tileentity instanceof TileEntityBT){
    			TileEntityBT furnace = ((TileEntityBT)tileentity);
    			if(furnace.burnTime < 200 && hasHeat()){
    				++furnace.burnTime;
        			--this.burnTime;
    			}
    		}if(tileentity instanceof TileEntityFurnace){
    			TileEntityFurnace furnace = ((TileEntityFurnace)tileentity);
    			if(furnace.furnaceBurnTime < 200 && hasHeat()){
    				++furnace.furnaceBurnTime;
        			--this.burnTime;
    			}BlockFurnace.updateFurnaceBlockState(furnace.furnaceBurnTime > 0, worldObj, x, y, z);
    		}if(tileentity instanceof TileEntityHeatPipe){
    			TileEntityHeatPipe furnace = ((TileEntityHeatPipe)tileentity);
    			if(furnace.burnTime < this.burnTime && hasHeat() && furnace.burnTime < 200){
    				--this.burnTime;
    				++furnace.burnTime;
    			}
    		}
    	}
    }

	public boolean hasHeat(){
		return this.burnTime > 0;
	}
}
