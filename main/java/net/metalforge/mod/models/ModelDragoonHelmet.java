package net.metalforge.mod.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDragoonHelmet extends ModelBiped
{
    ModelRenderer HeadWingRight;
    ModelRenderer HeadWingLeft;
    ModelRenderer HelmetThing;
    ModelRenderer MouthProtection;
    ModelRenderer ScrewThing;
  
    public ModelDragoonHelmet()
    {
  	  	super(0.5F, 0, 128, 64);
  	  	textureWidth = 90;
  	  	textureHeight = 32;
    
      HeadWingRight = new ModelRenderer(this, 56, 0);
      HeadWingRight.addBox(0F, 0F, 0F, 1, 6, 8);
      HeadWingRight.setRotationPoint(2F, -8F, -4F);
      HeadWingRight.setTextureSize(90, 32);
      HeadWingRight.mirror = true;
      setRotation(HeadWingRight, 0.2792527F, 0F, 0F);
      HeadWingLeft = new ModelRenderer(this, 74, 0);
      HeadWingLeft.addBox(0F, 0F, 0F, 1, 6, 8);
      HeadWingLeft.setRotationPoint(-3F, -8F, -4F);
      HeadWingLeft.setTextureSize(90, 32);
      HeadWingLeft.mirror = true;
      setRotation(HeadWingLeft, 0.2792527F, 0F, 0F);
      HelmetThing = new ModelRenderer(this, 56, 23);
      HelmetThing.addBox(0F, 0F, 0F, 8, 3, 2);
      HelmetThing.setRotationPoint(-4F, -8F, -4F);
      HelmetThing.setTextureSize(90, 32);
      HelmetThing.mirror = true;
      setRotation(HelmetThing, -0.5934119F, 0F, 0F);
      MouthProtection = new ModelRenderer(this, 56, 16);
      MouthProtection.addBox(0F, 0F, 0F, 9, 3, 4);
      MouthProtection.setRotationPoint(-4.5F, -2.5F, -5F);
      MouthProtection.setTextureSize(90, 32);
      MouthProtection.mirror = true;
      setRotation(MouthProtection, 0F, 0F, 0F);
      ScrewThing = new ModelRenderer(this, 56, 28);
      ScrewThing.addBox(0F, 0F, 0F, 9, 1, 1);
      ScrewThing.setRotationPoint(-4.5F, -5.8F, -4F);
      ScrewThing.setTextureSize(90, 32);
      ScrewThing.mirror = true;
      setRotation(ScrewThing, 0.9773844F, 0F, 0F);
      
      this.bipedHead.addChild(HeadWingRight);
      this.bipedHead.addChild(HeadWingLeft);
      this.bipedHead.addChild(HelmetThing);
      this.bipedHead.addChild(MouthProtection);
      this.bipedHead.addChild(ScrewThing);
    }
  
    public void render(float f)
    {
    	ModelMF.render(f, new ModelRenderer[]{HeadWingLeft, HeadWingRight, HelmetThing, MouthProtection, ScrewThing});
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }

}
