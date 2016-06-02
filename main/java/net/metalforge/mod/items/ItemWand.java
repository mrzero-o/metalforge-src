package net.metalforge.mod.items;

import net.metalforge.mod.random.Util;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemWand extends ItemMF {
	
	private EnumWandType wandType;
	
	public ItemWand(EnumWandType wandType){
		super();
		this.wandType = wandType;
		this.setFull3D();
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		if(this.wandType == EnumWandType.BLAZE && itemstack != null && Util.attemptManaConsumption(player, 15)){
			player.swingItem();
		}else if(this.wandType == EnumWandType.RAIN && itemstack != null && Util.attemptManaConsumption(player, 35)){
			world.getWorldInfo().setRaining(!world.isRaining());
			world.playSoundEffect(player.posX, player.posY, player.posZ, "random.orb", 1.0F, 0.75F);
			player.swingItem();
		}else if(this.wandType == EnumWandType.REGEN && itemstack != null && player.getHealth() < player.getMaxHealth()){
			boolean healed = false;
			while(player.getHealth() < player.getMaxHealth()){
				if(Util.attemptManaConsumption(player, 2)){
					player.heal(0.75F);
					healed = true;
				}else continue;
			}
			if(healed) player.swingItem();
		}
		return itemstack;
	}
	
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase living) {
		if(this.wandType == EnumWandType.BLAZE && Util.attemptManaConsumption(player, 10)){
			living.setFire(3);
			player.swingItem();
		}else if(this.wandType == EnumWandType.REMOVING && Util.attemptManaConsumption(player, 15)){
			living.attackEntityFrom(DamageSource.causeIndirectMagicDamage(player, living), 10.0F);
			player.swingItem();
		}
		return true;
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		Block block = world.getBlock(x, y, z);
		if(this.wandType == EnumWandType.REMOVING){
			if(Util.attemptManaConsumption(player, 5) && block.getBlockHardness(world, x, y, z) >= 0.0F){
				int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack);
				int meta = world.getBlockMetadata(x, y, z);
				ItemStack drop = new ItemStack(block.getItemDropped(meta, world.rand, fortune), block.quantityDropped(world.rand), block.damageDropped(meta));
				Util.destroyBlock(world, x, y, z, drop);
				return true;
			}
		}else if(this.wandType == EnumWandType.BLAZE){
			if(Util.canIgniteBlock(itemstack, player, x, y, z, side) && Util.attemptManaConsumption(player, 5)){
				Util.igniteBlock(itemstack, player, x, y, z, side, 0);
			}
				
			return true;
		}
		return false;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }
	
	public enum EnumWandType{
		BLAZE, STORM, RAIN, REMOVING, REGEN
	}
	
}
