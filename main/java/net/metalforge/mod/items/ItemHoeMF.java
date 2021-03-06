package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHoeMF extends ItemHoe{
	
	public ItemHoeMF(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return this.theToolMaterial == MFMaterials.TMDragoonyte ? EnumRarity.epic : super.getRarity(itemstack);
    }
}



