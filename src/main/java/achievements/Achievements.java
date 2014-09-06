package idim.achievements;

import idim.blocks.Blocks;
import idim.items.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Achievements {
	
	public static AchievementPage desertPage;
	public static Achievement zincd;
	public static Achievement lostPearl;
	public static Achievement createPortal;
	public static Achievement coconutBunch;
	public static Achievement foundEm;
	public static Achievement hotRod;
	public static Achievement powerOfTheBlade;
	
	public static void init() {
		
		zincd = new Achievement(150, "zincd", -3, -1, Items.zincIngot,
				null)
				.registerAchievement();
		addAchievementInfo("zincd", "Zinc'd!", "Procure a zinc ingot.");
		
		lostPearl = new Achievement(151, "lostPearl", 0, 0, Items.lostPearl,
				zincd).registerAchievement();
		addAchievementInfo("lostPearl", "Lost Pearl", "Craft the Lost Pearl.");
		
		createPortal = new Achievement(152, "portalCreated",
				1, -1, Blocks.portalBlock2, zincd).registerAchievement();
		addAchievementInfo("portalCreated", "The Lost Desert Portal",
				"Create the Lost Desert portal.");
		
		coconutBunch = new Achievement(153, "coconutBunch", -2, 2,
				Items.coconut, createPortal).registerAchievement();
		addAchievementInfo("coconutBunch", "A Lovely Bunch Of Coconuts",
				"Harvest a coconut from a Palmwood tree.");
		
		foundEm = new Achievement(154, "foundEm", -2, 6, Items.purpleDiamond,
				createPortal).registerAchievement();
		addAchievementInfo("foundEm", "Found 'em!", "Find a Lost Diamond.");
		
		hotRod = new Achievement(155, "hotRod", -1, 4, Items.powerRod,
				createPortal).registerAchievement();
		addAchievementInfo("hotRod", "Hot Rod", "Get a Power Rod.");
		
		powerOfTheBlade = new Achievement(156, "powerBlade", -3, 5,
				Items.lostSword, hotRod).registerAchievement();
		addAchievementInfo("powerBlade", "Power Of The Blade",
				"Craft the Lost Sword.");
		
		// Achievement Page
		Achievements.desertPage = new AchievementPage("Lost Desert", zincd,
				lostPearl, createPortal, coconutBunch, foundEm, hotRod,
				powerOfTheBlade);
		AchievementPage.registerAchievementPage(Achievements.desertPage);
		
	}
	
	public static void addAchievementInfo(String par1Id, String par2Name,
			String par3Description) {
		addAchievementName(par1Id, par2Name);
		addAchievementDesc(par1Id, par3Description);
	}
	
	public static void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach,
				"en_US", name);
	}
	
	public static void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + ach + ".desc", "en_US", desc);
	}
}