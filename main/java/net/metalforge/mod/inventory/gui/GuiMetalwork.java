package net.metalforge.mod.inventory.gui;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.inventory.ContainerMetalwork;
import net.metalforge.mod.random.StringUtil;
import net.metalforge.mod.tileentity.TileEntityMetalworkStation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiMetalwork extends GuiContainer{

	public static String textureName = MFMod.MODID + ":" + "textures/gui/container/metalwork.png";
	public ResourceLocation texture = new ResourceLocation(textureName);
	
	public GuiMetalwork(InventoryPlayer invPlayer, TileEntityMetalworkStation tileentity) {
		super(new ContainerMetalwork(invPlayer, tileentity));
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j){
		
		String string = StringUtil.getMetalworkStationGuiName();
		this.fontRendererObj.drawString(string, this.xSize / 2 - (this.fontRendererObj.getStringWidth(string) / 2), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
