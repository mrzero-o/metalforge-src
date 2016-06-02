package net.metalforge.mod.tileentity;

import net.metalforge.mod.inventory.ContainerMetalwork;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMetalworkStation extends TileEntity implements IInventory {
	
    protected ItemStack[] slots = new ItemStack[10];
    public ContainerMetalwork container;

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        
        if(nbt.hasKey("Contents")) {
            NBTTagList nbttaglist = nbt.getTagList("Contents", 10);
            for(int i = 0; i < nbttaglist.tagCount(); ++i) {
                NBTTagCompound tag = nbttaglist.getCompoundTagAt(i);
                byte slot = tag.getByte("Slot");
                if (slot >= this.slots.length) continue;
                ItemStack stackLoaded = ItemStack.loadItemStackFromNBT((NBTTagCompound)tag);
                if(stackLoaded.stackSize > 0){
                	this.slots[slot] = stackLoaded;
                }else this.slots[slot] = null;
                if(stackLoaded != null){
                    System.out.println("Loaded slot " + slot + " with " + stackLoaded.stackSize + " items of " + stackLoaded.getItem().getUnlocalizedName());
                }
            }
        }
    }
    
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < this.slots.length; i++) {
			if(this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		
		nbt.setTag("Contents", list);
	}
	
    public int getSizeInventory() {
        return this.slots.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.slots[slot];
    }

    public ItemStack decrStackSize(int slot, int amt) {
        if (this.slots[slot] != null) {
            ItemStack newStack;
            if (this.slots[slot].stackSize <= amt) {
                newStack = this.slots[slot];
                this.slots[slot] = null;
            }else{
                newStack = this.slots[slot].splitStack(amt);
                if (this.slots[slot].stackSize == 0) {
                    this.slots[slot] = null;
                }
            }
            return newStack;
        }
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.slots[slot] != null) {
            ItemStack stack = this.slots[slot];
            this.slots[slot] = null;
            return stack;
        }
        return null;
    }

    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        this.slots[slot] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
        	itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return "container.metalworkstation";
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) < 64.0;
    }

    public void openInventory() {
    }

    public void closeInventory() {
    }

    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        if (slot == 9) {
            return false;
        }
        return true;
    }

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
}

