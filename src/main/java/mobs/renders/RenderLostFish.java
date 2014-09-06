package idim.mobs.renders;

import idim.mobs.entities.EntityLostFish;
import idim.mobs.models.ModelLostFish;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderLostFish extends RenderLiving {
	public ModelLostFish model;
	
	public RenderLostFish(ModelLostFish par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelLostFish) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awid:textures/entity/lostfish.png");
	}
	
	public void renderTutorial(EntityLostFish entity, double par2,
			double par4,
			double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityLostFish) par1EntityLiving, par2, par4, par6,
				par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityLostFish) par1Entity, par2, par4, par6, par8,
				par9);
	}
}