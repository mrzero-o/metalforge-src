package net.metalforge.mod.items;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSkogAxe extends ItemAxeMF{

	private float damageVsEntity;
	
	public ItemSkogAxe(ToolMaterial mat) {
		super(mat);
		this.damageVsEntity = mat.getDamageVsEntity();
	}
	
	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase living)
    {
		if(!living.isSneaking() && isLog(block)) killLogs(living, world, x, y, z);
		else super.onBlockDestroyed(itemstack, world, block, x, y, z, living);
        return false;
    }
	
	public boolean isLog(Block block){
		if(block.getMaterial() == Material.wood){
			if(block instanceof BlockRotatedPillar && block.stepSound == Block.soundTypeWood){
				return true;
			}
		}return false;
	}
	
    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return super.func_150893_a(p_150893_1_, p_150893_2_) == this.efficiencyOnProperMaterial ? this.efficiencyOnProperMaterial / 2 : super.func_150893_a(p_150893_1_, p_150893_2_);
    }
	
	public void killLogs(EntityLivingBase living, World world, int x, int y, int z){
		if(living instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)living;
			ItemStack itemstack = player.getCurrentEquippedItem();
			if(itemstack != null){
				for(int a = x - 2; a < x + 2; a++){
					for(int b = y; b < y + 2; b++){
						for(int c = z - 2; c < z + 2; c++){
							if(isLog(world.getBlock(a, b, c))){
								int meta = world.getBlockMetadata(a, b, c);
								Block block = world.getBlock(a, b, c);
								ItemStack drop = new ItemStack(block, block.quantityDropped(world.rand), block.damageDropped(meta));
								EntityItem entityitem = new EntityItem(world, a + 0.5F, b + 0.5F, c + 0.5F, drop);
								world.setBlockToAir(a, b, c);
								if(!world.isRemote) world.spawnEntityInWorld(entityitem);
								itemstack.damageItem(1, player);
								killLogs(player, world, a, b, c);
		}}}}}}
	}
	
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        String key = SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName();
        multimap.removeAll(key);
        multimap.put(key, new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
}
