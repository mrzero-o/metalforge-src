package net.metalforge.mod.inventory.gui;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.inventory.ContainerCauldron;
import net.metalforge.mod.tileentity.TileEntitySmelter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCauldron extends GuiContainer{

	public GuiCauldron(InventoryPlayer invPlayer) {
		super(new ContainerCauldron(invPlayer));
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = "";
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
	}
	
	private ResourceLocation getTexture(){
		return new ResourceLocation(getTextureName());
	}
	
	public static String getTextureName(){
		return MFMod.MODID + ":" + "textures/gui/container/neiCauldronGui.png";
	}
}