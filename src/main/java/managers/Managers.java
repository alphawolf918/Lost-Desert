package idim.managers;

import cpw.mods.fml.common.registry.GameRegistry;

public final class Managers {
	public static void init() {
		GameRegistry.registerWorldGenerator(new EventManager());
	}
}