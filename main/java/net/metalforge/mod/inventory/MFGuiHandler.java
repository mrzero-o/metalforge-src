package net.metalforge.mod.inventory;

import net.metalforge.mod.blocks.BlockHTOven;
import net.metalforge.mod.blocks.BlockPurifier;
import net.metalforge.mod.blocks.BlockHTSmelter;
import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.inventory.gui.GuiBackpack;
import net.metalforge.mod.inventory.gui.GuiMetalwork;
import net.metalforge.mod.inventory.gui.GuiOven;
import net.metalforge.mod.inventory.gui.GuiPurifier;
import net.metalforge.mod.inventory.gui.GuiSmelter;
import net.metalforge.mod.tileentity.TileEntityMetalworkStation;
import net.metalforge.mod.tileentity.TileEntityOven;
import net.metalforge.mod.tileentity.TileEntityPurifier;
import net.metalforge.mod.tileentity.TileEntitySmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class MFGuiHandler implements IGuiHandler{

	public static int OVEN = 1;
	public static int SMELTER = 2;
	public static int PURIFIER = 3;
	public static int METALWORK = 4;
	public static int HEATPROVIDER = 5;
	public static int BACKPACK = 6;
	private IInventory inv1;
	private IInventory inv2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){	
		if(ID == OVEN){
			TileEntityOven tileEntityFurnace = (TileEntityOven)world.getTileEntity(x, y, z);
			return new ContainerHTOven(player.inventory, tileEntityFurnace, ((BlockHTOven)world.getBlock(x, y, z)).tier);
		}if(ID == SMELTER){
			TileEntitySmelter tileEntityFurnace = (TileEntitySmelter)world.getTileEntity(x, y, z);
			return new ContainerHTSmerlter(player.inventory, tileEntityFurnace, ((BlockHTSmelter)world.getBlock(x, y, z)).tier);
		}if(ID == PURIFIER){
			TileEntityPurifier tileEntityFurnace = (TileEntityPurifier)world.getTileEntity(x, y, z);
			return new ContainerPurifier(player.inventory, tileEntityFurnace, ((BlockPurifier)world.getBlock(x, y, z)).tier);
		}if(ID == METALWORK){
			TileEntityMetalworkStation tileEntityMWS = (TileEntityMetalworkStation)world.getTileEntity(x, y, z);
			return new ContainerMetalwork(player.inventory, tileEntityMWS);
		}if(ID == BACKPACK){
			ItemStack held = player.getCurrentEquippedItem();
            return new ContainerBackpack(player.inventory, held);
        }return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		if(ID == OVEN){
			TileEntityOven tileEntityFurnace = (TileEntityOven) world.getTileEntity(x, y, z);
			return new GuiOven(player.inventory, tileEntityFurnace, ((BlockHTOven)world.getBlock(x, y, z)).tier);
		}if(ID == SMELTER){
			TileEntitySmelter tileEntityFurnace = (TileEntitySmelter) world.getTileEntity(x, y, z);
			return new GuiSmelter(player.inventory, tileEntityFurnace, ((BlockHTSmelter)world.getBlock(x, y, z)).tier);
		}if(ID == PURIFIER){
			TileEntityPurifier tileEntityFurnace = (TileEntityPurifier) world.getTileEntity(x, y, z);
			return new GuiPurifier(player.inventory, tileEntityFurnace, ((BlockPurifier)world.getBlock(x, y, z)).tier);
		}if(ID == METALWORK){
			TileEntityMetalworkStation tileEntityMWS = (TileEntityMetalworkStation) world.getTileEntity(x, y, z);
            return new GuiMetalwork(player.inventory, tileEntityMWS);
		}if(ID == BACKPACK){
			ItemStack held = player.getCurrentEquippedItem();
            return new GuiBackpack(player.inventory, held);
        }return null;
	}
}
