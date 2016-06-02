package net.metalforge.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.metalforge.mod.MFMod;
import net.metalforge.mod.tileentity.TileEntityDoorSecure;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDoorMF extends ItemDoor{
	
	private Block block;

	public ItemDoorMF(Block block) {
		super(block.getMaterial());
		this.setCreativeTab(MFMod.metalforgeTab);
		this.block = block;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (side != 1) return false;
        else{
            ++y;
            if (player.canPlayerEdit(x, y, z, side, itemstack) && player.canPlayerEdit(x, y + 1, z, side, itemstack)){
                if (!block.canPlaceBlockAt(world, x, y, z)) return false;
                else{
                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(world, x, y, z, i1, block);
                    --itemstack.stackSize;
                    
                    setOwner(world, x, y + 1, z, player);
                    setOwner(world, x, y + 2, z, player);
                    
                    return true;
                }
            }else return false;
        }
    }
	
	private void setOwner(World world, int x, int y, int z, EntityPlayer player){
        TileEntity tileentity = world.getTileEntity(x, y, z);
        if(tileentity != null && tileentity instanceof TileEntityDoorSecure){
			((TileEntityDoorSecure)tileentity).setOwner(player);
		}
	}
}
