package idim.dims.testdim.structures;

import idim.blocks.Blocks;
import idim.methods.Methods;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WandererHouse extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Blocks.purpleSand.blockID,
				Blocks.purpleCaveStone.blockID, Blocks.creepStone.blockID,
				Blocks.creepDirt.blockID };
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
	
	public WandererHouse() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k))
		{
			return false;
		}
		
		world.setBlock(i + 0, j + 0, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 0, k + 1,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 0, k + 3,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 0, k + 4,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 0, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 1,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 3,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 4,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 1,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 2,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 3,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 4,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 1, j + 2, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 1, j + 2, k + 2, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 1, j + 2, k + 3, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 1, j + 2, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 2, j + 0, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 2, j + 0, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 2, j + 1, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 2, j + 1, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 2, j + 2, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 2, j + 2, k + 2, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 2, j + 2, k + 3, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 2, j + 2, k + 4, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 2, j + 2, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 3, j + 1, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 3, j + 1, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 3, j + 2, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 3, j + 2, k + 1, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 3, j + 2, k + 2, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 3, j + 2, k + 3, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 3, j + 2, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 4, j + 1, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 4, j + 1, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 4, j + 2, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.purpleGlowstone.blockID);
		world.setBlock(i + 4, j + 2, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 1,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 2,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 3,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 4,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 1,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 2,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 3,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 4,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 0,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 1,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 2,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 3,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 4,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 5,
				Blocks.purpleCaveStoneBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Block.doorWood.blockID);
		Methods.echo("Wanderer House spawned at: " + i + " " + j + " " + k);
		return true;
	}
}