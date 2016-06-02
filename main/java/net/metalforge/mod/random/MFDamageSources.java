package net.metalforge.mod.random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class MFDamageSources {

	public static DamageSource heatcoil = new DamageSource("heatcoil").setFireDamage().setDamageBypassesArmor();
	public static DamageSource kamikaze = new DamageSource("kamikaze").setDamageBypassesArmor().setExplosion();
	public static DamageSource novaburn = new DamageSource("novaburn").setFireDamage();
	public static DamageSource toothache = new DamageSource("novaburn").setDamageBypassesArmor();
	public static DamageSource crescentflux = new DamageSource("crescentflux").setMagicDamage();
}
