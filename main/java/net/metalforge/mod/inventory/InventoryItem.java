package net.metalforge.mod.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryItem implements IInventory{

    public NBTTagCompound nbt;
    public String name;
    public ItemStack itemstack;
    public ItemStack[] slots;

    public InventoryItem(ItemStack itemstack, int slotnum){
        slots = new ItemStack[slotnum];
        name = itemstack.getUnlocalizedName();
        if(!itemstack.hasTagCompound()){
            itemstack.setTagCompound(new NBTTagCompound());
        }
        nbt = itemstack.getTagCompound();
        this.itemstack = itemstack;
    }

    @Override
    public void closeInventory(){
        this.writeToNBT(nbt);
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        if(slots[slot] != null){
            ItemStack itemstack;
            if(slots[slot].stackSize <= amount){
                itemstack = slots[slot];
                slots[slot] = null;
                markDirty();
                return itemstack;
            }else{
                itemstack = slots[slot].splitStack(amount);
                if(slots[slot].stackSize == 0) slots[slot] = null;
                markDirty();
                return itemstack;
            }
        }
        else return null;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty() {
        this.writeToNBT(nbt);
        this.setNBT(itemstack);
    }

    @Override
    public String getInventoryName()
    {
        return "container_" + name;
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }
    
    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return slot >= 0 && slot < this.slots.length ? this.slots[slot] : null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if(slots[slot] != null){
            ItemStack itemstack = slots[slot];
            slots[slot] = null;
            return itemstack;
        }else return null;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return true;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory()
    {
        this.readFromNBT(nbt);
    }

    public void readFromNBT(NBTTagCompound NBTTagCompound)
    {
        slots = new ItemStack[getSizeInventory()];
        NBTTagList inventory = NBTTagCompound.getTagList("Items", 10);

        for(int i = 0; i < inventory.tagCount(); ++i)
        {
            NBTTagCompound Slots = inventory.getCompoundTagAt(i);
            byte slot = Slots.getByte("Slot");
            if((slot >= 0) && (slot < slots.length))
            {
            	slots[slot] = ItemStack.loadItemStackFromNBT(Slots);
            }
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
    	slots[slot] = stack;
        if((stack != null) && (stack.stackSize > getInventoryStackLimit())){
            stack.stackSize = getInventoryStackLimit();
        }
        this.markDirty();
    }

    public void setNBT(ItemStack item)
    {
        item.setTagCompound(nbt);
    }

    public void writeToNBT(NBTTagCompound NBTTagCompound)
    {
        NBTTagList inventory = new NBTTagList();
        for(int slot = 0; slot < slots.length; ++slot){
            if(slots[slot] != null){
                NBTTagCompound Slots = new NBTTagCompound();
                Slots.setByte("Slot", (byte)slot);
                slots[slot].writeToNBT(Slots);
                inventory.appendTag(Slots);
            }
        }
        NBTTagCompound.setTag("Items", inventory);
    }
}