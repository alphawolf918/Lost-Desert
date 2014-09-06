package idim.dims.testdim.worldgen;

import idim.blocks.Blocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPalmwoodTree extends WorldGenerator {
	
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Blocks.purpleSand.blockID };
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);
		
		while (checkID != 0) {
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 3) {
			return false;
		}
		j += distanceToAir - 1;
		
		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j + 1, k);
		int blockIDBelow = world.getBlockId(i, j - 1, k);
		for (int x : GetValidSpawnBlocks()) {
			if (blockIDAbove != 0) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID == Blocks.purpleCaveStone.blockID
					&& blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public WorldGenPalmwoodTree() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k)) {
			return false;
		}
		
		int movingX = 0;
		int currentX = i;
		int maxMovingX = 2;
		int currentY = j;
		int randInt = rand.nextInt(10);
		int maxLogs = (randInt < 6) ? 6 : randInt;
		int currentZ = k;
		for (int y = 0; y <= maxLogs; y++) {
			currentY = j + y;
			world.setBlock(currentX, currentY, currentZ, Blocks.palmLog.blockID);
			if (rand.nextInt(10) == 2) {
				world.setBlock(currentX + 1, currentY, currentZ,
						Blocks.palmLog.blockID);
			}
			if (movingX < maxMovingX) {
				movingX++;
			} else {
				currentX++;
				movingX = 0;
			}
			if (y >= 5) {
				world.setBlock(currentX, currentY, k, Blocks.palmLeaves.blockID);
				world.setBlock(currentX + 1, currentY, currentZ + 1,
						Blocks.palmLeaves.blockID);
				world.setBlock(currentX - 1, currentY, currentZ - 1,
						Blocks.palmLeaves.blockID);
			}
		}
		return true;
	}
}