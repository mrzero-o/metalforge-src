package net.metalforge.mod.items;

import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodMF extends ItemFood{
	
	private boolean returnsBowl = false;

	public ItemFoodMF(int food, boolean isWFM) {
		this(food, 0.6F, isWFM);
	}
	
	public ItemFoodMF(int food, float saturation, boolean isWFM){
		super(food, saturation, isWFM);
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

    public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
        super.onEaten(itemstack, world, player);
        return this.returnsBowl ? new ItemStack(Items.bowl) : itemstack;
    }
	
	public Item setReturnsBowl(){
		this.setMaxStackSize(1);
		this.returnsBowl = true;
		return this;
	}
}
