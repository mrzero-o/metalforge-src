package net.metalforge.mod.inventory.gui;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.inventory.ContainerPurifier;
import net.metalforge.mod.tileentity.TileEntityPurifier;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPurifier extends GuiContainer{

	public int tier;
	private TileEntityPurifier tileFurnace;

	public GuiPurifier(InventoryPlayer invPlayer, TileEntityPurifier tile, int tier) {
		super(new ContainerPurifier(invPlayer, tile, tier));
		this.tileFurnace = tile;
		this.tier = tier;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - (this.fontRendererObj.getStringWidth(string) / 2), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(getTexture());
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	        int i1;

	        if (this.tileFurnace.isBurning())
	        {
	            i1 = this.tileFurnace.getBurnTimeRemainingScaled(12);
	            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
	        }

	        i1 = this.tileFurnace.getCookProgressScaled(24);
	        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
	
	private ResourceLocation getTexture(){
		return new ResourceLocation(getTextureName(tier));
	}
	
	public static String getTextureName(int tier){
		return MFMod.MODID + ":" + "textures/gui/container/purifierGuiT" + tier + ".png";
	}
}