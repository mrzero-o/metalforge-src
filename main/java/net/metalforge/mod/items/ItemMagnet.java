package net.metalforge.mod.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagnet extends ItemMF{
	
	private int radius;

	public ItemMagnet(int radius){
		super();
		this.radius = radius;
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
		this.setRarity(EnumRarity.epic);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		if(player.isSneaking()){
			itemstack.setItemDamage(itemstack.getItemDamage() == 0 ? 1 : 0);
		}
        return itemstack;
    }
    
    public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack)
    {
        return itemstack.getItemDamage() == 0;
    }
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_){
		if(itemstack.getItemDamage() == 0){
			double x = entity.posX, y = entity.posY, z = entity.posZ;
			int r = this.radius;
			AxisAlignedBB box = AxisAlignedBB.getBoundingBox(x - r, y - r, z - r, x + r, y + r, z + r);
			List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, box);
			for(int i = 0; i < entities.size(); i++){
				Entity item = entities.get(i);
				if(item.getDistanceSq(x, y, z) > 3.0F){
					if(item instanceof EntityXPOrb || (item instanceof EntityItem && item.ticksExisted > 5)){
						if(!world.isRemote) item.moveEntity(x - item.posX, y - item.posY, z - item.posZ);
						if(item instanceof EntityItem ) ((EntityItem)item).delayBeforeCanPickup = 0;
					}
				}
			}
		}
	}
	
}
