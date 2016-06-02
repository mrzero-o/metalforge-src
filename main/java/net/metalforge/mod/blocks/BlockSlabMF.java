package net.metalforge.mod.blocks;

import java.util.Random;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlabMF extends BlockSlab 
{
	private Block block;
	
    public BlockSlabMF(boolean isDouble, Block block, float hardness)
    {
        super(isDouble, block.getMaterial());
        this.block = block;
        this.setHardness(hardness);
        this.setCreativeTab(isDouble ? null : MFMod.metalforgeTab);
    }
    
    public String func_150002_b(int p_150002_1_)
    {
    	return super.getUnlocalizedName();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
    	this.blockIcon = icon.registerIcon(this.block.getBlockTextureFromSide(0).getIconName());
    }
}