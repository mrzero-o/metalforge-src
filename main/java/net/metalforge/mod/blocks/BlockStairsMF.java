package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockStairsMF extends BlockStairs{
	
	public BlockStairsMF(Block block, float hardness){
		super(block, 0);
		this.setStepSound(block.stepSound);
		this.setCreativeTab(MFMod.metalforgeTab);
	}

}
