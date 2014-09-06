package idim.mobs.renders;

import idim.mobs.entities.EntityBloodWorm;
import idim.mobs.models.ModelBloodWorm;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBloodWorm extends RenderLiving {
	public ModelBloodWorm model;
	
	public RenderBloodWorm(ModelBloodWorm par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelBloodWorm) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awid:textures/entity/bloodworm.png");
	}
	
	public void renderTutorial(EntityBloodWorm entity, double par2,
			double par4,
			double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityBloodWorm) par1EntityLiving, par2, par4, par6,
				par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityBloodWorm) par1Entity, par2, par4, par6, par8,
				par9);
	}
}