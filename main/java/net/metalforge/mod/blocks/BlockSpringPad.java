package net.metalforge.mod.blocks;

import java.util.List;

import net.metalforge.mod.MFMod;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpringPad extends BlockMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;

	final static String[] subBlocks = new String[]{"Copper", "Silver", "Gold"};

	public BlockSpringPad() {
		super(Material.rock, 3.0F);
		this.setResistance(15.0F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		texture = new IIcon[subBlocks.length];
		
		for(int i = 0; i < subBlocks.length; i++){
			texture[i] = icon.registerIcon(MFMod.MODID + ":SpringPad" + subBlocks[i]);
		}
		
		this.bottom = icon.registerIcon(MFMod.MODID + ":SpringPadBottom");
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":SpringPad");
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs cTabs , List list){
		for(int i = 0; i < subBlocks.length; i++){
			list.add(new ItemStack(item , 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side != 0 && side != 1 ? texture[meta] : (side == 0 ? bottom : blockIcon);
	}
	
	public int damageDropped(int meta){
		return meta;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return true;
    }
	
	@Override
    public void onEntityCollidedWithBlock (World world, int x, int y, int z, Entity entity)
    {
		if(entity.motionY < 0.825F && entity.onGround && !entity.isSneaking() && !(entity instanceof EntityFX)){
			int meta = world.getBlockMetadata(x, y, z);
			entity.motionY = meta == 0 ? 0.825F : (meta == 1 ? 1.05F : (meta == 2 ? 1.275F : 0.0F));
		}entity.fallDistance = 0;
    }
}
