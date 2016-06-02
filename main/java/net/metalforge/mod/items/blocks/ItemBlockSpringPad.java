package net.metalforge.mod.items.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSpringPad extends ItemBlock{
	
	final static String[] subBlocks = new String[]{"Copper", "Silver", "Gold"};

	public ItemBlockSpringPad(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= subBlocks.length){
			i = 0;
		}
		return super.getUnlocalizedName() + ".SpringPad" + subBlocks[i];
	}
	
	public int getMetadata(int meta){
		return meta;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List datalist, boolean bool) {
		int meta = itemstack.getItemDamage();
		datalist.add("Mk" + (meta == 0 ? "I" : (meta == 1 ? "II" : "III")));
	}
}
