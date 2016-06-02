package net.metalforge.mod;

import java.util.Iterator;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.entity.EntityMetalBall;
import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.models.ModelAnchor;
import net.metalforge.mod.models.ModelAnvil;
import net.metalforge.mod.models.ModelCarbonDiablo;
import net.metalforge.mod.models.ModelDragoonBodyArmor;
import net.metalforge.mod.models.ModelDragoonHelmet;
import net.metalforge.mod.models.ModelDrinkingHelmet;
import net.metalforge.mod.models.ModelFlyingMachine;
import net.metalforge.mod.models.ModelLamp;
import net.metalforge.mod.render.RenderBig;
import net.metalforge.mod.render.RenderBig.EnumSize;
import net.metalforge.mod.render.RenderBlock;
import net.metalforge.mod.render.RenderBlockAsItem;
import net.metalforge.mod.render.RenderBow;
import net.metalforge.mod.render.RenderInventoryItem;
import net.metalforge.mod.tileentity.TileEntityCarbonDiablo;
import net.metalforge.mod.tileentity.TileEntityLamp;
import net.metalforge.mod.tileentity.TileEntityMetalworkStation;
import net.metalforge.mod.tileentity.TileEntityWorldAnchor;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import codechicken.nei.api.API;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenderThings(){
		//Blackwood Lamp
		TileEntitySpecialRenderer bwlamp = new RenderBlock(new ModelLamp(), getResourceLocation("lamp"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLamp.class, bwlamp);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MFBlocks.LampOff), new RenderBlockAsItem(bwlamp, new TileEntityLamp()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MFBlocks.LampActive), new RenderBlockAsItem(bwlamp, new TileEntityLamp()));
		//Heavy World Anchor
		TileEntitySpecialRenderer wanchor = new RenderBlock(new ModelAnchor(), getResourceLocation("anchor"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorldAnchor.class, wanchor);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MFBlocks.WorldAnchor), new RenderBlockAsItem(wanchor, new TileEntityWorldAnchor()));		
		//Metalwork Station
		TileEntitySpecialRenderer mwstation = new RenderBlock(new ModelAnvil(), getResourceLocation("anvil"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMetalworkStation.class, mwstation);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MFBlocks.MetalworkStation), new RenderBlockAsItem(mwstation, new TileEntityMetalworkStation()));
		//Carbon Diablo
		TileEntitySpecialRenderer cdiablo = new RenderBlock(new ModelCarbonDiablo(), getResourceLocation("carbondiablo"));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCarbonDiablo.class, cdiablo);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MFBlocks.CarbonDiablo), new RenderBlockAsItem(cdiablo, new TileEntityCarbonDiablo()));
		//Entity renderers
		RenderingRegistry.registerEntityRenderingHandler(EntityMetalBall.class, new RenderSnowball(MFItems.MetalBall));
		//Item renderers
		MinecraftForgeClient.registerItemRenderer(MFItems.FlyingMachine, new RenderInventoryItem());
	}
	
	public void renderItems(){
		MinecraftForgeClient.registerItemRenderer(MFItems.SteelBow, new RenderBow());
		MinecraftForgeClient.registerItemRenderer(MFItems.BerylliumBow, new RenderBow());
		MinecraftForgeClient.registerItemRenderer(MFItems.XyreniumBow, new RenderBow());
		MinecraftForgeClient.registerItemRenderer(MFItems.DragoonLance, new RenderBig(EnumSize.BIG));
		MinecraftForgeClient.registerItemRenderer(MFItems.DragoonHammer, new RenderBig(EnumSize.BIG));
		MinecraftForgeClient.registerItemRenderer(MFItems.DragoonBlade, new RenderBig(EnumSize.BIG, true));
		MinecraftForgeClient.registerItemRenderer(MFItems.Armorslayer, new RenderBig(EnumSize.BIG, true));
	}
	
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	public static ResourceLocation getResourceLocation(String image){
		return new ResourceLocation(MFMod.MODID + ":textures/models/" + image + ".png");
	}
	
	public ModelFlyingMachine getFlyingMachineModel(){
		return new ModelFlyingMachine();
	}
	
	public ModelDragoonBodyArmor getDragoonBodyArmorModel(){
		return new ModelDragoonBodyArmor();
	}
	
	public ModelDragoonHelmet getDragoonHelmetModel(){
		return new ModelDragoonHelmet();
	}
	
	public ModelDrinkingHelmet getDrinkingHelmetModel(){
		return new ModelDrinkingHelmet();
	}
	
	public void hideItemInNEI(ItemStack itemstack) {
		Iterator mods = Loader.instance().getActiveModList().iterator();
        ModContainer modContainer;
        while(mods.hasNext()) {
            modContainer = (ModContainer) mods.next();
            if(modContainer.getModId().equalsIgnoreCase("NotEnoughItems")) {
                API.hideItem(itemstack);
            }
        }
	}
}