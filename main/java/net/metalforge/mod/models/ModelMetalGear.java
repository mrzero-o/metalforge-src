package net.metalforge.mod.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMetalGear extends ModelBiped
{
    ModelRenderer MaskPlate;
    ModelRenderer MaskSnorchel;
    ModelRenderer MaskGlass;
    ModelRenderer MaskAntenne;
    ModelRenderer MaskBelt;
    ModelRenderer KneeBeltLeft;
    ModelRenderer KneeCogLeft;
    ModelRenderer KneeBeltRight;
    ModelRenderer KneeCogRight;
    ModelRenderer FMMain;
    ModelRenderer FMKnob;
    ModelRenderer FMThrusterM;
    ModelRenderer FMThrusterMBelt;
    ModelRenderer FMThrusterR;
    ModelRenderer FMThrusterL;
    ModelRenderer Shape1;
  
  public ModelMetalGear(float f)
  {
	  super(f, 0, 128, 64);
	  textureWidth = 128;
	  textureHeight = 64;
      MaskPlate = new ModelRenderer(this, 56, 0);
      MaskPlate.addBox(0F, 0F, 0F, 9, 9, 1);
      MaskPlate.setRotationPoint(-4.5F, -8.5F, -5F);
      MaskPlate.setTextureSize(128, 64);
      MaskPlate.mirror = true;
      setRotation(MaskPlate, 0F, 0F, 0F);
      MaskSnorchel = new ModelRenderer(this, 78, 0);
      MaskSnorchel.addBox(0F, 0F, 0F, 2, 3, 2);
      MaskSnorchel.setRotationPoint(-1F, -1F, -6F);
      MaskSnorchel.setTextureSize(128, 64);
      MaskSnorchel.mirror = true;
      setRotation(MaskSnorchel, -0.7853982F, 0F, 0F);
      MaskGlass = new ModelRenderer(this, 88, 0);
      MaskGlass.addBox(0F, 0F, 0F, 7, 5, 3);
      MaskGlass.setRotationPoint(-3.5F, -7F, -6F);
      MaskGlass.setTextureSize(128, 64);
      MaskGlass.mirror = true;
      setRotation(MaskGlass, -0.1745329F, 0F, 0F);
      MaskAntenne = new ModelRenderer(this, 110, 0);
      MaskAntenne.addBox(0F, 0F, 0F, 1, 7, 1);
      MaskAntenne.setRotationPoint(3.5F, -10.5F, -1F);
      MaskAntenne.setTextureSize(128, 64);
      MaskAntenne.mirror = true;
      setRotation(MaskAntenne, -0.2617994F, 0F, 0F);
      MaskBelt = new ModelRenderer(this, 56, 12);
      MaskBelt.addBox(0F, 0F, 0F, 9, 2, 9);
      MaskBelt.setRotationPoint(-4.5F, -5F, -4.5F);
      MaskBelt.setTextureSize(128, 64);
      MaskBelt.mirror = true;
      setRotation(MaskBelt, 0F, 0F, 0F);
      KneeBeltLeft = new ModelRenderer(this, 0, 56);
      KneeBeltLeft.addBox(0F, 0F, 0F, 5, 2, 5);
      KneeBeltLeft.setRotationPoint(0F, 0F, 0F);
      KneeBeltLeft.setTextureSize(128, 64);
      KneeBeltLeft.mirror = true;
      setRotation(KneeBeltLeft, 0F, 0F, 0F);
      KneeCogLeft = new ModelRenderer(this, 0, 46);
      KneeCogLeft.addBox(0F, 0F, 0F, 1, 4, 4);
      KneeCogLeft.setRotationPoint(4F, 15F, -2F);
      KneeCogLeft.setTextureSize(128, 64);
      KneeCogLeft.mirror = true;
      setRotation(KneeCogLeft, 0F, 0F, 0F);
      KneeBeltRight = new ModelRenderer(this, 22, 56);
      KneeBeltRight.addBox(0F, 0F, 0F, 5, 2, 5);
      KneeBeltRight.setRotationPoint(-4.5F, 16F, -2.5F);
      KneeBeltRight.setTextureSize(128, 64);
      KneeBeltRight.mirror = true;
      setRotation(KneeBeltRight, 0F, 0F, 0F);
      KneeCogRight = new ModelRenderer(this, 12, 46);
      KneeCogRight.addBox(0F, 0F, 0F, 1, 4, 4);
      KneeCogRight.setRotationPoint(-5F, 15F, -2F);
      KneeCogRight.setTextureSize(128, 64);
      KneeCogRight.mirror = true;
      setRotation(KneeCogRight, 0F, 0F, 0F);
      FMMain = new ModelRenderer(this, 88, 48);
      FMMain.addBox(0F, 0F, 0F, 8, 10, 5);
      FMMain.setRotationPoint(-4F, 0F, 2F);
      FMMain.setTextureSize(128, 64);
      FMMain.mirror = true;
      setRotation(FMMain, 0F, 0F, 0F);
      FMKnob = new ModelRenderer(this, 72, 56);
      FMKnob.addBox(0F, 0F, 0F, 4, 3, 3);
      FMKnob.setRotationPoint(-2F, 1F, 4F);
      FMKnob.setTextureSize(128, 64);
      FMKnob.mirror = true;
      setRotation(FMKnob, 0.7853982F, 0F, 0F);
      FMThrusterM = new ModelRenderer(this, 56, 53);
      FMThrusterM.addBox(0F, 0F, 0F, 2, 8, 2);
      FMThrusterM.setRotationPoint(-1F, 1F, 5.9F);
      FMThrusterM.setTextureSize(128, 64);
      FMThrusterM.mirror = true;
      setRotation(FMThrusterM, 0.1396263F, 0F, 0F);
      FMThrusterMBelt = new ModelRenderer(this, 24, 50);
      FMThrusterMBelt.addBox(0F, 0F, 0F, 3, 1, 3);
      FMThrusterMBelt.setRotationPoint(-1.5F, 4F, 6F);
      FMThrusterMBelt.setTextureSize(128, 64);
      FMThrusterMBelt.mirror = true;
      setRotation(FMThrusterMBelt, 0.1396263F, 0F, 0F);
      FMThrusterR = new ModelRenderer(this, 104, 36);
      FMThrusterR.addBox(0F, 0F, 0F, 2, 7, 3);
      FMThrusterR.setRotationPoint(-4F, 2F, 3F);
      FMThrusterR.setTextureSize(128, 64);
      FMThrusterR.mirror = true;
      setRotation(FMThrusterR, 0F, 0F, 0.2792527F);
      FMThrusterL = new ModelRenderer(this, 89, 36);
      FMThrusterL.addBox(0F, 0F, 0F, 2, 7, 3);
      FMThrusterL.setRotationPoint(2F, 2F, 3F);
      FMThrusterL.setTextureSize(128, 64);
      FMThrusterL.mirror = true;
      setRotation(FMThrusterL, 0F, 0F, -0.2792527F);
      Shape1 = new ModelRenderer(this, 68, 44);
      Shape1.addBox(0F, 0F, 0F, 4, 4, 5);
      Shape1.setRotationPoint(-2F, -3F, -6.5F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      
      this.bipedBody.addChild(FMKnob);
      this.bipedBody.addChild(FMMain);
      this.bipedBody.addChild(FMThrusterL);
      this.bipedBody.addChild(FMThrusterM);
      this.bipedBody.addChild(FMThrusterMBelt);
      this.bipedBody.addChild(FMThrusterR);
      this.bipedLeftLeg.addChild(KneeBeltLeft);
      this.bipedLeftLeg.addChild(KneeCogLeft);
      this.bipedRightLeg.addChild(KneeBeltRight);
      this.bipedRightLeg.addChild(KneeCogRight);
      this.bipedHead.addChild(MaskAntenne);
      this.bipedHead.addChild(MaskBelt);
      this.bipedHead.addChild(MaskGlass);
      this.bipedHead.addChild(MaskPlate);
      this.bipedHead.addChild(MaskSnorchel);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
