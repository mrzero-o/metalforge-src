package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlackwoodLog extends BlockRotatedPillar{
	
    @SideOnly(Side.CLIENT)
    private IIcon side;
    @SideOnly(Side.CLIENT)
    private IIcon top;
    
    private static final String __OBFID = "CL_00000266";

    public BlockBlackwoodLog()
    {
        super(Material.wood);
        this.setCreativeTab(MFMod.metalforgeTab);
        this.setHardness(2.0F);
        this.setStepSound(soundTypeWood);
        this.setHarvestLevel("axe", 0);
    }

    public static int func_150165_c(int p_150165_0_)
    {
        return p_150165_0_ & 3;
    }

    public void breakBlock(World world, int x, int y, int z, Block block1, int p_149749_6_)
    {
        byte b0 = 4;
        int i1 = b0 + 1;

        if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
        {
            for (int j1 = -b0; j1 <= b0; ++j1)
            {
                for (int k1 = -b0; k1 <= b0; ++k1)
                {
                    for (int l1 = -b0; l1 <= b0; ++l1)
                    {
                        Block block = world.getBlock(x + j1, y + k1, z + l1);
                        if (block.isLeaves(world, x + j1, y + k1, z + l1))
                        {
                            block.beginLeavesDecay(world, x + j1, y + k1, z + l1);
                        }
                    }
                }
            }
        }
    }
    
    @Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.side = icon.registerIcon("metalforge:blackwoodBark");
		this.top = icon.registerIcon("metalforge:blackwoodLog");
	}

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_)
    {
        return side;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return top;
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}