package idim.dims.testdim.worldgen;

import idim.blocks.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenOasis extends WorldGenerator {
	
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Blocks.purpleSand.blockID, Blocks.creepStone.blockID };
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
	
	public WorldGenOasis() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		if (!LocationIsValidSpawn(world, i, j, k)) {
			return false;
		}
		
		(new WorldGenLakes(Block.waterStill.blockID)).generate(world, rand, i,
				j, k);
		int distanceX = 2;
		int distanceZ = 2;
		int randInt = rand.nextInt(8);
		int numTrees = (randInt < 4) ? 4 : randInt;
		for (int l = 0; l <= numTrees; l++) {
			distanceX++;
			distanceZ++;
			(new WorldGenPalmwoodTree()).generate(world, rand,
					((i + distanceX) + 6), j,
					((k + distanceZ) + 6));
		}
		return true;
	}
}