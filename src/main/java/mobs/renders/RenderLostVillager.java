package idim.mobs.renders;

import idim.mobs.entities.EntityLostVillager;
import idim.mobs.models.ModelLostVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderLostVillager extends RenderLiving {
	public ModelLostVillager model;
	
	public RenderLostVillager(ModelLostVillager par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelLostVillager) mainModel;
	}
	
	protected void preRenderVillager(EntityVillager par1EntityVillager,
			float par2) {
		float f1 = 0.9375F;
		
		if (par1EntityVillager.getGrowingAge() < 0) {
			f1 = (float) (f1 * 0.8D);
			this.shadowSize = 0.25F;
		} else {
			this.shadowSize = 0.5F;
		}
		
		GL11.glScalef(f1, f1, f1);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityVillager ev = (EntityVillager) entity;
		return new ResourceLocation(
				"awid:textures/entity/villagers/lostvillager.png");
	}
	
	public void renderTutorial(EntityLostVillager entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityLostVillager) par1EntityLiving, par2, par4,
				par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityLostVillager) par1Entity, par2, par4, par6,
				par8, par9);
	}
}