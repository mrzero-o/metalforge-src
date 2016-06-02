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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagnetite extends BlockMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
    public static final String[] subBlocks = new String[] {"stone", "brick", "smallbrick", "chiseled", "smooth", "squarebrick"};

    public BlockMagnetite(){
        super(Material.rock, "pickaxe", 1, 1.75F);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
    	return texture[meta];
    }
    
    public int damageDropped(int meta)
    {
        return meta;
    }
    
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs cTabs , List list){
		for(int i = 0; i < subBlocks.length; i++){
			list.add(new ItemStack(item , 1, i));
		}
	}
    
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		texture = new IIcon[subBlocks.length];
		
		for(int i = 0; i < subBlocks.length; i++){
			texture[i] = icon.registerIcon(MFMod.MODID + ":" + subBlocks[i] + "Magnetite");
		}
	}
}