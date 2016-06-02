package net.metalforge.mod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLeafTakerMachete extends ItemMF{

	public ItemLeafTakerMachete() {
		super();
		this.setFull3D();
		this.setMaxDamage(1524);
		this.setRarity(EnumRarity.epic);
	}
	
	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {
		if(block.isLeaves(world, x, y, z)){
			killLeaves(living, world, x, y, z);
			itemstack.damageItem(1, living);
		}
        return false;
    }
	
	public void killLeaves(EntityLivingBase living, World world, int x, int y, int z){
		if(living instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)living;
			for(int a = x - 2; a < x + 2; a++){
				for(int b = y - 2; b < y + 2; b++){
					for(int c = z - 2; c < z + 2; c++){
						Block block = world.getBlock(a, b, c);
						if(block.isLeaves(world, x, y, z)){
							int meta = world.getBlockMetadata(a, b, c);
							ItemStack drop = new ItemStack(block, block.quantityDropped(world.rand), block.damageDropped(meta));
							EntityItem entityitem = new EntityItem(world, a + 0.5F, b + 0.5F, c + 0.5F, drop);
							world.setBlockToAir(a, b, c);
							if(!world.isRemote) world.spawnEntityInWorld(entityitem);
						}
					}
				}
			}
		}
	}

    public float getDigSpeed(ItemStack itemstack, Block block, int metadata)
    {
    	if(block instanceof BlockLeavesBase || block instanceof BlockBush) return 20.0F;
    	else return 1.0F;
    }
}
