package net.metalforge.mod.items;

import net.metalforge.mod.entity.EntityMetalBall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMetalBall extends ItemMF
{
	public ItemMetalBall()
    {
		super();
        this.setMaxStackSize(16);
    }
    
	@Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) world.spawnEntityInWorld(new EntityMetalBall(world, player));
        if (!player.capabilities.isCreativeMode) --itemstack.stackSize;
        
        return itemstack;
    }
}