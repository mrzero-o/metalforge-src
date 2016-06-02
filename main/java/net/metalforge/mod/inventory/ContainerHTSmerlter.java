package net.metalforge.mod.inventory;

import net.metalforge.mod.blocks.BlockHTSmelter;
import net.metalforge.mod.tileentity.TileEntitySmelter;
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

public class ContainerHTSmerlter extends Container{

	private TileEntitySmelter smelter;

	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	public int tier;

	public ContainerHTSmerlter(InventoryPlayer inventory, TileEntitySmelter tileentity, int tier) {
		this.smelter = tileentity;
		this.tier = tier;

		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters (ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.smelter.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.smelter.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.smelter.currentItemBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if(this.lastCookTime != this.smelter.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.smelter.cookTime);
			}

			if(this.lastBurnTime != this.smelter.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.smelter.burnTime);
			}

			if(this.lastCurrentItemBurnTime != this.smelter.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.smelter.currentItemBurnTime);
			}
		}

		this.lastCookTime = this.smelter.cookTime;
		this.lastBurnTime = this.smelter.burnTime;
		this.lastCurrentItemBurnTime = this.smelter.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0) {
            this.smelter.cookTime = par2;
        }

        if (par1 == 1) {
            this.smelter.burnTime = par2;
        }

        if (par1 == 2) {
            this.smelter.currentItemBurnTime = par2;
        }
    }

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }else if (TileEntitySmelter.isItemFuel(itemstack1, tier, smelter.speed())) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (par2 >= 3 && par2 < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
	
	public boolean canInteractWith(EntityPlayer player) {
		if(!(player.worldObj.getBlock(smelter.xCoord, smelter.yCoord, smelter.zCoord) instanceof BlockHTSmelter)) {
			return false;
		}else{
			return player.getDistanceSq((double)smelter.xCoord + 0.5D, (double)smelter.yCoord + 0.5D, (double)smelter.zCoord + 0.5D) <= 64.0D;
		}
	}

}