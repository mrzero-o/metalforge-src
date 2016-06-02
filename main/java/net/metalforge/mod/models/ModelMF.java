package net.metalforge.mod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelMF extends ModelBase{
	
	public ModelMF(){
		super();
	}
	
	public void renderModel(float f){
		
	}
	
	public static void render(float f, ModelRenderer[] boxes)
	{
		for(int i = 0; i < boxes.length; i++){
			boxes[i].render(f);
		}
	}
	
	public void setRotation(ModelRenderer model, float x, float y, float z)
	{
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	}
	  
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}
}
