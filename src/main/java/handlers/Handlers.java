package idim.handlers;

import cpw.mods.fml.common.registry.GameRegistry;

public final class Handlers {
	public static void init() {
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		GameRegistry.registerPickupHandler(new PickUpHandler());
	}
}