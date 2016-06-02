package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public abstract class BlockContainerMF extends BlockContainer{
	
	private boolean defaultRenderer;
	
	public BlockContainerMF(Material mat, String tool, int level, float hardness){
		super(mat);
		this.setHardness(hardness);
		this.setResistance(hardness * 1.5F);
		this.setCreativeTab(MFMod.metalforgeTab);
		this.setHarvestLevel(tool, level);
	}
	
	public BlockContainerMF(Material mat, float hardness){
		this(mat, "pickaxe", 1, hardness);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public Block setRenderTypeToDefault(){
		this.defaultRenderer = true;
		return this;
	}
	
	public int getRenderType(){
		return this.defaultRenderer ? -1 : super.getRenderType();
	}
}
