package net.metalforge.mod.render;

import net.metalforge.mod.blocks.MFBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderBlockAsItem implements IItemRenderer{
		
	TileEntitySpecialRenderer render;
	private TileEntity tileentity;
		
	public RenderBlockAsItem(TileEntitySpecialRenderer render, TileEntity tileentity){
		this.tileentity = tileentity;
		this.render = render;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {
		float f = itemstack.getItem() == Item.getItemFromBlock(MFBlocks.InfusionStar) ? 0.25F : 0.0F;
		if(type == IItemRenderer.ItemRenderType.ENTITY) GL11.glTranslatef(-0.5F, f, -0.5F);
		this.render.renderTileEntityAt(this.tileentity, 0.0D, 0.0D, 0.0D, 0.0F);
	}
}