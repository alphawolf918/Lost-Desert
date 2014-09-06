package idim.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public final class Biomes {
	
	public static int biomeColor = 1200485;
	
	public static BiomeGenBase lostDesert;
	
	public static void init() {
		lostDesert = new LostDesert(180);
	}
}