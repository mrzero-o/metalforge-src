package net.metalforge.mod.blocks;

import java.util.Random;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.tileentity.TileEntityCarbonDiablo;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCarbonDiablo extends BlockContainerMF{
	
	@SideOnly(Side.CLIENT)
	private IIcon topIcon, bottomIcon;
	
	public BlockCarbonDiablo(){
		super(Material.iron, 30.F);
		this.setResistance(0);
		this.setStepSound(soundTypeAnvil);
		this.setRenderTypeToDefault();
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.8125F, 0.9375F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityCarbonDiablo){
			TileEntityCarbonDiablo tileentity = (TileEntityCarbonDiablo)world.getTileEntity(x, y, z);
			if(player.getCurrentEquippedItem() != null){
				if(player.getCurrentEquippedItem().getItem() instanceof ItemFlintAndSteel){           
					tileentity.explode();
					return true;
				}else{
					ItemStack held = player.getCurrentEquippedItem();
					int fuelValue = getFuelValue(held.getItem());
					if(tileentity.fuel < tileentity.maxFuel && fuelValue > 0){
						tileentity.fuel += fuelValue;
						world.spawnParticle("smoke", x + 0.5F, (y + 0.9F), (z + 0.5F), 0.0D, 0.025D, 0.0D);
						if(!player.capabilities.isCreativeMode) --held.stackSize;
					}
				}
			}else if(!world.isRemote) player.addChatMessage(new ChatComponentText("Charge: " + (int)(tileentity.fuel / 50) + "%"));
		}return true;
    }
	
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
    {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity != null && tileentity instanceof TileEntityCarbonDiablo) ((TileEntityCarbonDiablo)tileentity).explode();
		super.onBlockExploded(world, x, y, z, explosion);
    }
	
	private int getFuelValue(Item item){
		return item == MFItems.coalCoke ? 240 : (item == Items.coal ? 120 : (item == MFItems.brownCoal ? 15 : 0));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityCarbonDiablo();
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? topIcon : (side == 0 ? bottomIcon : blockIcon);
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
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
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":CarbonDiablo");
	}
	
	/*@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand){
		TileEntityCarbonDiablo diablo = (TileEntityCarbonDiablo)world.getTileEntity(x, y, z);
		if(diablo.fuel > diablo.maxFuel) diablo.fuel = diablo.maxFuel;
		int chance = (int)((diablo.maxFuel - diablo.fuel) / 1000) + 1;
		if(chance < (diablo.maxFuel / 1000) && rand.nextInt(chance) <= 0){
			world.spawnParticle("smoke", x + 0.5F, (y + 0.9F), (z + 0.5F), 0.0D, 0.025D, 0.0D);
		}
	}*/
}
