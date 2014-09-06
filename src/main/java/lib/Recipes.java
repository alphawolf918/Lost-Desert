package idim.lib;

import idim.blocks.Blocks;
import idim.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public final class Recipes {
	
	public static void init() {
		Crafting.init();
		Smelting.init();
	}
	
	public static class Crafting {
		public static void init() {
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleGlowstone, 1),
					new Object[] {
							"GG ", "GG ", "   ", 'G', Items.purpleGlowstoneDust
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleCaveStoneBricks,
					4),
					new Object[] {
							"GG ", "GG ", "   ", 'G', Blocks.purpleCaveStone
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.polishedDesertCrystal,
					4),
					new Object[] {
							"GG ", "GG ", "   ", 'G', Blocks.desertCrystal
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.polishedLostCrystal,
					4),
					new Object[] {
							"GG ", "GG ", "   ", 'G', Blocks.lostCrystal
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleCaveStoneStairs,
					3), new Object[] {
					"  C", " CC", "CCC", 'C', Blocks.purpleCaveStone
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleCaveCobbleStairs,
					3), new Object[] {
					"  C", " CC", "CCC", 'C', Blocks.purpleCobble
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.creepStoneStairs,
					3), new Object[] {
					"  C", " CC", "CCC", 'C', Blocks.creepStone
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleSandStoneStairs,
					3), new Object[] {
					"  C", " CC", "CCC", 'C', Blocks.purpleSandStone
			});
			GameRegistry.addRecipe(new ItemStack(
					Blocks.purpleCaveStoneBricksStairs,
					3), new Object[] {
					"  C", " CC", "CCC", 'C', Blocks.purpleCaveStoneBricks
			});
			GameRegistry.addShapelessRecipe(new ItemStack(
					Items.purpleGlowstoneDust, 4), new Object[] {
					Blocks.purpleGlowstone
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleDiamondBlock, 1),
					new Object[] {
							"DDD", "DDD", "DDD", 'D', Items.purpleDiamond
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.zincBlock, 1),
					new Object[] {
							"DDD", "DDD", "DDD", 'D', Items.zincIngot
					});
			GameRegistry.addShapelessRecipe(new ItemStack(Items.purpleDiamond,
					9), new Object[] {
					Blocks.purpleDiamondBlock
			});
			GameRegistry.addRecipe(new ItemStack(Blocks.purpleSandStone, 4),
					new Object[] {
							"SS ", "SS ", "   ", 'S', Blocks.purpleSand
					});
			GameRegistry.addRecipe(new ItemStack(Items.lostPearl, 1),
					new Object[] {
							"GGG", "GEG", "GGG", 'G', Items.zincIngot, 'E',
							Item.eyeOfEnder
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.resistGlass, 1),
					new Object[] {
							"DDD", "DGD", "DDD", 'D', Items.purpleDiamond, 'G',
							Blocks.purpleGlass
					});
			GameRegistry.addRecipe(new ItemStack(Items.lostSword, 1),
					new Object[] {
							" D ", "DDD", " S ", 'D',
							Blocks.purpleDiamondBlock, 'S', Items.powerRod
					});
			GameRegistry.addShapelessRecipe(
					new ItemStack(Blocks.palmPlanks, 4), new Object[] {
					Blocks.palmLog
					});
			GameRegistry.addRecipe(new ItemStack(Block.workbench, 1),
					new Object[] {
							"LL ", "LL ", "   ", 'L', Blocks.palmPlanks
					});
			GameRegistry.addRecipe(new ItemStack(Blocks.glowTorch, 4),
					new Object[] {
							"G  ", "S  ", 'G', Items.purpleGlowstoneDust, 'S',
							Items.powerRod
					});
		}
	}
	
	public static class Smelting {
		public static void init() {
			GameRegistry.addSmelting(Blocks.purpleCobble.blockID,
					new ItemStack(Blocks.purpleCaveStone, 1), 2F);
			GameRegistry.addSmelting(Blocks.creepCobble.blockID, new ItemStack(
					Blocks.creepStone, 1), 4F);
			GameRegistry.addSmelting(Blocks.purpleSand.blockID, new ItemStack(
					Blocks.purpleGlass, 1), 4F);
			GameRegistry.addSmelting(Blocks.purpleIronOre.blockID,
					new ItemStack(Item.ingotIron, 2), 5F);
			GameRegistry.addSmelting(Blocks.purpleGoldOre.blockID,
					new ItemStack(Item.ingotGold, 2), 6F);
			GameRegistry.addSmelting(Blocks.purpleDiamondOre.blockID,
					new ItemStack(Items.purpleDiamond, 2), 7F);
			GameRegistry.addSmelting(Blocks.purpleEmeraldOre.blockID,
					new ItemStack(Item.emerald, 2), 8F);
			GameRegistry.addSmelting(Blocks.lostCactus.blockID, new ItemStack(
					Item.dyePowder, 1, 5), 2.5F);
		}
	}
}