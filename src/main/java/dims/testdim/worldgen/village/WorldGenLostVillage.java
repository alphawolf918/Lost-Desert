package idim.dims.testdim.worldgen.village;

import idim.blocks.Blocks;
import idim.methods.Methods;
import idim.mobs.entities.EntityLostVillager;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLostVillage extends WorldGenerator {
	
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
			} else if (blockID == Blocks.creepStone.blockID
					&& blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public WorldGenLostVillage() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		Methods.echo("Attempting to spawn village..");
		if (!LocationIsValidSpawn(world, i, j, k)) {
			Methods.echo("Failed");
			return false;
		}
		
		int numGen = 0;
		if ((new VillageHouseOne()).generate(world, rand, i, (j - 3), k)) {
			numGen++;
		}
		if ((new VillageHouseTwo()).generate(world, rand, i + 25,
				j + 8, k + 25)) {
			numGen++;
		}
		if ((new VillageHouseThree()).generate(world, rand,
				i + 15, j + 8,
				k + 15)) {
			numGen++;
		}
		if (numGen > 0) {
			Methods.echo("Village spawned: " + i + " " + j + " " + k);
		} else {
			Methods.echo("No village houses were spawned. Spawning canceled.");
		}
		return true;
	}
	
	public static void spawnVillager(World world, int i, int j, int k,
			int profession) {
		int tries = 0;
		int spawnX = i;
		int spawnY = j;
		int spawnZ = k;
		if (world.isAirBlock(spawnX, spawnY, spawnZ)) {
			EntityLostVillager villager = new EntityLostVillager(world,
					profession);
			villager.setLocationAndAngles(spawnX, spawnY, spawnZ, 0, 0);
			villager.setProfession(profession);
			villager.setHomeArea(spawnX, spawnY, spawnZ,
					(new Random()).nextInt(5));
			world.spawnEntityInWorld(villager);
			Methods.echo(villager.getCustomNameTag() + " spawned");
		} else {
			if (tries < 2) {
				tries++;
				spawnVillager(world, spawnX + tries, spawnY, spawnZ + tries,
						profession);
			} else {
				Methods.echo("Block was not free at coords.");
			}
		}
	}
}