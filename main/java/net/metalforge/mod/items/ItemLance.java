package net.metalforge.mod.items;

import com.google.common.collect.Multimap;

import net.metalforge.mod.MFMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLance extends ItemSwordMF{

	private float damageVsEntity;
	private ToolMaterial mat;
	
	public ItemLance(ToolMaterial mat) {
		super(mat);
		this.mat = mat;
		this.damageVsEntity = mat.getDamageVsEntity() + 3.0F;
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(player.getDistanceSq(x + 0.5F, y + 0.5F, z + 0.5F) <= 20.0F && world.getBlock(x, y, z).getBlockHardness(world, x, y, z) > 0.0F){ 
			Vec3 vec = player.getLookVec();
			float upwards = 0.875F;
			
			player.motionY = -(vec.yCoord * upwards);
			player.motionX = -(vec.xCoord * 1.125F);
			player.motionZ = -(vec.zCoord * 1.125F);
			
			player.fallDistance = 0;
			itemstack.damageItem(1, player);
		}	
        return true;
    }
	
	/*public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
		if(player.getDistanceSq(x + 0.5F, y + 0.5F, z + 0.5F) <= 20.0F && world.getBlock(x, y, z).getBlockHardness(world, x, y, z) > 0.0F){ 
			Vec3 vec = player.getLookVec();
			float upwards = side == 0 || side == 1 ? 1.025F : 0.875F;
			player.motionY = -(vec.yCoord * upwards);
			if(side != 0 && side != 1){
				player.motionX = -(vec.xCoord * 1.125F);
				player.motionZ = -(vec.zCoord * 1.125F);
			}
			player.fallDistance = 0;
			itemstack.damageItem(1, player);
		}	
        return true;
    }*/
	
	public float func_150893_a(ItemStack itemstack, Block block)
    {
        if (block.getMaterial() == Material.wood) return 11.0F;
        else return 2.0F;
    }
	
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.none;
    }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        return itemstack;
    }
	
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        String key = SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName();
        multimap.removeAll(key);
        multimap.put(key, new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }
	
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return mat == MFMaterials.TMDragoonyte ? EnumRarity.epic : super.getRarity(itemstack);
    }
}
