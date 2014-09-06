package idim.mobs.renders;

import idim.mobs.entities.EntityLostDragon;
import idim.mobs.models.ModelLostDragon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderLostDragon extends RenderLiving {
	public ModelLostDragon model;
	
	public RenderLostDragon(ModelLostDragon par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelLostDragon) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("awid:textures/entity/lostdragon.png");
	}
	
	public void renderTutorial(EntityLostDragon entity, double par2,
			double par4,
			double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityLostDragon) par1EntityLiving, par2, par4, par6,
				par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityLostDragon) par1Entity, par2, par4, par6, par8,
				par9);
	}
}