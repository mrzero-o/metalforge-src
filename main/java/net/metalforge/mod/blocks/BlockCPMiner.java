package net.metalforge.mod.blocks;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.tileentity.TileEntityCPMiner;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCPMiner extends BlockContainer{
	
	@SideOnly(Side.CLIENT)
	private IIcon topIcon, bottomIcon;
	
	public BlockCPMiner(){
		super(Material.iron);
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeAnvil);
		this.setCreativeTab(MFMod.metalforgeTab);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityCPMiner){
			TileEntityCPMiner tileentity = (TileEntityCPMiner)world.getTileEntity(x, y, z);
			if(player.getCurrentEquippedItem() != null){
				ItemStack held = player.getCurrentEquippedItem();
				int fuelValue = getFuelValue(held.getItem());
				if(tileentity.fuel < 10000 && fuelValue > 0){
					tileentity.fuel += fuelValue;
					if(!player.capabilities.isCreativeMode) --held.stackSize;
				}
			}else if(!world.isRemote) player.addChatMessage(new ChatComponentText(MFMod.SIGNATURE + "CP Miner Charge: " + tileentity.fuel + "/10000 CPUnits"));
		}return true;
    }
	
	private int getFuelValue(Item item){
		return item == MFItems.coalCoke ? 240 : (item == Items.coal ? 120 : (item == MFItems.brownCoal ? 15 : 0));
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(MFMod.MODID + ":" + this.getUnlocalizedName().substring(5));
		this.topIcon = icon.registerIcon(MFMod.MODID + ":metalMachineTop");
		this.bottomIcon = icon.registerIcon(MFMod.MODID + ":metalMachineSide");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityCPMiner();
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? topIcon : (side == 0 ? bottomIcon : blockIcon);
	}
}
