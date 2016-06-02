package net.metalforge.mod.items;

import java.util.List;

import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMetaBase extends ItemMF
{
    public static final String[] subItems = new String[] {"Steel", "BBronze", "Xyrenium", "ElecBrass", "Toxicrite", "Solarsteel"};
    
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public ItemMetaBase()
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return this.iconArray[meta];
    }
    
    public String getUnlocalizedName(ItemStack p_77667_1_)
    {
        int i = MathHelper.clamp_int(p_77667_1_.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + subItems[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs p_150895_2_, List list)
    {
        for (int i = 0; i < subItems.length; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
        this.iconArray = new IIcon[subItems.length];

        for (int i = 0; i < subItems.length; ++i)
        {
            this.iconArray[i] = icon.registerIcon(MFMod.MODID + this.getUnlocalizedName().substring(5) + subItems[i]);
        }
    }
}