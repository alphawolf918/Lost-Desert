package idim.mobs;

import idim.biomes.Biomes;
import idim.mobs.entities.EntityBloodWorm;
import idim.mobs.entities.EntityLostDragon;
import idim.mobs.entities.EntityLostFish;
import idim.mobs.entities.EntityLostVillager;
import idim.mobs.entities.EntityPowerBlaze;
import idim.mobs.entities.EntityWanderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityWitch;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public final class Mobs {
	
	static int startEntityId = 300;
	
	public static void init() {
		// Bloodworm
		EntityRegistry.registerGlobalEntityID(EntityBloodWorm.class,
				"bloodworm", 40);
		LanguageRegistry.instance().addStringLocalization(
				"entity.bloodworm.name", "en_US", "Bloodworm");
		EntityRegistry.addSpawn(EntityBloodWorm.class, 15, 1, 2,
				EnumCreatureType.monster, Biomes.lostDesert);
		registerEntityEgg(EntityBloodWorm.class, 0xff00ff, 0x8b00ae);
		
		// Lost Dragon
		EntityRegistry.registerGlobalEntityID(EntityLostDragon.class,
				"lostdragon", 43);
		LanguageRegistry.instance().addStringLocalization(
				"entity.lostdragon.name", "en_US", "Lost Dragon");
		registerEntityEgg(EntityLostDragon.class, 0x8b00ff, 0x008b00);
		
		// Powerblaze
		EntityRegistry.registerGlobalEntityID(EntityPowerBlaze.class,
				"powerblaze", 44);
		LanguageRegistry.instance().addStringLocalization(
				"entity.powerblaze.name", "en_US", "Powerblaze");
		EntityRegistry.addSpawn(EntityPowerBlaze.class, 1, 1, 1,
				EnumCreatureType.monster, Biomes.lostDesert);
		registerEntityEgg(EntityPowerBlaze.class, 0x9c1bad, 0x8b228b);
		
		// Lost Villager
		EntityRegistry.registerGlobalEntityID(EntityLostVillager.class,
				"lostvillager", 45);
		LanguageRegistry.instance().addStringLocalization(
				"entity.lostvillager.name", "en_US", "Lost Villager");
		registerEntityEgg(EntityLostVillager.class, 0x4e4e5f, 0x3f6ef0);
		
		// Wanderer
		EntityRegistry.registerGlobalEntityID(EntityWanderer.class,
				"wanderer", 46);
		EntityRegistry.addSpawn(EntityWanderer.class, 1, 0, 1,
				EnumCreatureType.creature, Biomes.lostDesert);
		LanguageRegistry.instance().addStringLocalization(
				"entity.wanderer.name", "en_US", "Wanderer");
		registerEntityEgg(EntityWanderer.class, 0x00dd00, 0x8b21de);
		
		// Lostfish
		EntityRegistry.registerGlobalEntityID(EntityLostFish.class,
				"lostfish", 47);
		LanguageRegistry.instance().addStringLocalization(
				"entity.lostfish.name", "en_US", "Lostfish");
		registerEntityEgg(EntityLostFish.class, 0x8b2bae, 0xed56df);
		
		// Witch
		EntityRegistry.addSpawn(EntityWitch.class, 10, 1, 2,
				EnumCreatureType.monster, Biomes.lostDesert);
		
		// Cave Spider
		EntityRegistry.addSpawn(EntityCaveSpider.class, 10, 1, 1,
				EnumCreatureType.monster, Biomes.lostDesert);
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}
	
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
}