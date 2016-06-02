package net.metalforge.mod.items;

import net.metalforge.mod.MFMaterials;
import net.metalforge.mod.random.Util;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemHammer extends ItemPickaxeMF{
	
	private ToolMaterial mat;

	public ItemHammer(ToolMaterial mat){
		super(mat);
		this.mat = mat;
	}

    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {
    	if(itemstack.getItem() == MFItems.NovaForce){
        	int meta = block.damageDropped(world.getBlockMetadata(x, y, z));
        	Item item = block.getItemDropped(world.getBlockMetadata(x, y, z), world.rand, EnchantmentHelper.getFortuneModifier(living));
        	int quantity = block.quantityDropped(meta, EnchantmentHelper.getFortuneModifier(living), world.rand);
        	ItemStack output = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(item, quantity, meta));
        	if(item != null && output != null){
        		Util.destroyBlock(world, x, y, z, output);
            	super.onBlockDestroyed(itemstack, world, block, x, y, z, living);
        		return false;
        	}
    	}
    	super.onBlockDestroyed(itemstack, world, block, x, y, z, living);
        return true;
    }
	
	@Override
    public float getDigSpeed(ItemStack itemstack, Block block, int meta)
    {
        return efficiencyOnProperMaterial;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return mat == MFMaterials.TMDragoonyte ? EnumRarity.epic : super.getRarity(itemstack);
    }
}
