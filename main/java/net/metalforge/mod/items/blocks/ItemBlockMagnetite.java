package net.metalforge.mod.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMagnetite extends ItemBlock{

    public static final String[] subBlocks = new String[] {"stone", "brick", "smallbrick", "chiseled", "smooth", "squarebrick"};

	public ItemBlockMagnetite(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= subBlocks.length){
			i = 0;
		}
		return super.getUnlocalizedName() + "." + subBlocks[i] + "Magnetite";
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}
