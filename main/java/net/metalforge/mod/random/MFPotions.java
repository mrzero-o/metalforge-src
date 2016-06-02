package net.metalforge.mod.random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class MFPotions{
	
	public static Potion novaburn = new PotionMF(28, true, 16733440).setPotionName("potion.novaburn");
	public static Potion toothache = new PotionMF(31, true, 16733440).setPotionName("potion.toothache");
	
	public static class PotionMF extends Potion{

		public PotionMF(int id, boolean bool, int color) {
			super(id, bool, color);
		}
		
		public void performEffect(EntityLivingBase living, int amp)
	    {
			int id = this.getId();
			if(id == novaburn.getId()){
				float damage = living.isInWater() ? 0.25F : 0.5F;
				living.attackEntityFrom(MFDamageSources.novaburn, damage * (amp + 1));
				living.setFire(amp + 1);
			}if(id == toothache.getId()){
				float damage = 0.001F;
				if(living.getHealth() > living.getMaxHealth() - damage){
					living.attackEntityFrom(MFDamageSources.toothache, damage);
				}
			}
	    }
	}
}
