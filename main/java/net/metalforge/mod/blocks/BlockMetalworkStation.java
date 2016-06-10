package net.metalforge.mod.blocks;

import java.util.ArrayList;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.crafting.MetalworkingManager;
import net.metalforge.mod.inventory.ContainerMetalwork;
import net.metalforge.mod.inventory.MFGuiHandler;
import net.metalforge.mod.items.ItemForger;
import net.metalforge.mod.tileentity.TileEntityMetalworkStation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetalworkStation extends BlockContainerMF{

	public BlockMetalworkStation() {
		super(Material.anvil, 5.0F);
		this.setStepSound(soundTypeAnvil);
		this.setRenderTypeToDefault();
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_) {
        TileEntityMetalworkStation tileEntity = (TileEntityMetalworkStation)world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            ArrayList<ItemStack> items = this.getContents(world, x, y, z);
            for (ItemStack item : items) {
                this.dumpItems(world, x, y, z, item);
            }
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, p_149749_6_);
    }

    public void dumpItems(World world, int x, int y, int z, ItemStack itemstack) {
        EntityItem entityitem = new EntityItem(world, (double)((float)x + 0.5f), (double)((float)y + 0.5f), (double)((float)z + 0.5f), itemstack);
        float f3 = 0.05f;
        entityitem.motionX = (float)world.rand.nextGaussian() * f3;
        entityitem.motionY = (float)world.rand.nextGaussian() * f3 + 0.2f;
        entityitem.motionZ = (float)world.rand.nextGaussian() * f3;
        if (itemstack.hasTagCompound()) {
            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
        }
        world.spawnEntityInWorld((Entity)entityitem);
    }

    protected ArrayList<ItemStack> getContents(World world, int x, int y, int z) {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        TileEntityMetalworkStation tileentity = (TileEntityMetalworkStation)world.getTileEntity(x, y, z);
        if (tileentity != null) {
            for (int i = 0; i < tileentity.getSizeInventory() - 1; ++i) {
                ItemStack itemstack = tileentity.getStackInSlot(i);
                if (itemstack == null) continue;
                items.add(itemstack);
            }
        }
        return items;
    }
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	public boolean isOpaqueCube()
	{
	    return false;
	}

	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return true;
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c){
		if(player.isSneaking()) return false;
		if(player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemForger){
			Block blockAbove = world.getBlock(x, y + 1, z);
			if(!(blockAbove == Blocks.air || blockAbove instanceof BlockTorch)){
				return false;
			}
			TileEntityMetalworkStation tileentity = (TileEntityMetalworkStation)world.getTileEntity(x, y, z);
			/*InventoryCrafting matrix = new InventoryCrafting(null, 3, 3);
			for (int i = 0; i < 9; ++i) {
	        	if(tileentity.getStackInSlot(i) != null){
	        		matrix.setInventorySlotContents(i, tileentity.getStackInSlot(i));
	        	}
	        }*/
			InventoryCrafting matrix = null;
			if(tileentity.container != null){
				matrix = tileentity.container.craftMatrix;
			}else{
				tileentity.container = new ContainerMetalwork(player.inventory, tileentity);
				matrix = tileentity.container.craftMatrix;
			}
			if(MetalworkingManager.getInstance().findMatchingRecipe(matrix, world) != null){
				if(MetalworkingManager.getInstance().findMatchingRecipe(matrix, world) != null){
					if(!world.isRemote){
						world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 1.10, z + 0.5, MetalworkingManager.getInstance().findMatchingRecipe(matrix, world)));
						world.playSoundEffect(x + 0.5D, y + 1.05D, z + 0.5D, "random.anvil_land", (float)(0.2F + world.rand.nextInt(3) / 10), (float)(0.4F + world.rand.nextInt(2) / 10));
					}
					tileentity.container.craftResult.setInventorySlotContents(0, MetalworkingManager.getInstance().findMatchingRecipe(matrix, world));
					for(int i = 0; i < 9; i++){
						InventoryCrafting craft = tileentity.container.craftMatrix;
						ItemStack stack = craft.getStackInSlot(i);
						if(stack != null){
							stack.stackSize--;
							if(stack.stackSize <= 0) stack = null;
						}
						craft.setInventorySlotContents(i, stack);
						tileentity.container.onCraftMatrixChanged(craft);
						
						/*if(tileentity.getStackInSlot(i) != null){
							--tileentity.getStackInSlot(i).stackSize;
							if(tileentity.getStackInSlot(i).stackSize <= 0) tileentity.setInventorySlotContents(i, null);
						}*/
					}
					tileentity.container.onCraftMatrixChanged(matrix);
				}
				return true;
			}
		}else{
			player.openGui(MFMod.INSTANCE, MFGuiHandler.METALWORK, world, x, y, z);
			return true;
		}return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityMetalworkStation();
	}
}
