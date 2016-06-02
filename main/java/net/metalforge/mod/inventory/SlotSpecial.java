package net.metalforge.mod.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotSpecial extends Slot{
	
	private boolean isStatic;
	
	public SlotSpecial(IInventory inv, int slotIndex, int posX, int posY) {
		super(inv, slotIndex, posX, posY);
	}

	public Slot setStatic(){
		this.isStatic = true;
		return this;
	}
	
	@Override
    public boolean canTakeStack(EntityPlayer player){
        return !this.isStatic;
    }
}
