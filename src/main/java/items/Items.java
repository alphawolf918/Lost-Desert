package idim.items;

import idim.lib.Ids;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public final class Items {
	
	public static Item purpleDiamond;
	public static Item purpleGlowstoneDust;
	public static Item lostPearl;
	public static Item lostSword;
	public static Item powerRod;
	public static Item zincIngot;
	public static Item coconut;
	
	public static void init() {
		purpleDiamond = new PurpleDiamond(
				Ids.purpleDiamondID);
		purpleGlowstoneDust = new LostGlowstoneDust(Ids.purpleGlowstoneDustID);
		lostPearl = new LostPearl(Ids.lostPearlID);
		lostSword = new PurpleSword(Ids.lostSwordID,
				EnumToolMaterial.EMERALD);
		powerRod = new PowerRod(Ids.powerRodID);
		zincIngot = new Zinc(Ids.zincItemID);
		coconut = new Coconut(Ids.coconutItemID);
		addNames();
	}
	
	public static void addNames() {
		LanguageRegistry.addName(purpleDiamond, "Lost Diamond");
		LanguageRegistry.addName(purpleGlowstoneDust, "Lost Glowdust");
		LanguageRegistry.addName(lostPearl, "Lost Pearl");
		LanguageRegistry.addName(lostSword, "Lost Sword");
		LanguageRegistry.addName(powerRod, "Power Rod");
		LanguageRegistry.addName(zincIngot, "Zinc Ingot");
		LanguageRegistry.addName(coconut, "Coconut");
	}
}