package net.metalforge.mod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPersonal extends BlockContainerMF{

	public BlockPersonal(Material mat, String tool, int level, float hardness){
		super(mat, tool, level, hardness);
	}

	public BlockPersonal(Material mat, float hardness){
		super(mat, "pickaxe", 1, hardness);
	}
	
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return null;
	}

}
