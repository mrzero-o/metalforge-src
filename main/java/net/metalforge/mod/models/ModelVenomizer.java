package net.metalforge.mod.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVenomizer extends ModelMF
{
    ModelRenderer MainCube;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer TopPart1;
    ModelRenderer TopPart2;
    ModelRenderer TopPart3;
    ModelRenderer TopPart4;
  
    public ModelVenomizer()
    {
    	textureWidth = 56;
    	textureHeight = 52;
    
      MainCube = new ModelRenderer(this, 0, 34);
      MainCube.addBox(0F, 0F, 0F, 12, 5, 12);
      MainCube.setRotationPoint(-6F, 19F, -6F);
      MainCube.setTextureSize(56, 52);
      MainCube.mirror = true;
      setRotation(MainCube, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 48, 0);
      Leg1.addBox(0F, 0F, 0F, 2, 5, 2);
      Leg1.setRotationPoint(-7F, 20F, 5F);
      Leg1.setTextureSize(56, 52);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 48, 8);
      Leg2.addBox(0F, 0F, 0F, 2, 5, 2);
      Leg2.setRotationPoint(5F, 20F, 5F);
      Leg2.setTextureSize(56, 52);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 38, 8);
      Leg3.addBox(0F, 0F, 0F, 2, 5, 2);
      Leg3.setRotationPoint(5F, 20F, -7F);
      Leg3.setTextureSize(56, 52);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 38, 0);
      Leg4.addBox(0F, 0F, 0F, 2, 5, 2);
      Leg4.setRotationPoint(-7F, 20F, -7F);
      Leg4.setTextureSize(56, 52);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      TopPart1 = new ModelRenderer(this, 0, 0);
      TopPart1.addBox(0F, 0F, 0F, 5, 3, 14);
      TopPart1.setRotationPoint(-7F, 16F, -7F);
      TopPart1.setTextureSize(56, 52);
      TopPart1.mirror = true;
      setRotation(TopPart1, 0F, 0F, 0F);
      TopPart2 = new ModelRenderer(this, 0, 17);
      TopPart2.addBox(0F, 0F, 0F, 5, 3, 14);
      TopPart2.setRotationPoint(2F, 16F, -7F);
      TopPart2.setTextureSize(56, 52);
      TopPart2.mirror = true;
      setRotation(TopPart2, 0F, 0F, 0F);
      TopPart3 = new ModelRenderer(this, 38, 26);
      TopPart3.addBox(0F, 0F, 0F, 4, 3, 5);
      TopPart3.setRotationPoint(-2F, 16F, 2F);
      TopPart3.setTextureSize(56, 52);
      TopPart3.mirror = true;
      setRotation(TopPart3, 0F, 0F, 0F);
      TopPart4 = new ModelRenderer(this, 38, 18);
      TopPart4.addBox(0F, 0F, 0F, 4, 3, 5);
      TopPart4.setRotationPoint(-2F, 16F, -7F);
      TopPart4.setTextureSize(56, 52);
      TopPart4.mirror = true;
      setRotation(TopPart4, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	MainCube.render(f5);
    	Leg1.render(f5);
    	Leg2.render(f5);
    	Leg3.render(f5);
    	Leg4.render(f5);
    	TopPart1.render(f5);
    	TopPart2.render(f5);
    	TopPart3.render(f5);
    	TopPart4.render(f5);
    }
  
  	public void renderModel(float f)
  	{
  		MainCube.render(f);
  		Leg1.render(f);
  		Leg2.render(f);
  		Leg3.render(f);
  		Leg4.render(f);
  		TopPart1.render(f);
  		TopPart2.render(f);
  		TopPart3.render(f);
  		TopPart4.render(f);
  	}

}
