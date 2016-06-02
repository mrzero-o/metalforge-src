package net.metalforge.mod.random;

import java.util.Collection;
import java.util.Random;

import net.metalforge.mod.items.ItemAlloy;
import net.metalforge.mod.items.ItemHot;
import net.metalforge.mod.items.MFItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandler {

	Random rand = new Random();
	
	@SubscribeEvent
	public void blockBreak(BlockEvent.BreakEvent event){
		if(event.getPlayer() != null && event.getPlayer().getCurrentEquippedItem() != null){
			if(event.getPlayer().getCurrentEquippedItem().getItem() == MFItems.NovaForce){
				int fortune = EnchantmentHelper.getFortuneModifier(event.getPlayer());
				ItemStack itemstack = new ItemStack(event.block.getItemDropped(event.blockMetadata, event.world.rand, fortune));
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack) != null){
					event.setCanceled(true);
					event.world.setBlockToAir(event.x, event.y, event.z);
					EntityItem result = new EntityItem(event.world, event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, FurnaceRecipes.smelting().getSmeltingResult(itemstack));
					if(!event.world.isRemote) event.world.spawnEntityInWorld(result);
				}
				
			}
		}
		
	}
	
	@SubscribeEvent
	public boolean livingUpdate(LivingUpdateEvent event){
		EntityLivingBase living = event.entityLiving;
		//Hot metals
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)living;
				if(!player.capabilities.isCreativeMode){
					ItemStack[] a = player.inventory.mainInventory;
					boolean hasTongs = false;
					for(int j = 0; j < 9; j++){
						ItemStack hotbarslot = player.inventory.mainInventory[j];
						if(hotbarslot != null && hotbarslot.getItem() == MFItems.Tongs){
							hasTongs = true;
							continue;
						}
					}
					if(ItemHot.doesPlayerHaveHotStuff(player) && !hasTongs){
						if(!hasTongs && !player.isWet()) player.setFire(1);
					}
				}
		}else{
			ItemStack held = living.getHeldItem();
			if(held != null && (held.getItem() instanceof ItemHot || held.getItem() instanceof ItemAlloy)){
				if(!living.isWet()) living.setFire(1);
			}
		}//CP flying machine
		if(living instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)living;
    		ItemStack chestplate = player.getCurrentArmor(2);
			if(!player.onGround){
				
			}
			/*if(Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()){
        		ItemStack chestplate = player.getCurrentArmor(2);
                if(chestplate != null && chestplate.getItem() == MFItems.FlyingMachine){
                	int damage = player.isInWater() ? 8 : 2;
                    if(Util.consumeCPFuel(player, chestplate, damage) && !player.onGround && !player.capabilities.isFlying){
                    	float ascend = player.isInWater() ? 0.65F : (player.motionY < 0 ? 0.25F : 0.125F);
                    	player.motionY += ascend;
                        player.fallDistance = 0;
                    }
                }
        	}*/
		}//Drinking Helmet
		if(living.getEquipmentInSlot(4) != null && living.getEquipmentInSlot(4).getItem() == MFItems.DrinkingHelmet){
			ItemStack helmet = living.getEquipmentInSlot(4);
			Collection effects = living.getActivePotionEffects();
			//fill up helmet
			if(helmet.getItemDamage() >= 5){
				if(living instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer)living;
					for(int i = 0; i < player.inventory.mainInventory.length; i++){
						if(absorbMilk(player.inventory.mainInventory[i], player)) continue;
					}
					helmet.setItemDamage(helmet.getItemDamage() - 5);
				}else if(living.getHeldItem() != null){
					absorbMilk(living.getHeldItem(), living);
				}
			}
			//heal playa
			if(helmet.getItemDamage() < helmet.getMaxDamage() && !effects.isEmpty()){
				if(!living.worldObj.isRemote) living.worldObj.playSoundAtEntity(living, "random.drink", 1.0F, 1.0F);
				if(living instanceof EntityPlayer) ((EntityPlayer)living).getFoodStats().addStats(0, 0.5F);
				helmet.damageItem(1, living);
				living.clearActivePotions();
			}
        }
		return false;
	}
	
	@SubscribeEvent
	public void livingDrops(LivingDropsEvent event)
	{
		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer && event.recentlyHit){
			//Guillotine Sword
			ItemStack held = ((EntityPlayer)event.source.getEntity()).getCurrentEquippedItem();
			if(held != null && held.getItem() == MFItems.DragoonBlade){
				int looting = EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, held);
				if(event.entityLiving.getClass() == EntitySkeleton.class){
					ItemStack skull = new ItemStack(Items.skull, 1, ((EntitySkeleton)event.entityLiving).getSkeletonType());
					if(rand.nextInt(22) <= (3 + looting)) dropLoot(event, skull);
				}else if(event.entityLiving.getClass() == EntityZombie.class){
					ItemStack zombob = new ItemStack(Items.skull, 1, 2);
					if(rand.nextInt(22) <= (2 + 2 * looting)) dropLoot(event, zombob);
				}else if(event.entityLiving.getClass() == EntityCreeper.class){
					ItemStack creeper = new ItemStack(Items.skull, 1, 4);
					if(rand.nextInt(22) <= (2 + 2 * looting)) dropLoot(event, creeper);
				}else if(event.entityLiving instanceof EntityPlayer){
					ItemStack human = new ItemStack(Items.skull, 1, 3);
					if(rand.nextInt(8) <= (1 + looting)){
						NBTTagCompound nametag = new NBTTagCompound();
						nametag.setString("SkullOwner", ((EntityPlayer)event.entityLiving).getDisplayName());
						human.setTagInfo("SkullOwner", nametag);
						dropLoot(event, human);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void struckByLightning(EntityStruckByLightningEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == MFItems.LightningBladeInert){
				ItemStack thunderedge = new ItemStack(MFItems.LightningBlade, 1, player.getCurrentEquippedItem().getItemDamage());
				//NBTTagList enchs = player.getCurrentEquippedItem().getEnchantmentTagList();
				//thunderedge.getEnchantmentTagList().appendTag(enchs.copy());
				if(player.isBlocking()) player.setCurrentItemOrArmor(0, thunderedge); 
			}
		}
	}
	
	public static void dropLoot(LivingDropsEvent event, ItemStack drop){
		EntityLivingBase living = event.entityLiving;
		EntityItem entityitem = new EntityItem(living.worldObj, living.posX, living.posY, living.posZ, drop);
		entityitem.delayBeforeCanPickup = 10;
		event.drops.add(entityitem);
	}
	
	@SubscribeEvent
	public void livingJump(LivingJumpEvent event){
		//Flying machine jump
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ItemStack chest = player.inventory.armorItemInSlot(2);
			if(chest != null && chest.getItem() == MFItems.FlyingMachine && !player.isSneaking() ){
				if(!player.worldObj.isRemote && Util.consumeCPFuel(player, chest, 2)) player.motionY += 0.5F; 
			}
		}
		//Spring boots
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ItemStack boots = player.inventory.armorItemInSlot(0);
			if(boots != null && boots.getItem() == MFItems.SpringBoots){
				if(!player.isSneaking()){
					player.motionY += 0.27F; 
				}
			}
		}
	}
	
	private ItemStack getArmor(EntityLivingBase living, int slot){
		return living.getEquipmentInSlot(slot);
	}
	
	private boolean absorbMilk(ItemStack itemstack, EntityLivingBase living){
		if(itemstack != null && itemstack.getItem() == Items.milk_bucket){
			--itemstack.stackSize;
			ItemStack output = new ItemStack(Items.bucket, itemstack.stackSize);
			if(living instanceof EntityPlayer){
				if(((EntityPlayer)living).inventory.addItemStackToInventory(output) && !living.worldObj.isRemote){
					living.worldObj.spawnEntityInWorld(new EntityItem(living.worldObj, living.posX, living.posY, living.posZ, output));
				}
			}
			return true;
		}
		return false;
	}
}
