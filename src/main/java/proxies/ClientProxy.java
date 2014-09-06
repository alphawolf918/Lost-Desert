package idim.proxies;

import idim.managers.SoundManager;
import idim.mobs.entities.EntityBloodWorm;
import idim.mobs.entities.EntityLostDragon;
import idim.mobs.entities.EntityLostFish;
import idim.mobs.entities.EntityLostVillager;
import idim.mobs.entities.EntityPowerBlaze;
import idim.mobs.entities.EntityWanderer;
import idim.mobs.models.ModelBloodWorm;
import idim.mobs.models.ModelLostDragon;
import idim.mobs.models.ModelLostFish;
import idim.mobs.models.ModelLostVillager;
import idim.mobs.models.ModelPowerBlaze;
import idim.mobs.models.ModelWanderer;
import idim.mobs.renders.RenderBloodWorm;
import idim.mobs.renders.RenderLostDragon;
import idim.mobs.renders.RenderLostFish;
import idim.mobs.renders.RenderLostVillager;
import idim.mobs.renders.RenderPowerBlaze;
import idim.mobs.renders.RenderWanderer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(
				EntityBloodWorm.class, new RenderBloodWorm(
						new ModelBloodWorm(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityLostDragon.class, new RenderLostDragon(
						new ModelLostDragon(0.5F), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityPowerBlaze.class, new RenderPowerBlaze(
						new ModelPowerBlaze(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityLostVillager.class, new RenderLostVillager(
						new ModelLostVillager(0.5F), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityWanderer.class, new RenderWanderer(
						new ModelWanderer(0.5F), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(
				EntityLostFish.class, new RenderLostFish(
						new ModelLostFish(), 0.5F));
	}
	
	@Override
	public void initSounds() {
		MinecraftForge.EVENT_BUS.register(new SoundManager());
	}
}