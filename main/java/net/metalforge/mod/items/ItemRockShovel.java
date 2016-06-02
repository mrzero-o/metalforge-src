package net.metalforge.mod.items;

import java.util.List;
import java.util.Set;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.MFMod;
import net.metalforge.mod.random.Util;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRockShovel extends ItemPickaxeMF implements IItemCP{
	
    @SideOnly(Side.CLIENT)
	private IIcon activeIcon;
	public int tier;
	public float efficiencyOnWrongMaterial = efficiencyOnProperMaterial / 8;
	
	public ItemRockShovel(int tier){
		super(MFMaterials.TMBBronze);
		this.tier = tier;
		this.efficiencyOnProperMaterial = tier == 1 ? 10.0F : 16.5F;
		this.setMaxDamage(tier == 1 ? 1600 : 3000);
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase attacked, EntityLivingBase attacking)
    {
        return true;
    }
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemstack)
	{
		return this.tier == 2 ? true : this.toolMaterial.getHarvestLevel() >= block.getHarvestLevel(0);
	}
	
	@Override
    public float getDigSpeed(ItemStack itemstack, Block block, int meta)
    {
		if(block.getHarvestTool(meta) != "axe"){
			if(tier == 1 && itemstack.getItemDamage() < 1592){
				return efficiencyOnProperMaterial;
			}else if(tier == 2 && itemstack.getItemDamage() < 2992){
				return efficiencyOnProperMaterial;
			}return efficiencyOnWrongMaterial;
		}return efficiencyOnWrongMaterial;
    }
	
    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {
    	Util.consumeCPFuel(living, itemstack, 8);
    	return true;
    }
    
    public boolean showDurabilityBar(ItemStack stack)
    {
        return true;
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	return Util.eatCoal(player);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List datalist, boolean bool) {
    	datalist.add(this.tier == 2 ? "Advanced" : "Basic");
    }
    
    @SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
    	this.activeIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5) + "Active");
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public IIcon getIcon(ItemStack itemstack, int pass)
    { 	
		if(tier == 1 && itemstack.getItemDamage() < 1592){
			return activeIcon;
		}else if(tier == 2 && itemstack.getItemDamage() < 2992){
			return activeIcon;
		}return itemIcon;
    }
}
