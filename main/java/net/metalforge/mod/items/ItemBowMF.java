package net.metalforge.mod.items;

import net.metalforge.mod.MFMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBowMF extends ItemBow{

    public static final String[] bowIcons = new String[] {"Pulling0", "Pulling1", "Pulling2"};
    @SideOnly(Side.CLIENT)
    public IIcon[] iconArray;
    
	public int ench;
	public int power;
	
	public ItemBowMF(int dura, int ench, int power){
		super();
		this.setMaxDamage(dura);
		this.ench = ench;
		this.power = power;
		this.setCreativeTab(MFMod.metalforgeTab);
	}

	@Override
	public int getItemEnchantability()
	{
		return this.ench;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer player, int i)
    {
        int j = this.getMaxItemUseDuration(itemstack) - i;

        ArrowLooseEvent event = new ArrowLooseEvent(player, itemstack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) return;
        
        j = event.charge;

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemstack) > 0;

        if(flag || player.inventory.hasItem(Items.arrow)){
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D) return;

            if (f > 1.0F) f = 1.0F;
            
            EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);
            
            if (f == 1.0F) entityarrow.setIsCritical(true);
            
            double k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemstack) + ((power / 3) * 2);

            if(k > 0) entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            
            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemstack) + power;

            if(l > 0) entityarrow.setKnockbackStrength(l);
            
            if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemstack) > 0) entityarrow.setFire(100);
            
            itemstack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag) entityarrow.canBePickedUp = 2;
            else player.inventory.consumeInventoryItem(Items.arrow);
            
            entityarrow.setDamage(entityarrow.getDamage() + (double)power * 0.5D + 0.5D);
            
            if(!world.isRemote) world.spawnEntityInWorld(entityarrow);
        }
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
		final String base = MFMod.MODID + ":" + this.getUnlocalizedName().substring(5);
        this.itemIcon = icon.registerIcon(base + "Standby");
        this.iconArray = new IIcon[bowIcons.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = icon.registerIcon(base + bowIcons[i]);
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (ItemStack itemstack, int renderPass, EntityPlayer player, ItemStack held, int useLeft)
    {
        if (held != null){
            int time = 72000 - useLeft;
            if (time < 8)
                return iconArray[0];
            if (time < 14)
                return iconArray[1];
            return iconArray[2];
        }
        return getIcon(itemstack, renderPass);
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int i)
    {
        return this.iconArray[i];
    }
}
