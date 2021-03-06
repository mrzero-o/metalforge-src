package net.metalforge.mod.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDrinkingHelmet extends ModelBiped
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
    public ModelDrinkingHelmet()
    {
    	super(0.5F, 0, 108, 32);

  	  	textureWidth = 108;
  	  	textureHeight = 32;
  	  
        Shape1 = new ModelRenderer(this, 56, 16);
        Shape1.addBox(0F, 0F, 0F, 9, 1, 10);
        Shape1.setRotationPoint(-4.5F, -7F, -5.5F);
        Shape1.setTextureSize(108, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 94, 16);
        Shape2.addBox(0F, 0F, 0F, 3, 6, 3);
        Shape2.setRotationPoint(3.5F, -9F, -2F);
        Shape2.setTextureSize(108, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 74, 0);
        Shape3.addBox(0F, 0F, 0F, 5, 1, 5);
        Shape3.setRotationPoint(0F, -2F, -5F);
        Shape3.setTextureSize(108, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0.4363323F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 56, 29);
        Shape4.addBox(0F, 0F, 0F, 11, 1, 1);
        Shape4.setRotationPoint(-5.5F, -10F, -1F);
        Shape4.setTextureSize(108, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 94, 0);
        Shape5.addBox(0F, 0F, 0F, 3, 6, 3);
        Shape5.setRotationPoint(-6.5F, -9F, -2F);
        Shape5.setTextureSize(108, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
        
        this.bipedHead.addChild(Shape1);
        this.bipedHead.addChild(Shape2);
        this.bipedHead.addChild(Shape3);
        this.bipedHead.addChild(Shape4);
        this.bipedHead.addChild(Shape5);
  	}
  
    public void render(float f)
    {
  	  ModelMF.render(f, new ModelRenderer[]{Shape1, Shape2, Shape3, Shape4, Shape5});
    }
  
  	private void setRotation(ModelRenderer model, float x, float y, float z)
  	{
  		model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
  	}
  
  	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  	{
  		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  	}
}
