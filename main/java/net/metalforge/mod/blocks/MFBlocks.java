package net.metalforge.mod.blocks;

import net.metalforge.mod.items.blocks.ItemBlockBeryls;
import net.metalforge.mod.items.blocks.ItemBlockMagnetite;
import net.metalforge.mod.items.blocks.ItemBlockOres;
import net.metalforge.mod.items.blocks.ItemBlockSolidBlocks;
import net.metalforge.mod.items.blocks.ItemBlockSpringPad;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class MFBlocks extends MFBlocksBase{
	
	public static void init(){
		registerBlocks();
	}
	
	public static void registerBlocks(){
		
		oreAll = register(new BlockOres().setBlockName("oreAll"), ItemBlockOres.class);
		metalBlockAll = register(new BlockSolidBlocks().setBlockName("metalBlockAll"), ItemBlockSolidBlocks.class);
		cokeBlock = register(new BlockMF(Material.rock, 2.75F).setBlockName("cokeBlock"));
		berylAll = register(new BlockBeryls().setBlockName("berylAll"), ItemBlockBeryls.class);
		magnetiteAll = register(new BlockMagnetite().setBlockName("magnetiteAll"), ItemBlockMagnetite.class);

		HeatCoil = register(new BlockCoil().setBlockName("HeatCoil"));
		//PressureCoil = register(new BlockCoil().setBlockName("PressureCoil"));
		HTOvenActive = register(new BlockHTOven(true, 1).setBlockName("HTOvenActive").setLightLevel(0.9F));
		HTOvenIdle = register(new BlockHTOven(false, 1).setBlockName("HTOvenIdle"));
		HTSmelterActive = register(new BlockHTSmelter(true, 1).setBlockName("HTSmelterActive").setLightLevel(0.9F));
		HTSmelterIdle = register(new BlockHTSmelter(false, 1).setBlockName("HTSmelterIdle"));
		PurifierActive = register(new BlockPurifier(true, 1).setBlockName("PurifierActive").setLightLevel(0.9F));
		PurifierIdle = register(new BlockPurifier(false, 1).setBlockName("PurifierIdle"));
		MetalworkStation = register(new BlockMetalworkStation().setBlockName("MetalworkStation"));
		
		//CPMiner = register(new BlockCPMiner().setBlockName("CPMiner"));
		WorldAnchor = register(new BlockWorldAnchor()).setBlockName("WorldAnchor");
		blastWall = register(new BlockMF(Material.iron, 3.0F).setStepSound(Block.soundTypeMetal).setBlockName("blastWall").setResistance(60000.0F));
		CarbonDiablo = register(new BlockCarbonDiablo().setBlockName("CarbonDiablo"));
		
		ancientGrass = register(new BlockAncientGrass().setBlockName("ancientGrass"));
		ancientSoil = register(new BlockMF(Material.ground, "shovel", 0, 0.525F).setStepSound(Block.soundTypeGravel).setBlockName("ancientSoil"));
		
		blackwoodLog = register(new BlockBlackwoodLog().setBlockName("blackwoodLog"));
		blackwoodLeaves = register(new BlockBlackwoodLeaves().setBlockName("blackwoodLeaves"));
		blackwoodSapling = register(new BlockBlackwoodSapling().setBlockName("blackwoodSapling"));
		blackwoodPlanks = register(new BlockMF(Material.wood, "axe", 0, 2.0F).setStepSound(Block.soundTypeWood).setBlockName("blackwoodPlanks"));
		blackwoodFenceGate = register(new BlockFenceGateMF(Block.soundTypeWood, 2.0F).setBlockName("blackwoodFenceGate"));
		blackwoodFence = register(new BlockFenceMF(blackwoodFenceGate, 2.0F).setBlockName("blackwoodFence"));
		blackwoodStairs = register(new BlockStairsMF(blackwoodPlanks, 2.0F).setBlockName("blackwoodStairs"));
		blackwoodSlab = register(new BlockSlabMF(false, blackwoodPlanks, 2.0F).setBlockName("blackwoodSlab"));
		blackwoodSlabDouble = register(new BlockSlabMF(true, blackwoodPlanks, 2.0F).setBlockName("blackwoodSlabDouble"));
		LampOff = register(new BlockLamp(false).setBlockName("LampOff"));
		LampActive = register(new BlockLamp(true).setBlockName("LampActive"));
		
		SpringPad = register(new BlockSpringPad().setBlockName("SpringPad"), ItemBlockSpringPad.class);
		SpringRail = register(new BlockSpringRail().setBlockName("SpringRail"));
		
		//HeatProviderActive = register(new BlockHeatProvider(true).setBlockName("HeatProviderActive").setLightLevel(0.9F));
		//HeatProviderIdle = register(new BlockHeatProvider(false).setBlockName("HeatProviderIdle"));
		//HeatPipe = register(new BlockHeatPipe().setBlockName("HeatPipe"));
		
		//CopperCake = register(new BlockMetalCake(MFItems.CopperCakeItem, 1).setBlockName("CopperCake"));
	}
	
	public static Block register(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		return block;
	}
	
	public static Block register(Block block, Class itemblock){
		GameRegistry.registerBlock(block, itemblock, block.getUnlocalizedName().substring(5));
		return block;
	}
}
