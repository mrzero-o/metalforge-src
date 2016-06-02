package net.metalforge.mod.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlyingMachine extends ModelBiped
{
    ModelRenderer MainBox;
    ModelRenderer WingLeft;
    ModelRenderer WingRight;
    ModelRenderer Rocket;
  
    public ModelFlyingMachine()
    {
	  super(0.5F, 0, 128, 64);
	  textureWidth = 128;
	  textureHeight = 64;
    
      MainBox = new ModelRenderer(this, 0, 32);
      MainBox.addBox(0F, 0F, 0F, 10, 14, 5);
      MainBox.setRotationPoint(-5F, -1F, 2F);
      MainBox.setTextureSize(128, 64);
      MainBox.mirror = true;
      setRotation(MainBox, 0F, 0F, 0F);
      WingLeft = new ModelRenderer(this, 32, 40);
      WingLeft.addBox(-3F, 0F, 0F, 3, 10, 1);
      WingLeft.setRotationPoint(-2F, 2F, 4F);
      WingLeft.setTextureSize(128, 64);
      WingLeft.mirror = true;
      setRotation(WingLeft, 0F, 0F, 0.296706F);
      WingRight = new ModelRenderer(this, 40, 40);
      WingRight.addBox(0F, 0F, 0F, 3, 10, 1);
      WingRight.setRotationPoint(2F, 2F, 4F);
      WingRight.setTextureSize(128, 64);
      WingRight.mirror = true;
      setRotation(WingRight, 0F, 0F, -0.296706F);
      Rocket = new ModelRenderer(this, 50, 36);
      Rocket.addBox(0F, 0F, 0F, 4, 11, 4);
      Rocket.setRotationPoint(-2F, 1F, 4F);
      Rocket.setTextureSize(128, 64);
      Rocket.mirror = true;
      setRotation(Rocket, 0F, 0F, 0F);
      
      this.bipedBody.addChild(MainBox);
      this.bipedBody.addChild(WingLeft);
      this.bipedBody.addChild(WingRight);
      this.bipedBody.addChild(Rocket);
    }
	
    public void render(float f)
    {
    	ModelMF.render(f, new ModelRenderer[]{MainBox, WingLeft, WingRight, Rocket});
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
	  	model.rotateAngleY = y;
	  	model.rotateAngleZ = z;
    }

}
