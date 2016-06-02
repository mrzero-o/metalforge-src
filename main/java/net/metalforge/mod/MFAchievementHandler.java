package net.metalforge.mod;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.MFItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class MFAchievementHandler {
	
	@SubscribeEvent
	public void craftEvent(PlayerEvent.ItemCraftedEvent event){
		Item item = event.crafting.getItem();
		EntityPlayer player = event.player;
		if(item == MFItems.hotBerylBronze) player.addStat(MFAchievements.alloyBerylBronze, 1);
		else if(item == MFItems.hotSteel) player.addStat(MFAchievements.alloySteel, 1);
		else if(item == MFItems.hotXyrenium) player.addStat(MFAchievements.alloyXyrenium, 1);
		else if(item == Item.getItemFromBlock(Blocks.cauldron)) player.addStat(MFAchievements.craftCauldron, 1);
		else if(item == Item.getItemFromBlock(MFBlocks.MetalworkStation)) player.addStat(MFAchievements.craftMetalworkStation, 1);
		else if(item == Item.getItemFromBlock(MFBlocks.HTOvenIdle)) player.addStat(MFAchievements.craftHTOven, 1);
		else if(item == Item.getItemFromBlock(MFBlocks.PurifierIdle)) player.addStat(MFAchievements.craftPurifier, 1);
		else if(item == Item.getItemFromBlock(MFBlocks.HTSmelterIdle)) player.addStat(MFAchievements.craftHTSmelter, 1);
		else if(item == MFItems.BerylliumBow) player.addStat(MFAchievements.makeBerylliumBow, 1);
		else if(item == MFItems.SteelBow) player.addStat(MFAchievements.makeSteelBow, 1);
		else if(item == MFItems.Tongs) player.addStat(MFAchievements.makeTongs, 1);
	}
	
	@SubscribeEvent
	public void smeltEvent(PlayerEvent.ItemSmeltedEvent event){
		Item item = event.smelting.getItem();
		EntityPlayer player = event.player;
		if(item == MFItems.ingotCopper) player.addStat(MFAchievements.getCopper, 1);
		else if(item == MFItems.coalCoke) player.addStat(MFAchievements.getCoalCoke, 1);
		else if(item == MFItems.xyrenite) player.addStat(MFAchievements.getXyrenite, 1);
	}
	
	@SubscribeEvent
	public void pickupEvent(PlayerEvent.ItemPickupEvent event){
		Item item = event.pickedUp.getEntityItem().getItem();
		EntityPlayer player = event.player;
		if(item == MFItems.xyrenite) player.addStat(MFAchievements.getXyrenite, 1);
	}
}
