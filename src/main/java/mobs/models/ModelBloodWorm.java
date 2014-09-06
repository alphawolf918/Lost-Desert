package idim.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBloodWorm extends ModelBase
{
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer body2;
	ModelRenderer head2;
	
	public ModelBloodWorm()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -6F, 8, 8, 6);
		head.setRotationPoint(-2F, 18F, -8F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 8, 4);
		body.addBox(-6F, -10F, -7F, 15, 12, 10);
		body.setRotationPoint(0F, 16F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 1.570796F, 0F, 0F);
		body2 = new ModelRenderer(this, 5, 4);
		body2.addBox(0F, 0F, 0F, 16, 11, 12);
		body2.setRotationPoint(-6F, 23F, 0F);
		body2.setTextureSize(64, 32);
		setRotation(body2, 1.570796F, 0F, 0F);
		head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(-4F, -4F, -6F, 8, 8, 6);
		head2.setRotationPoint(5F, 18F, -8F);
		head2.setTextureSize(64, 32);
		setRotation(head2, 0F, 0F, 0F);
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity)
	{
		float f6 = (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head2.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.body2.rotateAngleX = ((float) Math.PI / 2F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		head.render(par7);
		body.render(par7);
		body2.render(par7);
		head2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
}
