package net.metalforge.mod.tileentity;

import java.util.List;

import net.metalforge.mod.blocks.MFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;

import com.google.common.collect.Lists;

public class TileEntityWorldAnchorCLCB implements ForgeChunkManager.OrderedLoadingCallback{

	@Override
	public void ticketsLoaded(List<Ticket> tickets, World world) {
		for(Ticket ticket: tickets){
			int blockX = ticket.getModData().getInteger("blockX");
			int blockY = ticket.getModData().getInteger("blockY");
			int blockZ = ticket.getModData().getInteger("blockZ");
			TileEntityWorldAnchor tileentity = (TileEntityWorldAnchor)world.getTileEntity(blockX, blockY, blockZ);
			tileentity.loadTicket(ticket);
		}
	}

	@Override
	public List<Ticket> ticketsLoaded(List<Ticket> tickets, World world, int maxTicketCount) {
		List<Ticket> validTickets = Lists.newArrayList();
		for(Ticket ticket: tickets){
			int blockX = ticket.getModData().getInteger("blockX");
			int blockY = ticket.getModData().getInteger("blockY");
			int blockZ = ticket.getModData().getInteger("blockZ");
			Block block = world.getBlock(blockX, blockY, blockZ);
			if(block == MFBlocks.WorldAnchor){
				validTickets.add(ticket);
			}
		}
		return validTickets;
	}
	
}
