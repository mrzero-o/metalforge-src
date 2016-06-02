package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpringRail extends BlockRailBase{
	
	public BlockSpringRail() {
		super(true);
		this.setHardness(0.7F);
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

	@Override
    public void onEntityCollidedWithBlock (World world, int x, int y, int z, Entity entity)
    {
		if(entity instanceof EntityMinecart && entity.posY < y + 1){
			EntityMinecart cart = (EntityMinecart)entity;
            cart.setCanUseRail(false);
            cart.motionY += 1.275F;
            cart.motionX *= 2;
            cart.motionZ *= 2;
		}entity.fallDistance = 0;
    }
}
