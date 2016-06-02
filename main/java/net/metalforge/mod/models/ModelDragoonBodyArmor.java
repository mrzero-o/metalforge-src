package net.metalforge.mod.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDragoonBodyArmor extends ModelBiped
{
    ModelRenderer ShoulderArmor;
    ModelRenderer BreastArmor;
    ModelRenderer TummyArmor;
    ModelRenderer BackWingLeft;
    ModelRenderer BackWingRight;
    ModelRenderer ShoulderSpikeUpper;
    ModelRenderer ShoulderSpikeSide;
    ModelRenderer ArmProt;
  
    public ModelDragoonBodyArmor()
    {
  	  	super(0.5F, 0, 128, 64);
    	textureWidth = 78;
    	textureHeight = 44;
    
      ShoulderArmor = new ModelRenderer(this, 0, 32);
      ShoulderArmor.addBox(0F, 0F, 0F, 6, 6, 6);
      ShoulderArmor.setRotationPoint(-9F, -1F, -3F);
      ShoulderArmor.setTextureSize(78, 44);
      ShoulderArmor.mirror = true;
      setRotation(ShoulderArmor, 0F, 0F, 0F);
      BreastArmor = new ModelRenderer(this, 46, 32);
      BreastArmor.addBox(0F, 0F, 0F, 7, 5, 6);
      BreastArmor.setRotationPoint(-3.5F, -0.5F, -3F);
      BreastArmor.setTextureSize(78, 44);
      BreastArmor.mirror = true;
      setRotation(BreastArmor, 0F, 0F, 0F);
      TummyArmor = new ModelRenderer(this, 24, 32);
      TummyArmor.addBox(0F, 0F, 0F, 6, 6, 5);
      TummyArmor.setRotationPoint(-3F, 4.5F, -2.5F);
      TummyArmor.setTextureSize(78, 44);
      TummyArmor.mirror = true;
      setRotation(TummyArmor, 0F, 0F, 0F);
      BackWingLeft = new ModelRenderer(this, 56, 22);
      BackWingLeft.addBox(-1F, -7F, -3F, 1, 7, 3);
      BackWingLeft.setRotationPoint(2.5F, 8F, 2.5F);
      BackWingLeft.setTextureSize(78, 44);
      BackWingLeft.mirror = true;
      setRotation(BackWingLeft, -0.4363323F, 0F, 0F);
      BackWingRight = new ModelRenderer(this, 64, 22);
      BackWingRight.addBox(-1F, -7F, -3F, 1, 7, 3);
      BackWingRight.setRotationPoint(-1.5F, 8F, 2.5F);
      BackWingRight.setTextureSize(78, 44);
      BackWingRight.mirror = true;
      setRotation(BackWingRight, -0.4363323F, 0F, 0F);
      ShoulderSpikeUpper = new ModelRenderer(this, 56, 10);
      ShoulderSpikeUpper.addBox(0F, 0F, 0F, 4, 3, 3);
      ShoulderSpikeUpper.setRotationPoint(-6F, -2.5F, 2F);
      ShoulderSpikeUpper.setTextureSize(78, 44);
      ShoulderSpikeUpper.mirror = true;
      setRotation(ShoulderSpikeUpper, -0.7853982F, 1.570796F, 0F);
      ShoulderSpikeSide = new ModelRenderer(this, 56, 0);
      ShoulderSpikeSide.addBox(0F, 0F, 0F, 3, 5, 5);
      ShoulderSpikeSide.setRotationPoint(-9.5F, 3.5F, 0F);
      ShoulderSpikeSide.setTextureSize(78, 44);
      ShoulderSpikeSide.mirror = true;
      setRotation(ShoulderSpikeSide, -0.7853982F, 0F, -1.570796F);
      ArmProt = new ModelRenderer(this, 72, 0);
      ArmProt.addBox(0F, 0F, 0F, 1, 5, 2);
      ArmProt.setRotationPoint(-8.5F, 5F, -1F);
      ArmProt.setTextureSize(78, 44);
      ArmProt.mirror = true;
      setRotation(ArmProt, 0F, 0F, 0F);
      
      this.bipedBody.addChild(BackWingLeft);
      this.bipedBody.addChild(BackWingRight);
      this.bipedBody.addChild(BreastArmor);
      this.bipedBody.addChild(TummyArmor);
      
      this.bipedRightArm.addChild(ArmProt);
      this.bipedRightArm.addChild(ShoulderArmor);
      this.bipedRightArm.addChild(ShoulderSpikeUpper);
      this.bipedRightArm.addChild(ShoulderSpikeSide);
  }
  
    public void render(float f)
    {
    	ModelMF.render(f, new ModelRenderer[]{});
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }

}
