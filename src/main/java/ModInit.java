package idim;

import idim.biomes.Biomes;
import idim.blocks.Blocks;
import idim.creativetabs.ModTabs;
import idim.dims.Dimensions;
import idim.handlers.Handlers;
import idim.items.Items;
import idim.lib.Recipes;
import idim.managers.Managers;
import idim.mobs.Mobs;
import idim.proxies.Proxies;
import idim.treasure.Treasures;

public final class ModInit {
	public static void init() {
		Proxies.init();
		Biomes.init();
		Blocks.init();
		Items.init();
		Recipes.init();
		Mobs.init();
		Managers.init();
		ModTabs.init();
		Dimensions.init();
		Treasures.init();
		Handlers.init();
		// Achievements.init();
	}
}