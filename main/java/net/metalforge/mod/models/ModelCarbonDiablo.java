package net.metalforge.mod.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCarbonDiablo extends ModelMF
{
    ModelRenderer Heatprov;
    ModelRenderer Core;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Top;
    ModelRenderer InnerCoil;
  
    public ModelCarbonDiablo()
  	{
    textureWidth = 106;
    textureHeight = 32;
    
      Heatprov = new ModelRenderer(this, 56, 0);
      Heatprov.addBox(0F, 0F, 0F, 10, 3, 10);
      Heatprov.setRotationPoint(-5F, 21F, -5F);
      Heatprov.setTextureSize(64, 32);
      Heatprov.mirror = true;
      setRotation(Heatprov, 0F, 0F, 0F);
      Core = new ModelRenderer(this, 0, 0);
      Core.addBox(0F, 0F, 0F, 14, 7, 14);
      Core.setRotationPoint(-7F, 14F, -7F);
      Core.setTextureSize(64, 32);
      Core.mirror = true;
      setRotation(Core, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 44, 21);
      Leg1.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg1.setRotationPoint(-6F, 21F, -6F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 36, 21);
      Leg2.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg2.setRotationPoint(-6F, 21F, 4F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 36, 26);
      Leg3.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg3.setRotationPoint(4F, 21F, 4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 44, 26);
      Leg4.addBox(0F, 0F, 0F, 2, 3, 2);
      Leg4.setRotationPoint(4F, 21F, -6F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 56, 13);
      Top.addBox(-6F, 0F, -6F, 12, 2, 12);
      Top.setRotationPoint(0F, 11F, 0F);
      Top.setTextureSize(64, 32);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      InnerCoil = new ModelRenderer(this, 0, 21);
      InnerCoil.addBox(-4.5F, 0F, -4.5F, 9, 1, 9);
      InnerCoil.setRotationPoint(0F, 13F, 0F);
      InnerCoil.setTextureSize(64, 32);
      InnerCoil.mirror = true;
      setRotation(InnerCoil, 0F, 0F, 0F);
  }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Heatprov.render(f5);
	    Core.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Top.render(f5);
	    InnerCoil.render(f5);
	    
    }
    
    public void renderModel(float f){
    	Heatprov.render(f);
    	Core.render(f);
	  	Leg1.render(f);
	  	Leg2.render(f);
	  	Leg3.render(f);
	  	Leg4.render(f);
	  	Top.render(f);
	  	InnerCoil.render(f);
    }

}
