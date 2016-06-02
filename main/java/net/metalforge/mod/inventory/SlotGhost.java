package net.metalforge.mod.inventory;

import net.metalforge.mod.items.ItemHot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SlotGhost extends SlotCrafting{

	public SlotGhost(EntityPlayer p_i1823_1_, IInventory p_i1823_2_, IInventory p_i1823_3_, int p_i1823_4_, int p_i1823_5_, int p_i1823_6_) {
		super(p_i1823_1_, p_i1823_2_, p_i1823_3_, p_i1823_4_, p_i1823_5_, p_i1823_6_);
	}
	
	@SideOnly(Side.CLIENT)
    public ResourceLocation getBackgroundIconTexture()
    {
		if(getStack() != null && getStack().getItem() instanceof ItemHot){
			
		}
        return super.getBackgroundIconTexture();
    }

}
