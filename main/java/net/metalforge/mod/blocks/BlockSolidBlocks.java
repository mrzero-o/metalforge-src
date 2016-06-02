package net.metalforge.mod.blocks;

import java.util.List;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSolidBlocks extends BlockMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	final static String[] subBlocks = new String[]{"copper", "tungsten", "xyrenium", "steel", "berylBronze", "dragoonyte"};
	
	public BlockSolidBlocks(){
		super(Material.iron, 2.75F);
		this.setResistance(12.5F);
		this.setCreativeTab(MFMod.metalforgeTab);
		this.setStepSound(soundTypeMetal);
	}
	
	public boolean isBeaconBase(IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
    {
		return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		texture = new IIcon[subBlocks.length];
		
		for(int i = 0; i < subBlocks.length; i++){
			texture[i] = icon.registerIcon(MFMod.MODID + ":" + subBlocks[i] + "Block");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs cTabs , List list){
		for(int i = 0; i < subBlocks.length; i++){
			list.add(new ItemStack(item , 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return texture[meta];
	}
	
	public int damageDropped(int meta){
		return meta;
	}
}
