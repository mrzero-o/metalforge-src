package net.metalforge.mod.blocks;

import java.util.Random;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAncientGrass extends BlockMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	
	public BlockAncientGrass(){
		super(Material.grass, "shovel", 0, 0.625F);
		this.setStepSound(soundTypeGrass);
		this.setTickRandomly(true);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		if(side == 1) return top;
		if(side == 0) return bottom;
		else return this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.top = icon.registerIcon(MFMod.MODID + ":" + "ancientGrass");
		this.bottom = icon.registerIcon(MFMod.MODID + ":" + "ancientSoil");
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + "ancientGrassSide");
	}
	
	public Item getItemDropped(int i, Random rand, int j)
    {
        return MFBlocks.ancientSoil.getItemDropped(i, rand, j);
    }
	
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata)
    {
		return true;
    }
	
	public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote){
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2){
            	world.setBlock(x, y, z, MFBlocks.ancientSoil);
            }else if (world.getBlockLightValue(x, y + 1, z) >= 9){
                for (int l = 0; l < 4; ++l){
                    int i1 = x + rand.nextInt(3) - 1;
                    int j1 = y + rand.nextInt(5) - 3;
                    int k1 = z + rand.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);

                    if (world.getBlock(i1, j1, k1) == MFBlocks.ancientSoil && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                    	world.setBlock(i1, j1, k1, MFBlocks.ancientGrass);
                    }
                }
            }
        }
    }
	
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        return true;
    }
}