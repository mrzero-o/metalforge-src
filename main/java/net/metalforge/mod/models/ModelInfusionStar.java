package net.metalforge.mod.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelInfusionStar extends ModelMF
{
    ModelRenderer Pillar;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Arm4;
    ModelRenderer Fattie;
    ModelRenderer CoolThing1;
    ModelRenderer CoolThing2;
  
    public ModelInfusionStar()
    {
    	textureWidth = 164;
		textureHeight = 32;
	    
	    Pillar = new ModelRenderer(this, 96, 0);
	    Pillar.addBox(0F, 0F, 0F, 8, 14, 8);
	    Pillar.setRotationPoint(-4F, 10F, -4F);
	    Pillar.setTextureSize(164, 32);
	    Pillar.mirror = true;
	    setRotation(Pillar, 0F, 0F, 0F);
	    Arm1 = new ModelRenderer(this, 88, 0);
	    Arm1.addBox(0F, 0F, 0F, 2, 19, 2);
	    Arm1.setRotationPoint(-5F, 4F, 3F);
	    Arm1.setTextureSize(164, 32);
	    Arm1.mirror = true;
	    setRotation(Arm1, 0F, 0F, 0F);
	    Arm2 = new ModelRenderer(this, 80, 0);
	    Arm2.addBox(0F, 0F, 0F, 2, 19, 2);
	    Arm2.setRotationPoint(3F, 4F, -5F);
	    Arm2.setTextureSize(164, 32);
	    Arm2.mirror = true;
	    setRotation(Arm2, 0F, 0F, 0F);
	    Arm3 = new ModelRenderer(this, 72, 0);
	    Arm3.addBox(0F, 0F, 0F, 2, 19, 2);
	    Arm3.setRotationPoint(3F, 4F, 3F);
	    Arm3.setTextureSize(164, 32);
	    Arm3.mirror = true;
	    setRotation(Arm3, 0F, 0F, 0F);
	    Arm4 = new ModelRenderer(this, 64, 0);
	    Arm4.addBox(0F, 0F, 0F, 2, 19, 2);
	    Arm4.setRotationPoint(-5F, 4F, -5F);
	    Arm4.setTextureSize(164, 32);
	    Arm4.mirror = true;
	    setRotation(Arm4, 0F, 0F, 0F);
	    Fattie = new ModelRenderer(this, 0, 0);
	    Fattie.addBox(0F, 0F, 0F, 12, 7, 12);
	    Fattie.setRotationPoint(-6F, 14F, -6F);
	    Fattie.setTextureSize(164, 32);
	    Fattie.mirror = true;
	    setRotation(Fattie, 0F, 0F, 0F);
	    CoolThing1 = new ModelRenderer(this, 0, 20);
	    CoolThing1.addBox(0F, 0F, 0F, 15, 9, 2);
	    CoolThing1.setRotationPoint(-7.5F, 13F, -1F);
	    CoolThing1.setTextureSize(164, 32);
	    CoolThing1.mirror = true;
	    setRotation(CoolThing1, 0F, 0F, 0F);
	    CoolThing2 = new ModelRenderer(this, 128, 0);
	    CoolThing2.addBox(0F, 0F, 0F, 2, 9, 15);
	    CoolThing2.setRotationPoint(-1F, 13F, -7.5F);
	    CoolThing2.setTextureSize(164, 32);
	    CoolThing2.mirror = true;
	    setRotation(CoolThing2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(f, f1, f2, f3, f4, f5);
	  Pillar.render(f5);
	  Arm1.render(f5);
	  Arm2.render(f5);
	  Arm3.render(f5);
	  Arm4.render(f5);
	  Fattie.render(f5);
	  CoolThing1.render(f5);
	  CoolThing2.render(f5);
  }
  
  public void renderModel(float f)
  {
	  Pillar.render(f);
	  Arm1.render(f);
	  Arm2.render(f);
	  Arm3.render(f);
	  Arm4.render(f);
	  Fattie.render(f);
	  CoolThing1.render(f);
	  CoolThing2.render(f);
  }

}
