package net.metalforge.mod.crafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class InventoryMWR extends InventoryCraftResult
{
    public int getSizeInventory()
    {
        return 1;
    }

    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return false;
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return false;
    }
    
    private class SlotUntakable extends Slot{
    	
    	public SlotUntakable(IInventory inv, int slotIndex, int posX, int posY) {
    		super(inv, slotIndex, posX, posY);
    	}

		public boolean canTakeStack(EntityPlayer p_82869_1_)
        {
            return false;
        }
    }
}