package net.metalforge.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHot extends ItemMF{
	
	private Item coolItem;
	
	public ItemHot(Item coolItem){
		super();
		this.coolItem = coolItem;
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		int meta = world.getBlockMetadata(x, y, z);
		if(world.getBlock(x, y, z) == Blocks.cauldron && meta > 0){
			if (!world.isRemote && player.getCurrentEquippedItem() != null){
				ItemStack coolItemStack = new ItemStack(this.coolItem);
				if(!player.inventory.addItemStackToInventory(coolItemStack)){}
				else if(player instanceof EntityPlayerMP){
					((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
				}
				if(!player.inventory.addItemStackToInventory(coolItemStack)){
					world.spawnEntityInWorld(new EntityItem(world, (double)x + 0.5D, (double)y + 1.5D, (double)z + 0.5D, coolItemStack));
				}--itemstack.stackSize;
				world.setBlockMetadataWithNotify(x, y, z, meta - 1, 3);
				if (itemstack.stackSize <= 0){
					player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
			    }
				world.playSoundAtEntity(player, "random.fizz", 1.0F, 1.0F / 1.0F);
				world.spawnParticle("smoke", x + 0.5F, y + 0.75F, z + 0.5F, 0.F, 0.0F, 0.0F);
			}
		}
        return true;
    }
	
	public static boolean doesPlayerHaveHotStuff(EntityPlayer player){
		ItemStack[] inventory = player.inventory.mainInventory;
		for(int i = 0; i < inventory.length; i++){
			if(inventory[i] != null && (inventory[i].getItem() instanceof ItemHot)) return true;
		}
		return false;
	}
	
	public Item getCoolItem() {
		return coolItem;
	}
	
}