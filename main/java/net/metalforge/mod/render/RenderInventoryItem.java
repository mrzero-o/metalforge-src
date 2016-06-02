package net.metalforge.mod.render;

import net.metalforge.mod.MFMod;
import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.models.ModelDrinkingHelmet;
import net.metalforge.mod.models.ModelFlyingMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderInventoryItem implements IItemRenderer{

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper){
		switch(type){
		case INVENTORY: return true;
		default: break;
		}return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data){
		if(itemstack.getItem() == MFItems.FlyingMachine){
			ModelFlyingMachine model = new ModelFlyingMachine(); 
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90, 0.0F, -1.0F, 0.0F);
			GL11.glTranslatef(-0.25F, -0.325F, -0.7125F);
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(itemstack.getItem()));
			model.render(0.0825F);
		}if(itemstack.getItem() == MFItems.DrinkingHelmet){
			ModelDrinkingHelmet model = new ModelDrinkingHelmet(); 
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90, 0.0F, -1.0F, 0.0F);
			GL11.glTranslatef(-0.25F, 0.675F, -0.175F);
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(itemstack.getItem()));
			model.render(0.0825F);
		}
	}

	private ResourceLocation getTexture(Item item){
		String base = MFMod.MODID + ":textures/models/";
		ResourceLocation texture = null;
		if(item == MFItems.FlyingMachine){
			texture = new ResourceLocation(base + "flyingmachine.png");
		}if(item == MFItems.DrinkingHelmet){
			texture = new ResourceLocation(base + "drinkinghelmet.png");
		}return texture;
	}
}