package net.metalforge.mod.tileentity;

import net.metalforge.mod.MFMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;

public class TileEntityWorldAnchor extends TileEntity {
	
	private Ticket chunkTicket;
    
    public void loadChunks(){
    	if(chunkTicket == null){
    		chunkTicket = ForgeChunkManager.requestTicket(MFMod.INSTANCE, worldObj, Type.NORMAL);
    	}
    	chunkTicket.getModData().setInteger("blockX", xCoord);
    	chunkTicket.getModData().setInteger("blockY", yCoord);
    	chunkTicket.getModData().setInteger("blockZ", zCoord);
    	
    	ForgeChunkManager.forceChunk(chunkTicket, new ChunkCoordIntPair(xCoord >> 4,  zCoord >> 4));
    }
    
    public void unloadChunks(){
    	ForgeChunkManager.unforceChunk(chunkTicket, new ChunkCoordIntPair(xCoord >> 4, zCoord >> 4));
    }
    
    public void loadTicket(Ticket ticket){
    	if(chunkTicket == null){
    		chunkTicket = ticket;
    	}
    	ChunkCoordIntPair loadChunk = new ChunkCoordIntPair(xCoord >> 4, zCoord >> 4);
    	ForgeChunkManager.forceChunk(ticket, loadChunk);
    }
    
    public void updateEntity() {
    	loadChunks();
    }
}
