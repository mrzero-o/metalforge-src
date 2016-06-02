package net.metalforge.mod.items;

import net.metalforge.mod.entity.EntityMetalBall;
import net.metalforge.mod.random.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemItemGun extends ItemMF implements IItemCP{
	
	public ItemItemGun(){
		super();
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
		this.setFull3D();
	}
	
	public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	if(player.isSneaking()) return Util.eatCoal(player);
    	else if(itemstack.getItemDamage() <= 960){
    		int nextItemIndex = player.inventory.currentItem == 8 ? 0 : player.inventory.currentItem + 1;
    		ItemStack nextItemstack = player.inventory.mainInventory[nextItemIndex];
    		if(nextItemstack != null){
    			Item nextItem = nextItemstack.getItem();
    			Entity entity = null;
    			if(nextItem == Items.ender_pearl){
    				entity = new EntityEnderPearl(world, player);
    			}else if(nextItem == Items.experience_bottle){
    				entity = new EntityExpBottle(world, player);
    			}else if(nextItem == Items.snowball){
    				entity = new EntitySnowball(world, player);
    			}else if(nextItem == MFItems.MetalBall){
    				entity = new EntityMetalBall(world, player);
    			}else if(nextItem instanceof ItemMonsterPlacer){
    				entity = spawnCreature(world, nextItemstack.getItemDamage(), player.posX, player.posY + 1.125F, player.posZ);
    				if(entity != null && entity instanceof EntityLivingBase && nextItemstack.hasDisplayName()){
    					((EntityLiving)entity).setCustomNameTag(nextItemstack.getDisplayName());
    				}
    			}else if(nextItem == Item.getItemFromBlock(Blocks.tnt)){
    				entity = new EntityTNTPrimed(world, player.posX, player.posY + 1.125F, player.posZ, player);
    				((EntityTNTPrimed)entity).fuse = 24;
    			}else{
            		entity = new EntityItem(world, player.posX, player.posY + 1.125F, player.posZ, new ItemStack(nextItem, 1, nextItemstack.getItemDamage()));
            		((EntityItem)entity).delayBeforeCanPickup = 20;
        		}
    			
    			if(entity != null){
    				
					shootItem(player, entity);
        			itemstack.damageItem(40, player);
                    world.playSoundAtEntity(player, "random.explode", 0.01F, 0.4F / (itemRand.nextFloat() * 0.4F + 1.6F));
    				
    				if(--nextItemstack.stackSize <= 0) nextItemstack = null;
                    
                    return itemstack;
        		}
        	}
    	}return itemstack;
    }
	
	public static Entity spawnCreature(World world, int s, double x, double y, double z)
    {
        if(EntityList.entityEggs.containsKey(Integer.valueOf(s))){
        	Entity entity = null;
        	for (int j = 0; j < 1; ++j){
                entity = EntityList.createEntityByID(s, world);
                if (entity != null && entity instanceof EntityLivingBase){
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg((IEntityLivingData)null);
                    entityliving.playLivingSound();
                }
            }return entity;
        }return null;
    }
	
	public void shootItem(EntityPlayer player, Entity entity){
		float power = 2.4F;
		Vec3 vec = player.getLookVec();

		if(!player.worldObj.isRemote){
			player.worldObj.spawnEntityInWorld(entity);
			
			player.motionX += -(vec.xCoord * 0.6F);
			player.motionY += -(vec.yCoord * 0.6F);
			player.motionZ += -(vec.zCoord * 0.6F);
			
			entity.motionX += vec.xCoord * power;
			entity.motionY += vec.yCoord * power;
			entity.motionZ += vec.zCoord * power;
		}
	}
}
