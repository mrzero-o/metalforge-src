package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMF extends Block{
	
	public BlockMF(Material mat, String tool, int level, float hardness){
		super(mat);
		this.setHardness(hardness);
		this.setResistance(hardness * 1.5F);
		this.setCreativeTab(MFMod.metalforgeTab);
		this.setHarvestLevel(tool, level);
	}
	
	public BlockMF(Material mat, float hardness){
		this(mat, "pickaxe", 1, hardness);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
		int meta = world.getBlockMetadata(x, y, z);
        if (entity instanceof EntityWither){
        	if(this == MFBlocks.blastWall){
        		return false;
        	}
        }else if (entity instanceof EntityDragon){
        	if(this == MFBlocks.oreAll){
        		if(meta == 7 || meta == 9 || meta == 10) return false;
        	}
        }return true;
    }
}