package idim.blocks;

import idim.blocks.stairs.PurpleCaveStoneStairs;
import idim.blocks.treeblocks.PalmLeaves;
import idim.blocks.treeblocks.PalmLog;
import idim.blocks.treeblocks.PalmPlanks;
import idim.blocks.treeblocks.PalmwoodSapling;
import idim.creativetabs.ModTabs;
import idim.lib.Ids;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public final class Blocks {
	
	public static Block portalBlock2;
	public static final Block purpleSand = new PurpleSand(Ids.purpleSandID);
	public static final Block creepStone = new CreepStone(Ids.creepStoneID);
	public static final Block creepStoneStairs = new PurpleCaveStoneStairs(
			Ids.creepStoneStairsID, creepStone, 0)
			.setUnlocalizedName("creepstonestairs").setCreativeTab(
					ModTabs.ldTab);
	public static final Block purpleGlass = new PurpleGlass(Ids.purpleGlassID);
	public static final Block creepCobble = new CreepCobble(Ids.creepCobbleID);
	public static final Block purpleCaveStone = new PurpleCaveStone(
			Ids.purpleCaveStoneID);
	public static final Block purpleCaveStoneStairs = new PurpleCaveStoneStairs(
			Ids.purpleCaveStoneStairsID, purpleCaveStone, 0)
			.setUnlocalizedName("purplecavestairs").setCreativeTab(
					ModTabs.ldTab);
	public static final Block purpleCobble = new PurpleCobble(
			Ids.purpleCobbleID);
	public static final Block purpleCaveCobbleStairs = new PurpleCaveStoneStairs(
			Ids.purpleCaveCobbleStairsID, purpleCobble, 0)
			.setUnlocalizedName("purplecavecobblestairs").setCreativeTab(
					ModTabs.ldTab);
	public static final Block purpleCoalOre = new PurpleCoalOre(
			Ids.purpleCoalOreID);
	public static final Block purpleDiamondOre = new PurpleDiamondOre(
			Ids.purpleDiamondOreID);
	public static final Block purpleIronOre = new PurpleIronOre(
			Ids.purpleIronOreID);
	public static final Block purpleGoldOre = new PurpleGoldOre(
			Ids.purpleGoldOreID);
	public static final Block lostRedstoneOre = new PurpleRedstoneOre(
			Ids.lostRedstoneOreID);
	public static final Block purpleGlowstone = new PurpleGlowstone(
			Ids.purpleGlowstoneID);
	public static final Block purpleDiamondBlock = new PurpleDiamondBlock(
			Ids.purpleDiamondBlockID);
	public static final Block creepDirt = new CreepDirt(Ids.creepDirtID);
	public static final Block purpleSandStone = new PurpleSandstone(
			Ids.purpleSandstoneID);
	public static final Block purpleSandStoneStairs = new PurpleCaveStoneStairs(
			Ids.purpleSandStoneStairsID, purpleSandStone, 0)
			.setUnlocalizedName("purplesandstonestairs").setCreativeTab(
					ModTabs.ldTab);
	public static final Block resistGlass = new ResistGlass(Ids.resistGlassID);
	public static final Block purpleEmeraldOre = new PurpleEmeraldOre(
			Ids.purpleEmeraldOreID);
	public static final Block lostCactus = new LostCactus(Ids.lostCactusId);
	public static final Block desertCrystal = new DesertCrystal(
			Ids.desertCrystalID);
	public static final Block lostCrystal = new LostCrystal(Ids.lostCrystalID);
	public static final Block diamondOre = new PurpleDiamondOre2(
			Ids.purpleDiamondOre2);
	public static final Block polishedDesertCrystal = new PolishedDesertCrystal(
			Ids.polishedDesertCrystalID);
	public static final Block polishedLostCrystal = new PolishedLostCrystal(
			Ids.polishedLostCrystalID);
	public static final Block purpleCaveStoneBricks = new PurpleCaveStoneBricks(
			Ids.purpleCaveStoneBricksID);
	public static final Block purpleCaveStoneBricksStairs = new PurpleCaveStoneStairs(
			Ids.purpleCaveStoneBricksStairsID, purpleCaveStoneBricks, 0)
			.setUnlocalizedName("purplecavestonebrickstairs").setCreativeTab(
					ModTabs.ldTab);
	public static final Block zincOre = new ZincOre(Ids.zincOreID);
	public static final Block zincBlock = new ZincBlock(Ids.zincBlockID);
	public static final Block lostZincOre = new LostZincOre(Ids.lostZincOreID);
	public static final Block lostFishBlock = new LostFishBlock(
			Ids.lostFishBlockID);
	public static final Block palmLog = new PalmLog(Ids.palmLogBlockID);
	public static final Block palmPlanks = new PalmPlanks(Ids.palmPlanksBlockID);
	public static final Block palmLeaves = new PalmLeaves(
			Ids.palmLeavesBlockID);
	public static final PalmwoodSapling palmSapling = new PalmwoodSapling(
			Ids.palmWoodSaplingID);
	public static final Block glowTorch = new Glowtorch(Ids.glowTorchID);
	
	public static void init() {
		portalBlock2 = new PortalBlockTest2(506)
				.setUnlocalizedName("portalBlock2");
		GameRegistry.registerBlock(portalBlock2, ModInfo.ID
				+ (portalBlock2.getUnlocalizedName().substring(5)));
		LanguageRegistry.addName(portalBlock2, "Portal Block Dim-10");
		
		addNames(purpleSand, "Lost Sand");
		addNames(creepStone, "Creepstone");
		addNames(purpleGlass, "Lost Glass");
		addNames(creepCobble, "Cobble Creepstone");
		addNames(purpleCaveStone, "Lost Cavestone");
		addNames(purpleCobble, "Lost Cobblestone");
		addNames(purpleGlowstone, "Lost Glowstone");
		addNames(purpleDiamondBlock, "Lost Diamond Block");
		addNames(creepDirt, "Creepdirt");
		addNames(purpleSandStone, "Lost Sandstone");
		addNames(purpleIronOre, "Lost Iron Ore");
		addNames(purpleGoldOre, "Lost Gold Ore");
		addNames(purpleCoalOre, "Lost Coal Ore");
		addNames(purpleDiamondOre, "Lost Diamond Ore");
		addNames(purpleEmeraldOre, "Lost Emerald Ore");
		addNames(lostRedstoneOre, "Lost Redstone Ore");
		addNames(diamondOre, "Purple Diamond Ore");
		addNames(lostZincOre, "Lost Zinc Ore");
		addNames(resistGlass, "Resistance Glass");
		addNames(lostCactus, "Lost Cactus");
		addNames(desertCrystal, "Desert Crystal");
		addNames(lostCrystal, "Lost Crystal");
		addNames(purpleCaveStoneStairs, "Lost Cavestairs");
		addNames(purpleCaveCobbleStairs, "Lost Cobblestairs");
		addNames(creepStoneStairs, "Lost Creepstairs");
		addNames(purpleSandStoneStairs, "Lost Sandstairs");
		addNames(purpleCaveStoneBricksStairs, "Lost Cavebrick Stairs");
		addNames(polishedDesertCrystal, "Polished Desert Crystal");
		addNames(polishedLostCrystal, "Polished Lost Crystal");
		addNames(purpleCaveStoneBricks, "Cavestone Brick");
		addNames(zincOre, "Zinc Ore");
		addNames(zincBlock, "Zinc Block");
		addNames(lostFishBlock, "Lostfish Block");
		addNames(palmLog, "Palmwood Log");
		addNames(palmPlanks, "Palmwood Planks");
		addNames(palmLeaves, "Palmwood Leaves");
		addNames(palmSapling, "Palmwood Sapling");
		addNames(glowTorch, "Glowtorch");
	}
	
	public static void addNames(Block par1Block, String par2Name) {
		GameRegistry.registerBlock(par1Block, par2Name);
		LanguageRegistry.addName(par1Block, par2Name);
	}
}