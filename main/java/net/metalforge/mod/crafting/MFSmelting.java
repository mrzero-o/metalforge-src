package net.metalforge.mod.crafting;

import net.metalforge.mod.blocks.MFBlocks;
import net.metalforge.mod.items.MFItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class MFSmelting {
	
	public static void init(){
		registerFurnaceRecipes();
	}

	public static void registerFurnaceRecipes() {
		GameRegistry.addSmelting(MFItems.dustCopper, new ItemStack(MFItems.ingotCopper), 0.2F);
		GameRegistry.addSmelting(MFItems.dustTungsten, new ItemStack(MFItems.ingotTungsten), 0.7F);
		
		GameRegistry.addSmelting(MFItems.dustIron, new ItemStack(Items.iron_ingot), 0.3F);
		GameRegistry.addSmelting(MFItems.dustGold, new ItemStack(Items.gold_ingot), 0.5F);
		
		GameRegistry.addSmelting(new ItemStack(MFBlocks.oreAll, 1, 0), new ItemStack(MFItems.ingotCopper), 0.2F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.oreAll, 1, 1), new ItemStack(MFItems.ingotTungsten), 0.7F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.oreAll, 1, 2), new ItemStack(MFItems.xyrenite), 0.4F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.oreAll, 1, 3), new ItemStack(MFItems.brownCoal), 0.1F);
		GameRegistry.addSmelting(new ItemStack(MFBlocks.oreAll, 1, 4), new ItemStack(Items.coal, 2), 0.2F);

		GameRegistry.addSmelting(MFBlocks.magnetiteAll, new ItemStack(MFItems.nuggetIron), 0.5F);

		GameRegistry.addSmelting(MFBlocks.blackwoodLog, new ItemStack(Items.coal, 1, 1), 2.5F);
	}
}
