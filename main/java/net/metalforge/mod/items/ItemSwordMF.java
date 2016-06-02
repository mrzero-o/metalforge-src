package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSwordMF extends ItemSword{
	
	private ToolMaterial mat;
	
	public ItemSwordMF(ToolMaterial mat) {
		super(mat);
		this.mat = mat;
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return mat == MFMaterials.TMDragoonyte ? EnumRarity.epic : super.getRarity(itemstack);
    }
	
}
