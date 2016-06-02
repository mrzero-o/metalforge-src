package net.metalforge.mod.inventory.gui;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.inventory.ContainerBackpack;
import net.metalforge.mod.items.ItemBackpack;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import scala.reflect.internal.Trees.This;

public class GuiBackpack extends GuiContainer {
	
	public int tier;
	private ResourceLocation texture = new ResourceLocation(MFMod.MODID + ":gui/backpack" + this.tier);
    
	public GuiBackpack(InventoryPlayer inventory, ItemStack held) {
        super(new ContainerBackpack(inventory,held));
        this.tier = ((ItemBackpack)held.getItem()).tier;;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f,int i, int j){
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.renderEngine.bindTexture(texture);
        int var5 = (width - xSize)/2;
        int var6 = (height - ySize)/2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
    }

    @Override
    public void drawGuiContainerForegroundLayer(int i, int j)
    {
        String title = (this.tier == 1 ? "Steel" : this.tier == 2 ? "Beryllium Bronze" : "Xyrenium") + " Backpack";
        this.fontRendererObj.drawString(title, this.xSize / 2 - (this.fontRendererObj.getStringWidth(title) / 2), 6, 4210752);
    }
}