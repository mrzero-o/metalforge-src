package net.metalforge.mod;

import net.metalforge.mod.entity.EntityMetalBall;
import net.metalforge.mod.inventory.MFGuiHandler;
import net.metalforge.mod.models.ModelDragoonBodyArmor;
import net.metalforge.mod.models.ModelDragoonHelmet;
import net.metalforge.mod.models.ModelDrinkingHelmet;
import net.metalforge.mod.models.ModelFlyingMachine;
import net.metalforge.mod.models.ModelMetalGear;
import net.metalforge.mod.tileentity.TileEntityCarbonDiablo;
import net.metalforge.mod.tileentity.TileEntityCPMiner;
import net.metalforge.mod.tileentity.TileEntityDoorSecure;
import net.metalforge.mod.tileentity.TileEntityLamp;
import net.metalforge.mod.tileentity.TileEntityMetalworkStation;
import net.metalforge.mod.tileentity.TileEntityOven;
import net.metalforge.mod.tileentity.TileEntityPurifier;
import net.metalforge.mod.tileentity.TileEntitySmelter;
import net.metalforge.mod.tileentity.TileEntityWorldAnchor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void init(){
		registerRenderThings();
		registerNetworkStuff();
		registerTileEntities();
		registerEntities();
	}
	
	public void registerRenderThings(){}
	
	public int addArmor (String armor){
		return 0;
	}
	
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MFMod.INSTANCE, new MFGuiHandler());
	}
	
	public void registerTileEntities(){

		GameRegistry.registerTileEntity(TileEntityOven.class, "HeatTreatingOven");
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "Smelter");
		GameRegistry.registerTileEntity(TileEntityPurifier.class, "MineralPurifier");
		GameRegistry.registerTileEntity(TileEntityWorldAnchor.class, "HeavyWorldAnchor");
		GameRegistry.registerTileEntity(TileEntityMetalworkStation.class, "MetalworkStation");
		GameRegistry.registerTileEntity(TileEntityCarbonDiablo.class, "CarbonDiablo");
		//GameRegistry.registerTileEntity(TileEntityCPMiner.class, "CPMiner");
		GameRegistry.registerTileEntity(TileEntityLamp.class, "BlackwoodLamp");
	}
	
	public void renderItems(){}
	
	public void registerEntities(){
		EntityRegistry.registerModEntity(EntityMetalBall.class, "Heavy Orb", findId(), MFMod.INSTANCE, 72, 8, true);
	}
	
	private int findId(){
		return EntityRegistry.findGlobalUniqueEntityId();
	}
	
	public ModelMetalGear getMetalGearModel(int id){
		return null;
	}
	
	public ModelFlyingMachine getFlyingMachineModel(){
		return null;
	}
	
	public ModelDragoonBodyArmor getDragoonBodyArmorModel(){
		return null;
	}
	
	public ModelDragoonHelmet getDragoonHelmetModel(){
		return null;
	}
	
	public ModelDrinkingHelmet getDrinkingHelmetModel(){
		return null;
	}
	
	public void hideItemInNEI(ItemStack itemstack){}

}
