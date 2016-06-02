package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.tileentity.TileEntityWorldAnchor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWorldAnchor extends BlockContainerMF{

	public BlockWorldAnchor() {
		super(Material.anvil, 3.5F);
		this.setStepSound(soundTypeAnvil);
		this.setRenderTypeToDefault();
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityWorldAnchor();
	}

	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side)
    {
		return true;
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		TileEntityWorldAnchor tileentity = ((TileEntityWorldAnchor)world.getTileEntity(x, y, z));
		tileentity.loadChunks();
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		TileEntityWorldAnchor tileentity = (TileEntityWorldAnchor)world.getTileEntity(x, y, z);
		tileentity.unloadChunks();
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack itemstack) {
		if(living instanceof EntityPlayer){
			if(world.isRemote) ((EntityPlayer)living).addChatMessage(new ChatComponentText(MFMod.SIGNATURE + "Loading chunk at X:" + x + ", Z: " + y));
		}
	}

}
