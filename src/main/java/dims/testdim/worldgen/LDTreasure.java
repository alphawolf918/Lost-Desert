package idim.dims.testdim.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class LDTreasure {
	public static void init() {
	}
	
	public static void addChest(World world, Random rand, int i, int j, int k,
			boolean isBigChest, String chestType) {
		world.setBlock(i, j, k, Block.chest.blockID);
		if (isBigChest) {
			world.setBlock(i + 1, j, k, Block.chest.blockID);
		}
		TileEntityChest tileentitychest = (TileEntityChest) world
				.getBlockTileEntity(i, j, k);
		tileentitychest.setChestGuiName("Desert Chest");
		if (tileentitychest != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(chestType);
			WeightedRandomChestContent.generateChestContents(rand,
					info.getItems(rand), tileentitychest, info.getCount(rand));
		}
	}
}