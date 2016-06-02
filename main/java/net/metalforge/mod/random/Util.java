package net.metalforge.mod.random;

import java.util.ArrayList;
import java.util.Random;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.ItemManaStorage;
import net.metalforge.mod.items.MFItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class Util {
	
	private static Random  rand = new Random();
	
	/**
	*Damages the given item in the given playerinventory. Args: item, playerinventory, damage
	*/
	public static boolean damageInventoryItem(Item item, InventoryPlayer inv, int damage)
    {
        int i = 0, j;
        
        for(j = 0; j < inv.mainInventory.length; ++j)
        {
            if(inv.mainInventory[j] != null && inv.mainInventory[j].getItem() == item) i = j;
        }if(i != j) i = -1;
        if(i < 0) return false;
        else if((inv.mainInventory[i].getItemDamage() - 1) <= 0){
            return false;
        }inv.mainInventory[i].damageItem(damage, inv.player);
        return true;
    }
	/**
	*Consumes coal and fills up the tools CP
	*/
	public static ItemStack eatCoal(EntityPlayer player)
    {
		ItemStack itemstack = player.getCurrentEquippedItem();
    	if(player.isSneaking()){
    		Item[] coal = new Item[]{MFItems.coalCoke, Items.coal, MFItems.brownCoal};
    		for(int i = 0; i < coal.length; i++){
    			if(player.inventory.hasItem(coal[i]) && itemstack.getItemDamage() > 0){
    				itemstack.setItemDamage(itemstack.getItemDamage() - (i == 2 ?  32 : (i == 1 ? 128 : 256)));
    				if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(coal[i]);
    				return itemstack;
    			}
    		}
    	}return itemstack;
    }
	/**
	*Sets a random mobspawnertype to the given coordinates
	*/
	public static void setMobSpawnerType(World world, int x, int y, int z){
		if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityMobSpawner){
			((TileEntityMobSpawner)world.getTileEntity(x, y, z)).func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(rand));
		}
	}
	/**
	*Fills the chest at the given coordinates with different dungeon loot
	*/
	public static void fillChest(World world, int x, int y, int z, String chestgenhook){
		if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityChest){
			TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);
			WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(chestgenhook, rand), chest, ChestGenHooks.getCount(chestgenhook, rand));
		}
	}
	
	public static Block pickLootBlock(){
		int random = rand.nextInt(3);
		Block block = Blocks.dirt;
		switch(random){
		case 0: block = Blocks.iron_block;
		case 1: block = Blocks.gold_block;
		default: block = MFBlocks.metalBlockAll;
			break;
		}return block;
	}
	
	public static void decrStackSize(ItemStack itemstack){
		if(itemstack.stackSize <= 1) itemstack = (ItemStack)null;
		else --itemstack.stackSize;
	}
	
	public static boolean consumeCPFuel(EntityLivingBase living, ItemStack itemstack, int amount){
		boolean bool = living instanceof EntityPlayer ? (((EntityPlayer)living).capabilities.isCreativeMode ? false : true) : true;
		if(itemstack.getItemDamage() + amount <= itemstack.getMaxDamage()){
			if(bool) itemstack.damageItem(amount, living);
			return true;
		}return false;
	}
	/**
	 * Return if the armoritem at the given slot equals the given one
	 */
	public static boolean isArmorItem(int slot, EntityLivingBase living, Item item){
		return living.getEquipmentInSlot(slot) != null && living.getEquipmentInSlot(slot).getItem() == item;
	}
	
	public static boolean attemptManaConsumption(EntityPlayer player, int mana){
		if(player.capabilities.isCreativeMode) return true;
		boolean hasEnoughMana = false;
		ItemStack[] inv = player.inventory.mainInventory;
		for(int i = 0; i < inv.length; i++){
			if(inv[i] != null && inv[i].getItem() instanceof ItemManaStorage && inv[i].getItemDamage() < (inv[i].getMaxDamage() - mana)){
				inv[i].damageItem(mana, player);
				return true;
			}
		}return false;
	}
	/**
	 * Destroys the block at the given coordinates and drops the given itemstack as entityitem
	 */
	public static void destroyBlock(World world, int x, int y, int z, ItemStack itemstack){
		world.setBlockToAir(x, y, z);
        float f = 0.7F;
        double a = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
        double b = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
        double c = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(world, x + a, y + b, z + c, itemstack);
        entityitem.delayBeforeCanPickup = 10;
        if(!world.isRemote) world.spawnEntityInWorld(entityitem);
	}
	/**
	 * Returns whether the block can be ignited
	 */
	public static boolean canIgniteBlock(ItemStack itemstack, EntityPlayer player, int x, int y, int z, int side){
		
		switch(side){
		case 0: --y;
		case 1: ++y;
		case 2: --z;
		case 3: ++z;
		case 4: --x;
		case 5: ++x;
		}

        if(!player.canPlayerEdit(x, y, z, side, itemstack)) return false;
        return true;
	}
	/**
	 * Ignites the block at the given coordinates, returns false if the player is unable to
	 */
	public static boolean igniteBlock(ItemStack itemstack, EntityPlayer player, int x, int y, int z, int side, int damage)
    {
		World world = player.worldObj;
		if(!canIgniteBlock(itemstack, player, x, y, z, side)) return false;
        else{
            if(world.isAirBlock(x, y, z)){
                world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(x, y, z, Blocks.fire);
            }
            if(damage > 0) itemstack.damageItem(damage, player);
            return true;
        }
    }
	
	public static ArrayList<Block> getBlocksSurrounding(World world, int x, int y, int z){
		ArrayList<Block> blocks = new ArrayList<Block>();
		blocks.add(world.getBlock(x - 1, y, z));
		blocks.add(world.getBlock(x + 1, y, z));
		blocks.add(world.getBlock(x, y - 1, z));
		blocks.add(world.getBlock(x, y + 1, z));
		blocks.add(world.getBlock(x, y, z - 1));
		blocks.add(world.getBlock(x, y, z + 1));
		return blocks;
	}
}
