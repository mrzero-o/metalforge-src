package net.metalforge.mod.blocks;

import java.util.Random;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.inventory.MFGuiHandler;
import net.metalforge.mod.tileentity.TileEntityPurifier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPurifier extends BlockContainerMF {

	private final boolean isActive;
	public int tier;

	@SideOnly(Side.CLIENT)
	private IIcon front;

	@SideOnly(Side.CLIENT)
	private IIcon top;

	private static boolean keepInventory;
	private Random rand = new Random();

	public BlockPurifier(boolean isActive, int tier) {
		super(tier == 1 ? Material.rock : Material.iron, 3.0F);
		this.setCreativeTab(isActive ? null : MFMod.metalforgeTab);
		this.setStepSound(tier == 1 ? soundTypeStone : soundTypeMetal);
		this.isActive = isActive;
		this.tier = tier;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		if(this.tier == 1){
			this.blockIcon = iconRegister.registerIcon(MFMod.MODID + ":" + "brickMachineSide");
			this.top = iconRegister.registerIcon(MFMod.MODID + ":" + "brickMachineTop");
		}else if(this.tier == 2){
			this.blockIcon = iconRegister.registerIcon(MFMod.MODID + ":" + "metalMachineSide");
			this.top = iconRegister.registerIcon(MFMod.MODID + ":" + "metalMachineTop");
		}
		this.front = iconRegister.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.front : side == 1 ? top : (side == metadata ? this.front : this.blockIcon);
	}

	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(this.tier == 1 ? MFBlocks.PurifierIdle : MFBlocks.MetalPurifierIdle);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote) {
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x,  y,  z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4  = world.getBlock(x + 1, y, z);

			byte b0 = 3;

			if(b1.func_149730_j() && !b2.func_149730_j()) {
				b0 = 3;	
			}

			if(b2.func_149730_j() && !b1.func_149730_j()) {
				b0 = 2;	
			}

			if(b3.func_149730_j() && !b4.func_149730_j()) {
				b0 = 5;	
			}

			if(b4.func_149730_j() && !b3.func_149730_j()) {
				b0 = 4;	
			}

			world.setBlockMetadataWithNotify(x, y, x, b0, 2);
		}

	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			if(!player.isSneaking()){
				player.openGui(MFMod.INSTANCE, MFGuiHandler.PURIFIER, world, x, y, z);
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return (new TileEntityPurifier().setTier(this.tier));
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if(this.isActive) {
			int direction = world.getBlockMetadata(x, y, z);

			float x1 = (float)x + 0.5F;
			float y1 = (float)y + random.nextFloat();
			float z1 = (float)z + 0.5F;

			float f = 0.52F;
			float f1 = random.nextFloat() * 0.6F - 0.3F;

			if(direction == 4){
				world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			}

			if(direction == 5){
				world.spawnParticle("smoke", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			}

			if(direction == 2){
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
			}

			if(direction == 3){
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
			}
			if(this.tier == 1){
				if(world.getBlock(x, y + 1, z) == MFBlocks.HeatCoil){
					world.spawnParticle("flame", (double)(x1), (double)(y1) + 1, (double)(z1), 0D, 0D, 0D);
					if(world.getBlock(x, y + 2, z) == MFBlocks.HeatCoil){
						world.spawnParticle("flame", (double)(x1), (double)(y1) + 2, (double)(z1), 0D, 0D, 0D);
					}
				}
			}
		}
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;

		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if(itemstack.hasDisplayName()) {
			((TileEntityPurifier)world.getTileEntity(x, y, z)).getInventoryName();
		}
	}

	public static void updateMachineState(boolean active, World world, int xCoord, int yCoord, int zCoord) {
		int i = world.getBlockMetadata(xCoord, yCoord, zCoord);

		TileEntity tileentity = world.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if(world.getBlock(xCoord, yCoord, zCoord) == MFBlocks.PurifierIdle && active) {
			world.setBlock(xCoord, yCoord, zCoord, MFBlocks.PurifierActive);
		}else if(world.getBlock(xCoord, yCoord, zCoord) == MFBlocks.PurifierActive && !active){
			world.setBlock(xCoord, yCoord, zCoord, MFBlocks.PurifierIdle);
		}
		
		if(world.getBlock(xCoord, yCoord, zCoord) == MFBlocks.MetalPurifierIdle && active) {
			world.setBlock(xCoord, yCoord, zCoord, MFBlocks.MetalPurifierActive);
		}else if(world.getBlock(xCoord, yCoord, zCoord) == MFBlocks.MetalPurifierActive && !active){
			world.setBlock(xCoord, yCoord, zCoord, MFBlocks.MetalPurifierIdle);
		}

		keepInventory = false;

		world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileentity != null) {
			tileentity.validate();
			world.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		if(!keepInventory) {
			TileEntityPurifier tileentity = (TileEntityPurifier) world.getTileEntity(x, y, z);

			if(tileentity != null) {
				for(int i = 0; i < tileentity.getSizeInventory(); i++) {
					ItemStack itemstack = tileentity.getStackInSlot(i);

					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						while(itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;

							if(j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;

							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if(itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}

							world.spawnEntityInWorld(item);
						}
					}
				}

				world.func_147453_f(x, y, z, oldblock);
			}
		}

		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(this.tier == 1 ? MFBlocks.PurifierIdle : MFBlocks.MetalPurifierIdle);
	}

}