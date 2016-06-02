package net.metalforge.mod.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAnvil extends ModelMF
{
  //fields
    ModelRenderer Base;
    ModelRenderer Top;
    ModelRenderer Pillar1;
    ModelRenderer Pillar2;
    ModelRenderer Pillar3;
    ModelRenderer Pillar4;
    ModelRenderer Core;
  
  public ModelAnvil()
  {
    textureWidth = 128;
    textureHeight = 48;
    
      Base = new ModelRenderer(this, 63, 0);
      Base.addBox(0F, 0F, 0F, 16, 4, 16);
      Base.setRotationPoint(-8F, 20F, -8F);
      Base.setTextureSize(128, 48);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 0, 22);
      Top.addBox(0F, 0F, 0F, 17, 4, 17);
      Top.setRotationPoint(-8.5F, 10F, -8.5F);
      Top.setTextureSize(128, 48);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      Pillar1 = new ModelRenderer(this, 49, 0);
      Pillar1.addBox(0F, 0F, 0F, 3, 13, 3);
      Pillar1.setRotationPoint(-7F, 7F, -7F);
      Pillar1.setTextureSize(128, 48);
      Pillar1.mirror = true;
      setRotation(Pillar1, 0F, 0F, 0F);
      Pillar2 = new ModelRenderer(this, 16, 0);
      Pillar2.addBox(0F, 0F, 0F, 3, 13, 3);
      Pillar2.setRotationPoint(4F, 7F, -7F);
      Pillar2.setTextureSize(128, 48);
      Pillar2.mirror = true;
      setRotation(Pillar2, 0F, 0F, 0F);
      Pillar3 = new ModelRenderer(this, 32, 0);
      Pillar3.addBox(0F, 0F, 0F, 3, 13, 3);
      Pillar3.setRotationPoint(-7F, 7F, 4F);
      Pillar3.setTextureSize(128, 48);
      Pillar3.mirror = true;
      setRotation(Pillar3, 0F, 0F, 0F);
      Pillar4 = new ModelRenderer(this, 0, 0);
      Pillar4.addBox(0F, 0F, 0F, 3, 13, 3);
      Pillar4.setRotationPoint(4F, 7F, 4F);
      Pillar4.setTextureSize(128, 48);
      Pillar4.mirror = true;
      setRotation(Pillar4, 0F, 0F, 0F);
      Core = new ModelRenderer(this, 77, 22);
      Core.addBox(0F, 0F, 0F, 12, 11, 12);
      Core.setRotationPoint(-6F, 9F, -6F);
      Core.setTextureSize(128, 48);
      Core.mirror = true;
      setRotation(Core, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Top.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
    Core.render(f5);
  }
  
  public void renderModel(float f){
	  Base.render(f);
	  Top.render(f);
	  Pillar1.render(f);
	  Pillar2.render(f);
	  Pillar3.render(f);
	  Pillar4.render(f);
	  Core.render(f);
  }
}
