package idim.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public final class ModTabs {
	
	public static CreativeTabs ldTab = new LostDesertCTab(
			CreativeTabs.getNextID(),
			"lostdesert");
	
	public static void init() {
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup." + "lostdesert", "en_US", "Lost Desert");
	}
}