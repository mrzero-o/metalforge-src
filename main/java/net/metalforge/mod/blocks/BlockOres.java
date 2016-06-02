package net.metalforge.mod.blocks;

import java.util.List;
import java.util.Random;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.items.MFItems;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOres extends BlockMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	public final static String[] subBlocks = new String[]{"copper", "tungsten", "xyrenite", "brownCoal", "richCoal"};
	
	public BlockOres(){
		super(Material.rock, 2.75F);
		this.setResistance(8.5F);
		this.setHarvestLevels();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		texture = new IIcon[subBlocks.length];
		
		for(int i = 0; i < subBlocks.length; i++){
			texture[i] = icon.registerIcon(MFMod.MODID + ":" + subBlocks[i] + "Ore");
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
	
	public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
	
	public int damageDropped(int meta){
		if(meta == 2 || meta == 3 || meta == 4) return 0;
		return meta;
	}
	
	public Item getItemDropped(int meta, Random rand, int i)
    {
		switch(meta){
		case 2: return MFItems.xyrenite;
		case 3: return MFItems.brownCoal;
		case 4: return Items.coal;
		default: return Item.getItemFromBlock(this);
		}
    }
	
	public int quantityDropped(int meta, int fortune, Random rand)
    {
		return meta == 4 ? rand.nextInt(2) + 2 : super.quantityDroppedWithBonus(fortune, rand);
    }
	
	public void setHarvestLevels(){
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setHarvestLevel("pickaxe", 3, 1);
		this.setHarvestLevel("pickaxe", 2, 2);
		this.setHarvestLevel("pickaxe", 0, 3);
		this.setHarvestLevel("pickaxe", 0, 4);
	}
}
