package net.metalforge.mod.entity;

import net.metalforge.mod.items.MFItems;
import net.metalforge.mod.random.MFConfiguration;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityMetalBall extends EntityThrowable
{
	public EntityMetalBall(World world)
    {
        super(world);
    }

    public EntityMetalBall(World world, EntityLivingBase living)
    {
        super(world, living);
    }

    public EntityMetalBall(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }
    
    protected void onImpact(MovingObjectPosition position){
    	
        if (position.entityHit != null && position.entityHit instanceof EntityLivingBase){
        	EntityLivingBase living = (EntityLivingBase)position.entityHit;
        	living.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), MFConfiguration.heavyOrbDamage);
            if (!this.worldObj.isRemote) this.setDead();
        }

        for (int i = 0; i < 10; ++i)
        {
            this.worldObj.spawnParticle("townaura", position.hitVec.xCoord, position.hitVec.yCoord, position.hitVec.zCoord, 0, 0, 0);
        }
        
        worldObj.playSoundAtEntity(this, "dig.stone", 0.5F, 1.0F);
    }
}