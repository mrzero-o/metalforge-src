package net.metalforge.mod.inventory;

import net.metalforge.mod.items.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBackpack extends Container{
    
	private IInventory backpack;

    public ContainerBackpack(InventoryPlayer inv, ItemStack itemstack) {
    	int tier = ((ItemBackpack)itemstack.getItem()).tier;
    	backpack = new InventoryItem(itemstack, tier);
        addSlots(this, backpack, 0, 3, 5, 44, 19);
        addSlots(this, inv, 9, 3, 9, 8, 84);

        for (int row = 0; row < 9; ++row){
            if(row == inv.currentItem){
                this.addSlotToContainer((new SlotSpecial(inv, row, 8 + (row * 18), 142).setStatic()));
            }else this.addSlotToContainer(new Slot(inv, row, 8 + (row * 18), 142));
        }backpack.openInventory();
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return !player.isDead;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
    	backpack.closeInventory();
        ((InventoryItem)backpack).setNBT(player.getCurrentEquippedItem());
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p, int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot) inventorySlots.get(i);
        if((slot != null) && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i < backpack.getSizeInventory()){
                if(!mergeItemStack(itemstack1, backpack.getSizeInventory(), inventorySlots.size(), true)) return null;
            }else if(!mergeItemStack(itemstack1, 0, backpack.getSizeInventory(), false)) return null;
            
            if(itemstack1.stackSize == 0) slot.putStack((ItemStack)null);
            else slot.onSlotChanged();
        }return itemstack;
    }
    
    public void addSlots(Container container, IInventory inv, int id, int rows, int collomMax, int posX, int posY)
    {
        for(int row = 0; row < rows; ++row){
            for(int collom = 0; collom < collomMax; ++collom){
                this.addSlotToContainer(new Slot(inv, collom + (row * collomMax) + id, posX + (collom * 18), posY + (row * 18)));
            }
        }
    }
}