package net.metalforge.mod.blocks;

import java.util.List;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBeryls extends BlockBreakable{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	final static String[] subBlocks = new String[]{"morganite", "heliodor", "aquamarine", "morganiteChiseled", "heliodorChiseled", "aquamarineChiseled"};
	
	public BlockBeryls(){
		super("glass", Material.glass, false);
		this.setHardness(2.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(4.0F);
		this.setCreativeTab(MFMod.metalforgeTab);
		this.setStepSound(soundTypeGlass);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		texture = new IIcon[subBlocks.length];
		
		for(int i = 0; i < subBlocks.length; i++){
			texture[i] = icon.registerIcon(MFMod.MODID + ":" + subBlocks[i] + "Beryl");
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
	
	@SideOnly(Side.CLIENT)
    public static int func_149997_b(int p_149997_0_)
    {
        return ~p_149997_0_ & 15;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
}
