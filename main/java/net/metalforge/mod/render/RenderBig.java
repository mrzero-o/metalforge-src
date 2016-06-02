package net.metalforge.mod.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderBig implements IItemRenderer {
	
	private EnumSize size;
	private float offset;

	public RenderBig(EnumSize size){
		this(size, false);
	}
	
	public RenderBig(EnumSize size, boolean fixed){
		this.size = size;
		if(fixed){
			this.offset = 0.195F;
		}
	}
	
    private RenderItem itemRenderer;

    @Override
    public boolean handleRenderType(ItemStack itemstack, ItemRenderType type) {
    	return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemstack, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {

        if(itemRenderer == null) itemRenderer = new RenderItem();
        
        GL11.glPushMatrix();

        if(type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            IIcon icon = itemstack.getIconIndex();
            if(type == ItemRenderType.EQUIPPED){
            	float trans = (this.size == EnumSize.BIG ? -0.25F : (this.size == EnumSize.HUGE ? -0.5F : 0.0F));
            	float scale = this.size == EnumSize.BIG ? 1.5F : (this.size == EnumSize.HUGE ? 2.0F : 1.0F);
                GL11.glTranslatef(trans - offset, trans + offset, 0);
                GL11.glScalef(scale, scale, 1.0F);
            }
            Tessellator tessellator = Tessellator.instance;
            ItemRenderer.renderItemIn2D(tessellator,
                    icon.getMaxU(),
                    icon.getMinV(),
                    icon.getMinU(),
                    icon.getMaxV(),
                    icon.getIconWidth(),
                    icon.getIconHeight(), 1F / 16F);
            if(itemstack.hasEffect(0)) itemRenderer.renderEffect(Minecraft.getMinecraft().getTextureManager(), 0, 0);
            
        }else if(type == ItemRenderType.INVENTORY) {

            GL11.glColor4f(1F, 1F, 1F, 1F);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            itemRenderer.renderIcon(0, 0, itemstack.getIconIndex(), 16, 16);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDisable(GL11.GL_BLEND);
            if(itemstack.hasEffect(0)) itemRenderer.renderEffect(Minecraft.getMinecraft().getTextureManager(), 0, 0);
        }
        GL11.glPopMatrix();
    }
    
    public enum EnumSize{
    	BIG, HUGE;
    }
}