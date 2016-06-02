package net.metalforge.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.metalforge.mod.MFMod;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockFenceGateMF extends BlockFenceGate{
	
	public BlockFenceGateMF(SoundType sound, float hardness){
		this.setStepSound(sound);
		this.setCreativeTab(MFMod.metalforgeTab);
		this.setHardness(hardness);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return MFBlocks.blackwoodPlanks.getBlockTextureFromSide(side);
    }
}
