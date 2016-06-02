package net.metalforge.mod.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAnchor extends ModelMF
{
  //fields
    ModelRenderer Cross1;
    ModelRenderer Cross2;
    ModelRenderer Pillar;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    ModelRenderer Spike4;
    ModelRenderer BigKnob;
  
  public ModelAnchor()
  {
    textureWidth = 64;
    textureHeight = 36;
    
      Cross1 = new ModelRenderer(this, 32, 0);
      Cross1.addBox(0F, 0F, 0F, 12, 4, 4);
      Cross1.setRotationPoint(-6F, 20F, -2F);
      Cross1.setTextureSize(64, 36);
      Cross1.mirror = true;
      setRotation(Cross1, 0F, 0F, 0F);
      Cross2 = new ModelRenderer(this, 32, 8);
      Cross2.addBox(0F, 0F, 0F, 4, 4, 12);
      Cross2.setRotationPoint(-2F, 20F, -6F);
      Cross2.setTextureSize(64, 36);
      Cross2.mirror = true;
      setRotation(Cross2, 0F, 0F, 0F);
      Pillar = new ModelRenderer(this, 16, 14);
      Pillar.addBox(0F, 0F, 0F, 4, 6, 4);
      Pillar.setRotationPoint(-2F, 14F, -2F);
      Pillar.setTextureSize(64, 36);
      Pillar.mirror = true;
      setRotation(Pillar, 0F, 0F, 0F);
      Spike1 = new ModelRenderer(this, 0, 14);
      Spike1.addBox(-4F, -6F, -2F, 4, 6, 4);
      Spike1.setRotationPoint(6F, 24F, 0F);
      Spike1.setTextureSize(64, 36);
      Spike1.mirror = true;
      setRotation(Spike1, 0F, 0F, 0.78539821875F);
      Spike2 = new ModelRenderer(this, 0, 4);
      Spike2.addBox(-2F, -6F, 0F, 4, 6, 4);
      Spike2.setRotationPoint(0F, 24F, -6F);
      Spike2.setTextureSize(64, 36);
      Spike2.mirror = true;
      setRotation(Spike2, 0.78539821875F, 0F, 0F);
      Spike3 = new ModelRenderer(this, 16, 4);
      Spike3.addBox(-2F, -6F, -4F, 4, 6, 4);
      Spike3.setRotationPoint(0F, 24F, 6F);
      Spike3.setTextureSize(64, 36);
      Spike3.mirror = true;
      setRotation(Spike3, -0.78539821875F, 0F, 0F);
      Spike4 = new ModelRenderer(this, 0, 24);
      Spike4.addBox(0F, -6F, -2F, 4, 6, 4);
      Spike4.setRotationPoint(-6F, 24F, 0F);
      Spike4.setTextureSize(64, 36);
      Spike4.mirror = true;
      setRotation(Spike4, 0F, 0F, -0.78539821875F);
      BigKnob = new ModelRenderer(this, 40, 24);
      BigKnob.addBox(0F, 0F, 0F, 6, 6, 6);
      BigKnob.setRotationPoint(-3F, 8F, -3F);
      BigKnob.setTextureSize(64, 36);
      BigKnob.mirror = true;
      setRotation(BigKnob, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Cross1.render(f5);
    Cross2.render(f5);
    Pillar.render(f5);
    Spike1.render(f5);
    Spike2.render(f5);
    Spike3.render(f5);
    Spike4.render(f5);
    BigKnob.render(f5);
  }
  
  public void renderModel(float f){
	  Cross1.render(f);
	  Cross2.render(f);
	  Pillar.render(f);
	  Spike1.render(f);
	  Spike2.render(f);
	  Spike3.render(f);
	  Spike4.render(f);
	  BigKnob.render(f);
  }
}
