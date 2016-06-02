package net.metalforge.mod.items;

import net.metalforge.mod.random.Util;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemSwappersStaff extends ItemMF {
	
	public ItemSwappersStaff(){
		super();
		this.setFull3D();
		this.setMaxDamage(240);
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		InventoryPlayer inv = player.inventory;
		int nextItemIndex = inv.currentItem != 8 ? inv.currentItem + 1 : 0;
		if(inv.mainInventory[nextItemIndex] != null){
			ItemStack nextItem = inv.mainInventory[nextItemIndex];
			if(nextItem.getItem() instanceof ItemBlock && nextItem.stackSize > 1){
				Block old = world.getBlock(x, y, z);
				int meta = old.damageDropped(world.getBlockMetadata(x, y, z));
				EntityItem returns = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(old, 1, meta));
				if(!isExactlyEqualTo(world, x, y, z, nextItem)){
					Util.decrStackSize(nextItem);
					world.setBlock(x, y, z, Block.getBlockFromItem(nextItem.getItem()), nextItem.getItemDamage(), 3);
					if(!world.isRemote) world.spawnEntityInWorld(returns);
				}
				if(!player.capabilities.isCreativeMode) itemstack.damageItem(1, player);
			}
		}
        return true;
    }
	
	private boolean isExactlyEqualTo(World world, int x, int y, int z, ItemStack itemstack){
		boolean isBlockSame = false;
		boolean isMetaSame = false;
		if(world.getBlock(x, y, z) == Block.getBlockFromItem(itemstack.getItem())) isBlockSame = true;
		if(world.getBlockMetadata(x, y, z) == itemstack.getItemDamage()) isMetaSame = true;
		if(isBlockSame && isMetaSame) return true;
		return false;
	}
}
