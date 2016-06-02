package net.metalforge.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockFenceMF extends BlockFence{
	
	public Block block;

	public BlockFenceMF(Block block, float hardness) {
		super(block.getHarvestTool(0), block.getMaterial());
		this.block = block;
		this.setHardness(hardness);
		this.setStepSound(block.stepSound);
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	public boolean canConnectFenceTo(IBlockAccess blockaccess, int x, int y, int z)
    {
        Block block = blockaccess.getBlock(x, y, z);
        return block != this && block != this.block ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(this.block.getBlockTextureFromSide(0).getIconName());
    }
}
