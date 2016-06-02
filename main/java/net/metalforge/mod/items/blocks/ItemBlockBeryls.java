package net.metalforge.mod.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBeryls extends ItemBlock{
	
	final static String[] subBlocks = new String[]{"morganite", "heliodor", "aquamarine", "morganiteChiseled", "heliodorChiseled", "aquamarineChiseled"};

	public ItemBlockBeryls(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= subBlocks.length){
			i = 0;
		}
		return super.getUnlocalizedName() + "." + subBlocks[i] + "Beryl";
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}
