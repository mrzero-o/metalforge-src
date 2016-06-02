package net.metalforge.mod.inventory;

import net.metalforge.mod.blocks.BlockHTSmelter;
import net.metalforge.mod.tileentity.TileEntitySmelter;
import net.minecraft.block.BlockCauldron;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerCauldron extends Container{

	public ContainerCauldron(InventoryPlayer inventory) {

		this.addSlotToContainer(new Slot(null, 0, 44, 35));
		this.addSlotToContainer(new SlotFurnace(inventory.player, null, 2, 128, 35));

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		//rec1: 70,41-81,54; rec2: 184,0-195,14;

		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return false;
	}

}