package net.metalforge.mod;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.compat.Compatibility;
import net.metalforge.mod.crafting.MFCrafting;
import net.metalforge.mod.crafting.MFOreDictionary;
import net.metalforge.mod.crafting.MFSmelting;
import net.metalforge.mod.inventory.MFGuiHandler;
import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.minetweaker.MetalTweaker;
import net.metalforge.mod.random.MFConfiguration;
import net.metalforge.mod.random.MFEventHandler;
import net.metalforge.mod.tileentity.TileEntityWorldAnchorCLCB;
import net.metalforge.mod.worldgen.MFBiomes;
import net.metalforge.mod.worldgen.MFWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import sun.rmi.log.LogHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = MFMod.MODID, version = MFMod.VERSION, name = MFMod.NAME, useMetadata = true)
public class MFMod {
	
	public static final String MODID = "metalforge";
	public static final String VERSION = "1.0.0";
	public static final String NAME = "Metalforge";
	public static final String SIGNATURE = EnumChatFormatting.WHITE + "[" + NAME + "]";
	
	@Instance(value = MODID)
	public static MFMod INSTANCE;
	
	@SidedProxy(clientSide = "net.metalforge.mod.ClientProxy", serverSide = "net.metalforge.mod.CommonProxy")
	public static CommonProxy CommonProxy;
	
	public static CreativeTabs metalforgeTab = new CreativeTabs("Metalforge"){
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return MFItems.forgerAdvanced;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent){

		MFConfiguration.load(preEvent.getSuggestedConfigurationFile());
		
		INSTANCE = this;
		
		MFBlocks.init();
		MFItems.init();
		MFOreDictionary.init();
		MFBiomes.init();
		
		GameRegistry.registerWorldGenerator(new MFWorldGen(), 0);
		GameRegistry.registerFuelHandler(new MFFuelHandler());
		
		MinecraftForge.EVENT_BUS.register(new MFEventHandler());
		
		CommonProxy.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		FMLCommonHandler.instance().bus().register(new MFAchievementHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(MFMod.INSTANCE, new MFGuiHandler());
		
		MFAchievements.init();
		MFCrafting.init();
		MFSmelting.init();
		CommonProxy.renderItems();
		
		Compatibility.loadInit(event);
		
		//Registering minetweaker addon
		if(Loader.isModLoaded("MineTweaker3")){
			try{
				MetalTweaker.initTweaks();
			}catch(Exception e){  }
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent){
    	ForgeChunkManager.setForcedChunkLoadingCallback(MFMod.INSTANCE, new TileEntityWorldAnchorCLCB());
    	
		Compatibility.loadPostInit(postEvent);
	}
	
	public class MFFuelHandler implements IFuelHandler{
		
		public int getBurnTime(ItemStack fuel) {
			return getItemBurnTime(fuel.getItem());
		}
		
		public int getItemBurnTime(Item fuel){
			if(fuel == MFItems.brownCoal) return 400;
			if(fuel == MFItems.blackwoodStick) return 150;
			if(fuel == MFItems.coalCoke) return MFConfiguration.coalCokeBurnTime;
			if(fuel == Item.getItemFromBlock(MFBlocks.cokeBlock)) return this.getItemBurnTime(MFItems.coalCoke) * 10;
			
			return 0;
		}
	}
}
