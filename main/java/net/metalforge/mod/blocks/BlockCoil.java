package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.random.MFDamageSources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoil extends BlockMF{

	@SideOnly(Side.CLIENT)
	private IIcon top;
	
	public BlockCoil(){
		super(Material.iron, 3.0F);
		this.setResistance(10.0F);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int p_149691_2_)
    {
        return side != 1 && side != 0 ? this.blockIcon : this.top;
    }
	
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
		this.top = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5) + "Top");
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
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
		if(entity instanceof EntityLivingBase){
			Block[] hot = new Block[]{MFBlocks.HTOvenActive, MFBlocks.PurifierActive, MFBlocks.HTSmelterActive};
			for(int i = 0; i < hot.length; i++){
				if(world.getBlock(x, y - 1, z) == hot[i]) entity.attackEntityFrom(MFDamageSources.heatcoil, 0.65F);
			}for(int i = 0; i < hot.length; i++){
				if(world.getBlock(x, y - 1, z) == MFBlocks.HeatCoil){
					if(world.getBlock(x, y - 2, z) == hot[i]) entity.attackEntityFrom(MFDamageSources.heatcoil, 0.45F);
				}
			}
		}
    }
}