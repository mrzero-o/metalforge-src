package net.metalforge.mod.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSolidBlocks extends ItemBlock{
	
	final static String[] subBlocks = new String[]{"copper", "tungsten", "xyrenium", "steel", "berylBronze", "dragoonyte"};

	public ItemBlockSolidBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= subBlocks.length){
			i = 0;
		}
		return super.getUnlocalizedName() + "." + subBlocks[i] + "Block";
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}
