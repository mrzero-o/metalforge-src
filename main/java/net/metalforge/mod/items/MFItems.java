package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.registry.GameRegistry;

public class MFItems extends MFItemsBase{
	
	public static void init(){
		registerItems();
	}
	
	public static void registerItems(){
		
		forgerBasic = register(new ItemForger(36, 1).setUnlocalizedName("forgerBasic"));
		forgerAdvanced = register(new ItemForger(124, 2).setUnlocalizedName("forgerAdvanced"));
		forgerElite = register(new ItemForger(4, 3).setUnlocalizedName("forgerElite"));
		
		DrinkingHelmet = register(new ItemDrinkingHelmet().setUnlocalizedName("DrinkingHelmet"));
		SpringBoots = register(new ItemArmorMF(MFMaterials.AMSteel, 3, "springboots").setUnlocalizedName("SpringBoots"));
		//SwappersStaff = register(new ItemSwappersStaff().setUnlocalizedName("SwappersStaff"));
		//LightningSpawner = register(new ItemLightningSpawner().setUnlocalizedName("LightningSpawner"));
		Tongs = register(new ItemMF().setFull3D().setMaxStackSize(1).setUnlocalizedName("Tongs"));
		GrapplingHook = register(new ItemScalingHook(0.75F, 312).setUnlocalizedName("GrapplingHook"));
		//BerylliumScalingHook = register(new ItemScalingHook(0.925F, 832).setUnlocalizedName("BerylliumScalingHook"));
		Armorslayer = register(new ItemArmorslayer().setUnlocalizedName("Armorslayer"));
		//RedButton = register(new ItemRedButton().setUnlocalizedName("RedButton"));
		SteelBow = register(new ItemBowMF(536, 1, 1).setUnlocalizedName("SteelBow"));
		BerylliumBow = register(new ItemBowMF(748, 2, 2).setUnlocalizedName("BerylliumBow"));
		XyreniumBow = register(new ItemBowMF(1224, 2, 3).setUnlocalizedName("XyreniumBow"));
		
		gearSteel = register(new ItemMF().setUnlocalizedName("gearSteel"));
		gearBBronze = register(new ItemMF().setUnlocalizedName("gearBBronze"));
		MetalBall = register(new ItemMetalBall().setUnlocalizedName("MetalBall"));

		T1RockShovel = register(new ItemRockShovel(1).setUnlocalizedName("T1RockShovel"));
		T2RockShovel = register(new ItemRockShovel(2).setUnlocalizedName("T2RockShovel"));
		
		brownCoal = register(new ItemMF().setUnlocalizedName("brownCoal"));
		dustCoal = register(new ItemMF().setUnlocalizedName("dustCoal"));
		Spring = register(new ItemMF().setUnlocalizedName("Spring"));
		blackwoodStick = register(new ItemMF().setUnlocalizedName("blackwoodStick").setFull3D());
		/*Technology
		NormalTNTVest = register(new ItemArmorMF.TNTVest("normaltnt", 6.0F).setUnlocalizedName("NormalTNTVest"));
		GreaterTNTVest = register(new ItemArmorMF.TNTVest("greatertnt", 12.0F).setUnlocalizedName("GreaterTNTVest"));
		InsaneTNTVest = register(new ItemArmorMF.TNTVest("insanetnt", 18.0F).setUnlocalizedName("InsaneTNTVest"));
		FlyingMachine = register(new ItemFlyingMachine().setUnlocalizedName("FlyingMachine"));
		ItemGun = register(new ItemItemGun().setUnlocalizedName("ItemGun"));*/
		//Magic
		/*ManaFlask = register(new ItemManaStorage(320).setUnlocalizedName("ManaFlask"));
		SearersSceptre = register(new ItemWand(EnumWandType.BLAZE).setUnlocalizedName("SearersSceptre"));
		RodRain = register(new ItemWand(EnumWandType.RAIN).setUnlocalizedName("RodRain"));
		RodRemoving = register(new ItemWand(EnumWandType.REMOVING).setUnlocalizedName("RodRemoving"));
		RodRecovering = register(new ItemWand(EnumWandType.REGEN).setUnlocalizedName("RodRecovering"));*/
		//Materials
		ingotCopper = register(new ItemMF().setUnlocalizedName("ingotCopper"));
		ingotTungsten = register(new ItemMF().setUnlocalizedName("ingotTungsten"));
		ingotSteel = register(new ItemMF().setUnlocalizedName("ingotSteel"));
		ingotBerylBronze = register(new ItemMF().setUnlocalizedName("ingotBerylBronze"));
		ingotXyrenium = register(new ItemMF().setUnlocalizedName("ingotXyrenium"));
		ingotDragoonyte = register(new ItemMF().setUnlocalizedName("ingotDragoonyte"));
		
		hotIron = register(new ItemHot(Items.iron_ingot).setUnlocalizedName("hotIron"));
		hotGold = register(new ItemHot(Items.gold_ingot).setUnlocalizedName("hotGold"));
		hotCopper = register(new ItemHot(ingotCopper).setUnlocalizedName("hotCopper"));
		hotTungsten = register(new ItemHot(ingotTungsten).setUnlocalizedName("hotTungsten"));
		hotSteel = register(new ItemHot(ingotSteel).setUnlocalizedName("hotSteel"));
		hotBerylBronze = register(new ItemHot(ingotBerylBronze).setUnlocalizedName("hotBerylBronze"));
		hotXyrenium = register(new ItemHot(ingotXyrenium).setUnlocalizedName("hotXyrenium"));
		hotDragoonyte = register(new ItemHot(ingotDragoonyte).setUnlocalizedName("hotDragoonyte"));
		
		/*alloySteel = register(new ItemAlloy(1, hotSteel).setUnlocalizedName("alloySteel"));
		alloyBerylBronze = register(new ItemAlloy(2, hotBerylBronze).setUnlocalizedName("alloyBerylBronze"));
		alloyXyrenium = register(new ItemAlloy(3, hotXyrenium).setUnlocalizedName("alloyXyrenium"));
		alloyDragoonyte = register(new ItemAlloy(4, hotDragoonyte).setUnlocalizedName("alloyDragoonyte"));*/

		dustIron = register(new ItemMF().setUnlocalizedName("dustIron"));
		dustGold = register(new ItemMF().setUnlocalizedName("dustGold"));
		dustCopper = register(new ItemMF().setUnlocalizedName("dustCopper"));
		dustTungsten = register(new ItemMF().setUnlocalizedName("dustTungsten"));
		
		coalCoke = register(new ItemMF().setUnlocalizedName("coalCoke"));
		biofertilizer = register(new ItemFertilizer().setUnlocalizedName("biofertilizer"));
		xyrenite = register(new ItemMF().setMaxStackSize(16).setUnlocalizedName("xyrenite"));
		xyreniteX = register(new ItemMF().setMaxStackSize(16).setUnlocalizedName("xyreniteX"));
		
		berylliumRaw = register(new ItemMF().setUnlocalizedName("berylliumRaw"));
		
		nuggetIron = register(new ItemMF().setUnlocalizedName("nuggetIron"));
		nuggetCopper = register(new ItemMF().setUnlocalizedName("nuggetCopper"));
		nuggetTungsten = register(new ItemMF().setUnlocalizedName("nuggetTungsten"));
		nuggetSteel = register(new ItemMF().setUnlocalizedName("nuggetSteel"));
		nuggetBerylBronze = register(new ItemMF().setUnlocalizedName("nuggetBerylBronze"));
		nuggetXyrenium = register(new ItemMF().setUnlocalizedName("nuggetXyrenium"));
		nuggetDragoonyte = register(new ItemMF().setUnlocalizedName("nuggetDragoonyte"));
		
		bioplantmass = register(new ItemFoodMF(3, 0.45F,false).setPotionEffect(Potion.confusion.getId(), 5, 4, 1.0F).setUnlocalizedName("bioplantmass"));
		
		SteelSword = register(new ItemSwordMF(MFMaterials.TMSteel).setUnlocalizedName("SteelSword"));
		SteelPickaxe = register(new ItemPickaxeMF(MFMaterials.TMSteel).setUnlocalizedName("SteelPickaxe"));
		SteelAxe = register(new ItemAxeMF(MFMaterials.TMSteel).setUnlocalizedName("SteelAxe"));
		SteelSpade = register(new ItemSpadeMF(MFMaterials.TMSteel).setUnlocalizedName("SteelSpade"));
		SteelHoe = register(new ItemHoeMF(MFMaterials.TMSteel).setUnlocalizedName("SteelHoe"));
		SteelDagger = register(new ItemDagger(MFMaterials.TMSteel).setUnlocalizedName("SteelDagger"));
		SteelSkogAxe = register(new ItemSkogAxe(MFMaterials.TMSteel).setUnlocalizedName("SteelSkogAxe"));
		BBSword = register(new ItemSwordMF(MFMaterials.TMBBronze).setUnlocalizedName("BBSword"));
		BBPickaxe = register(new ItemPickaxeMF(MFMaterials.TMBBronze).setUnlocalizedName("BBPickaxe"));
		BBAxe = register(new ItemAxeMF(MFMaterials.TMBBronze).setUnlocalizedName("BBAxe"));
		BBSpade = register(new ItemSpadeMF(MFMaterials.TMBBronze).setUnlocalizedName("BBSpade"));
		BBHoe = register(new ItemHoeMF(MFMaterials.TMBBronze).setUnlocalizedName("BBHoe"));
		BBDagger = register(new ItemDagger(MFMaterials.TMBBronze).setUnlocalizedName("BBDagger"));
		BBSkogAxe = register(new ItemSkogAxe(MFMaterials.TMBBronze).setUnlocalizedName("BBSkogAxe"));
		XyreniumSword = register(new ItemSwordMF(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumSword"));
		XyreniumPickaxe = register(new ItemPickaxeMF(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumPickaxe"));
		XyreniumAxe = register(new ItemAxeMF(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumAxe"));
		XyreniumSpade = register(new ItemSpadeMF(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumSpade"));
		XyreniumHoe = register(new ItemHoeMF(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumHoe"));
		XyreniumDagger = register(new ItemDagger(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumDagger"));
		XyreniumSkogAxe = register(new ItemSkogAxe(MFMaterials.TMXyrenium).setUnlocalizedName("XyreniumSkogAxe"));
		DragoonLance = register(new ItemLance(MFMaterials.TMDragoonyte).setUnlocalizedName("DragoonLance"));
		DragoonHammer = register(new ItemHammer(MFMaterials.TMDragoonyte).setUnlocalizedName("DragoonHammer"));
		DragoonBlade = register(new ItemSwordMF(MFMaterials.TMDragoonyte).setUnlocalizedName("DragoonBlade"));
		
		SteelHelmet = register(new ItemArmorMF(MFMaterials.AMSteel, 0, "steel").setUnlocalizedName("SteelHelmet"));
		SteelChestplate = register(new ItemArmorMF(MFMaterials.AMSteel, 1, "steel").setUnlocalizedName("SteelChestplate"));
		SteelLeggings = register(new ItemArmorMF(MFMaterials.AMSteel, 2, "steel").setUnlocalizedName("SteelLeggings"));
		SteelBoots = register(new ItemArmorMF(MFMaterials.AMSteel, 3, "steel").setUnlocalizedName("SteelBoots"));
		BBHelmet = register(new ItemArmorMF(MFMaterials.AMBerylliumBronze, 0, "bbronze").setUnlocalizedName("BBHelmet"));
		BBChestplate = register(new ItemArmorMF(MFMaterials.AMBerylliumBronze, 1, "bbronze").setUnlocalizedName("BBChestplate"));
		BBLeggings = register(new ItemArmorMF(MFMaterials.AMBerylliumBronze, 2, "bbronze").setUnlocalizedName("BBLeggings"));
		BBBoots = register(new ItemArmorMF(MFMaterials.AMBerylliumBronze, 3, "bbronze").setUnlocalizedName("BBBoots"));
		XyreniumHelmet = register(new ItemArmorMF(MFMaterials.AMXyrenium, 0, "xyrenium").setUnlocalizedName("XyreniumHelmet"));
		XyreniumChestplate = register(new ItemArmorMF(MFMaterials.AMXyrenium, 1, "xyrenium").setUnlocalizedName("XyreniumChestplate"));
		XyreniumLeggings = register(new ItemArmorMF(MFMaterials.AMXyrenium, 2, "xyrenium").setUnlocalizedName("XyreniumLeggings"));
		XyreniumBoots = register(new ItemArmorMF(MFMaterials.AMXyrenium, 3, "xyrenium").setUnlocalizedName("XyreniumBoots"));
		DragoonHelmet = register(new ItemArmorDragoon(0).setUnlocalizedName("DragoonHelmet"));
		DragoonChestplate = register(new ItemArmorDragoon(1).setUnlocalizedName("DragoonChestplate"));
		DragoonLeggings = register(new ItemArmorDragoon(2).setUnlocalizedName("DragoonLeggings"));
		DragoonBoots = register(new ItemArmorDragoon(3).setUnlocalizedName("DragoonBoots"));
		
		//TOP SECRET
		if(MFConfiguration.addStructureSpawner){
			StructureSpawner = register(new ItemStructureSpawner().setUnlocalizedName("StructureSpawner"));
		}
	}
	
	public static Item register(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		return item;
	}
	
	
}
