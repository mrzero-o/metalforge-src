package net.metalforge.mod.inventory;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.crafting.InventoryMWR;
import net.metalforge.mod.crafting.MetalworkingManager;
import net.metalforge.mod.tileentity.TileEntityMetalworkStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerMetalwork extends Container {

	private TileEntityMetalworkStation tileentity;
	private boolean blX;
	
	public InventoryCrafting craftMatrix;
	public InventoryMWR craftResult;
	private World worldObj;

	public ContainerMetalwork(InventoryPlayer invPlayer, TileEntityMetalworkStation tileentity) {
		this.tileentity = tileentity;
		this.craftMatrix = new InventoryCrafting(this, 3, 3);
		this.craftResult = new InventoryMWR();
		this.worldObj = tileentity.getWorldObj();
		
		this.blX = false;
		for (int i = 0; i < 9; ++i) {
			this.craftMatrix.setInventorySlotContents(i, this.tileentity.getStackInSlot(i));
        }
        this.blX = true;
		
        this.addSlots(invPlayer);

		onCraftMatrixChanged(craftMatrix);
	}
	
	private void addSlots(InventoryPlayer invPlayer){
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 124, 35){
			@Override
			public boolean canTakeStack(EntityPlayer p_82869_1_) {
				return false;
			}
		});

		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				this.addSlotToContainer(new Slot(this.craftMatrix, k + i * 3, 30 + k * 18, 17 + i * 18));
			}
		}

		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}

	public void onCraftMatrixChanged(IInventory iinventory){
		//Just in case you are wondering... you used the wrong manager and it was taking crafting recipies from vanilla minecraft
		//if(MetalworkingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj) != null){    -- We need to update it to null if it isn't a recipe
			craftResult.setInventorySlotContents(0, MetalworkingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
			//updateTile(); //If you are going to save it in the tile then you need to update it when it is crafted -- i don't know a direct fix
		//}
		
		if(this.blX) this.updateTile();
	}
	
    private void updateTile() {
        for (int i = 0; i < 9; ++i) {
        	this.tileentity.setInventorySlotContents(i, this.craftMatrix.getStackInSlot(i));
        }
        this.tileentity.container = this;
    }
    
    @Override
    public void onContainerClosed(EntityPlayer player) {
		updateTile();
		super.onContainerClosed(player);
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(worldObj.getBlock(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) != MFBlocks.MetalworkStation) {
			return false;
		}else{
			return player.getDistanceSq((double)tileentity.xCoord + 0.5D, (double)tileentity.yCoord + 0.5D, (double)tileentity.zCoord + 0.5D) <= 64.0D;
		}
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slotnum)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotnum);
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotnum == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }else if (slotnum >= 10 && slotnum < 37){
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) return null;
            }else if (slotnum >= 37 && slotnum < 46){
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
			updateTile();
        }
        return itemstack;
    }

}