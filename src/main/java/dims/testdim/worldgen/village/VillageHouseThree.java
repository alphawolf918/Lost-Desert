package idim.dims.testdim.worldgen.village;

import idim.blocks.Blocks;
import idim.methods.Methods;
import idim.treasure.Treasures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class VillageHouseThree extends WorldGenerator
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
	
	public VillageHouseThree() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		Methods.echo("Attempting to spawn village house three..");
		if (!LocationIsValidSpawn(world, i, j, k)) {
			Methods.echo("Failed");
			return false;
		}
		
		world.setBlock(i + 0, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 1, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 1, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 5, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 1, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 1, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 1, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 1, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 2, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 2, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 2, k + 2, Blocks.purpleGlass.blockID);
		world.setBlock(i + 0, j + 2, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 2, k + 4, Blocks.purpleGlass.blockID);
		world.setBlock(i + 0, j + 2, k + 5, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 2, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 2, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 2, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 2, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 3, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 3, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 5, Blocks.palmPlanks.blockID);
		world.setBlock(i + 0, j + 3, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 3, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 3, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 3, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 0, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 0, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 1, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 2, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 3, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 4, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 5, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 6, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 7, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 8, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 0, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 1, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 1, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 1, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 2, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 2, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 2, k + 9, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 1, j + 3, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 3, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 3, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 3, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 1, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 1, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 1, k + 2, Block.fence.blockID);
		world.setBlock(i + 2, j + 1, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 1, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 1, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 1, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 2, k + 0, Blocks.purpleGlass.blockID);
		world.setBlock(i + 2, j + 2, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 2, k + 9, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 2, j + 3, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 3, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 3, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 3, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 2, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 2, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 1, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 1, k + 5, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 1, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 2, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 2, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 2, k + 5, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 2, k + 6, Block.furnaceIdle.blockID);
		world.setBlock(i + 3, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 3, k + 4, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 3, k + 5, Blocks.palmPlanks.blockID);
		world.setBlock(i + 3, j + 3, k + 6, Block.furnaceIdle.blockID);
		WorldGenLostVillage.spawnVillager(world, i + 4, j + 2, k + 7, 3);
		world.setBlock(i + 3, j + 4, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 3, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 3, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 1, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 2, k + 0, Blocks.purpleGlass.blockID);
		world.setBlock(i + 4, j + 2, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 3, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 4, j + 4, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 4, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 4, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 5, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 1, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 5, j + 1, k + 8, Block.stoneDoubleSlab.blockID);
		world.setBlock(i + 5, j + 2, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 5, j + 3, k + 0, Blocks.palmPlanks.blockID);
		world.setBlock(i + 5, j + 3, k + 3, Blocks.palmPlanks.blockID);
		world.setBlock(i + 5, j + 4, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 5, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 5, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 0, k + 0, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 3, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 0, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 1, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 1, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 6, j + 1, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 6, j + 1, k + 3, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 1, k + 5, Block.fence.blockID);
		world.setBlock(i + 6, j + 1, k + 9, Block.fence.blockID);
		Treasures.addChest(i + 1, j + 1, k + 5, rand, world,
				ChestGenHooks.VILLAGE_BLACKSMITH);
		world.setBlock(i + 6, j + 2, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 2, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 6, j + 2, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 6, j + 2, k + 3, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 2, k + 5, Block.fence.blockID);
		world.setBlock(i + 6, j + 2, k + 9, Block.fence.blockID);
		world.setBlock(i + 6, j + 3, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 3, k + 1, Blocks.palmPlanks.blockID);
		world.setBlock(i + 6, j + 3, k + 2, Blocks.palmPlanks.blockID);
		world.setBlock(i + 6, j + 3, k + 3, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 3, k + 5, Block.fence.blockID);
		world.setBlock(i + 6, j + 3, k + 9, Block.fence.blockID);
		world.setBlock(i + 6, j + 4, k + 0, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 4, k + 1, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 2, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 3, Blocks.palmLog.blockID);
		world.setBlock(i + 6, j + 4, k + 4, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 8, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 4, k + 9, Blocks.purpleCobble.blockID);
		world.setBlock(i + 6, j + 5, k + 0, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 1, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 2, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 3, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 4, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 5, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 6, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 7, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 8, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 6, j + 5, k + 9, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 1, j + 1, k + 7, Block.lavaStill.blockID);
		world.setBlock(i + 1, j + 1, k + 8, Block.lavaStill.blockID);
		world.setBlock(i + 2, j + 2, k + 2, Block.pressurePlatePlanks.blockID);
		Methods.echo("Success!");
		return true;
	}
}