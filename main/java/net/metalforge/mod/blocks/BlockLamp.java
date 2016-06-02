package net.metalforge.mod.blocks;

import java.util.Random;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.tileentity.TileEntityLamp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLamp extends BlockContainerMF{

	public BlockLamp(boolean isLit) {
		super(Material.wood, 2.0F);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(isLit ? null : MFMod.metalforgeTab);
		this.setLightLevel(isLit ? 1.0F : 0.0F);
		this.setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.875F, 0.8125F);
		this.setRenderTypeToDefault();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		Block block = world.getBlock(x, y, z);
		ItemStack held = player.getCurrentEquippedItem();
		if(block == MFBlocks.LampActive && held == null && player.isSneaking()){
			world.setBlock(x, y, z, MFBlocks.LampOff, 0, 3);
			world.spawnParticle("explode", x + 0.5F, y + 0.5F, z + 0.5F, 0.0D, 0.0D, 0.0D);  
			world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.fizz", 1.0F, 1.0F);
		}else if(block == MFBlocks.LampOff && held != null && held.getItem() == Items.flint_and_steel){
			world.setBlock(x, y, z, MFBlocks.LampActive, 0, 3);
			player.getCurrentEquippedItem().damageItem(1, player);
			world.spawnParticle("flame", x + 0.5F, y + 0.5F, z + 0.5F, 0.0D, 0.0D, 0.0D);  
			world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.ignite", 1.0F, 1.0F);
		}return true;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityLamp();
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	/*public int getRenderType(){
		return -247;
	}*/
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return true;
    }
	
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":Lamp");
	}
	
	public int damageDropped(int meta){
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		Block block = world.getBlock(x, y, z);
		if(block == MFBlocks.LampActive){
			world.spawnParticle("smoke", x + 0.5F, (y + 0.5F), (z + 0.5F), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", x + 0.5F, (y + 0.5F), (z + 0.5F), 0.0D, 0.0D, 0.0D);  
		}
	}
}
