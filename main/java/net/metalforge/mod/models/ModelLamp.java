package net.metalforge.mod.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLamp extends ModelMF
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Stick1;
    ModelRenderer Stick2;
    ModelRenderer Stick3;
    ModelRenderer Stick4;
  
  public ModelLamp()
  {
    textureWidth = 68;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 48, 26);
      Shape1.addBox(0F, 0F, 0F, 4, 2, 4);
      Shape1.setRotationPoint(-2F, 22F, -2F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 20);
      Shape2.addBox(0F, 0F, 0F, 10, 2, 10);
      Shape2.setRotationPoint(-5F, 20F, -5F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 2);
      Shape3.addBox(0F, 0F, 0F, 10, 2, 10);
      Shape3.setRotationPoint(-5F, 12F, -5F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 48, 20);
      Shape4.addBox(0F, 0F, 0F, 4, 2, 4);
      Shape4.setRotationPoint(-2F, 10F, -2F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Stick1 = new ModelRenderer(this, 60, 1);
      Stick1.addBox(0F, 0F, 0F, 2, 6, 2);
      Stick1.setRotationPoint(-4F, 14F, -4F);
      Stick1.setTextureSize(64, 32);
      Stick1.mirror = true;
      setRotation(Stick1, 0F, 0F, 0F);
      Stick2 = new ModelRenderer(this, 51, 1);
      Stick2.addBox(0F, 0F, 0F, 2, 6, 2);
      Stick2.setRotationPoint(-4F, 14F, 2F);
      Stick2.setTextureSize(64, 32);
      Stick2.mirror = true;
      setRotation(Stick2, 0F, 0F, 0F);
      Stick3 = new ModelRenderer(this, 51, 10);
      Stick3.addBox(0F, 0F, 0F, 2, 6, 2);
      Stick3.setRotationPoint(2F, 14F, 2F);
      Stick3.setTextureSize(64, 32);
      Stick3.mirror = true;
      setRotation(Stick3, 0F, 0F, 0F);
      Stick4 = new ModelRenderer(this, 42, 1);
      Stick4.addBox(0F, 0F, 0F, 2, 6, 2);
      Stick4.setRotationPoint(2F, 14F, -4F);
      Stick4.setTextureSize(64, 32);
      Stick4.mirror = true;
      setRotation(Stick4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Stick1.render(f5);
    Stick2.render(f5);
    Stick3.render(f5);
    Stick4.render(f5);
  }
  
  public void renderModel(float f)
  {
    Shape1.render(f);
    Shape2.render(f);
    Shape3.render(f);
    Shape4.render(f);
    Stick1.render(f);
    Stick2.render(f);
    Stick3.render(f);
    Stick4.render(f);
  }
}
