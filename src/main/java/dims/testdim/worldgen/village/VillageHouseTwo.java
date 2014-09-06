package idim.dims.testdim.worldgen.village;

import idim.blocks.Blocks;
import idim.methods.Methods;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VillageHouseTwo extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] { Blocks.purpleSand.blockID,
				Blocks.creepStone.blockID, Blocks.creepDirt.blockID,
				Blocks.purpleCaveStone.blockID, Blocks.purpleCobble.blockID };
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
	
	public VillageHouseTwo() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		Methods.echo("Attempting to spawn village house two..");
		if (!LocationIsValidSpawn(world, i, j, k)) {
			Methods.echo("Failed");
			return false;
		}
		
		world.setBlock(i + 0, j + 1, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 1, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 1, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 2, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 2, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 2, k + 2, Blocks.purpleGlass.blockID);
		world.setBlock(i + 0, j + 2, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 2, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 3, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 3, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 4, k + 1, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 4, k + 2, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 4, k + 3, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 4, k + 4, Blocks.palmLog.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 2, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 3, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 1, j + 4, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Blocks.palmLog.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 1, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 2, k + 4, Blocks.purpleGlass.blockID);
		world.setBlock(i + 2, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 3, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 4, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.palmLog.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Blocks.purpleCobble.blockID);
		WorldGenLostVillage.spawnVillager(world, i + 3, j + 2, k + 2, 2);
		world.setBlock(i + 3, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 1, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 2, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 3, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.palmLog.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 1, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 1, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 1, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 1, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 1, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 2, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 2, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 2, k + 2, Blocks.purpleGlass.blockID);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 2, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 3, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 3, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 3, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 3, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 4, j + 4, k + 1, Blocks.palmLog.blockID);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.palmLog.blockID);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.palmLog.blockID);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.palmLog.blockID);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.glowTorch.blockID);
		Methods.echo("Success!");
		return true;
	}
}