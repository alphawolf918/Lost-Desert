package idim.managers;

import idim.blocks.Blocks;
import idim.dims.testdim.structures.LostRuins;
import idim.dims.testdim.structures.WorldGenCrystalTower;
import idim.dims.testdim.worldgen.LostCactusGen;
import idim.dims.testdim.worldgen.WorldGenLDMinable;
import idim.dims.testdim.worldgen.WorldGenLDMinable2;
import idim.dims.testdim.worldgen.WorldGenOasis;
import idim.dims.testdim.worldgen.WorldGenTreasureChest;
import idim.dims.testdim.worldgen.village.WorldGenLostVillage;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 10:
			generateLD(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		// Zinc Ore
		this.addOreSpawn(Blocks.zincOre, world, random, x, z, 16, 16,
				2 + random.nextInt(2), 34, 5, 12);
	}
	
	private void generateLD(World world, Random random, int x, int z) {
		// Purple Cavestone
		this.addLDOreSpawn(Blocks.purpleCaveStone, world, random, x, z, 16, 16,
				4 + random.nextInt(58), 96, 1, 55);
		// Creepstone
		this.addLDOreSpawn(Blocks.creepStone, world, random, x, z, 16, 16,
				4 + random.nextInt(40), 45, 1, 42);
		// Creepdirt
		this.addLDOreSpawn(Blocks.creepDirt, world, random, x, z, 16, 16,
				4 + random.nextInt(40), 35, 1, 42);
		// Purple Coal Ore
		this.addLDOreSpawn(Blocks.purpleCoalOre, world, random, x, z, 16, 16,
				8 + random.nextInt(6), 30, 1, 56);
		// Purple Iron Ore
		this.addLDOreSpawn(Blocks.purpleIronOre, world, random, x, z, 16, 16,
				4 + random.nextInt(4), 30, 1, 50);
		// Purple Gold Ore
		this.addLDOreSpawn(Blocks.purpleGoldOre, world, random, x, z, 16, 16,
				4 + random.nextInt(4), 10, 1, 30);
		// Purple Diamond Ore
		this.addLDOreSpawn(Blocks.purpleDiamondOre, world, random, x, z, 16,
				16,
				2 + random.nextInt(2), 15, 11, 14);
		// Purple Diamond Ore 2
		this.addLDOreSpawn(Blocks.diamondOre, world, random, x, z, 16,
				16,
				2 + random.nextInt(2), 15, 11, 14);
		// Purple Zinc Ore
		this.addLDOreSpawn(Blocks.lostZincOre, world, random, x, z, 16,
				16,
				2 + random.nextInt(2), 18, 11, 14);
		// Purple Emerald Ore
		this.addLDOreSpawn(Blocks.purpleEmeraldOre, world, random, x, z, 16,
				16,
				1 + random.nextInt(2), 8, 11, 12);
		// Purple Redstone Ore
		this.addLDOreSpawn(Blocks.lostRedstoneOre, world, random, x, z, 16,
				16,
				4 + random.nextInt(4), 16, 2, 20);
		// Glowing Loststone
		this.addLDOreSpawn(Blocks.purpleGlowstone, world, random, x, z, 16, 16,
				4 + random.nextInt(40), 15, 1, 42);
		// Lostfish Block
		this.addLDOreSpawn(Blocks.lostFishBlock, world, random, x, z, 16, 16,
				4 + random.nextInt(10), 35, 1, 32);
		// Lost Cactus
		this.spawnStructure(42, 60, world, random, x,
				world.getHeightValue(x, z), z,
				(new LostCactusGen()));
		// Dead Bush
		this.spawnStructure(32, 80, world, random, x,
				world.getHeightValue(x, z), z,
				(new WorldGenDeadBush(Block.deadBush.blockID)));
		// Lost Ruins
		this.spawnStructure(10, 1260, world, random, x,
				world.getHeightValue(x, z), z,
				(new LostRuins()));
		// Crystal Tower
		this.spawnStructure(10, 1260, world, random, x,
				world.getHeightValue(x, z), z,
				(new WorldGenCrystalTower()));
		// Chest Gen
		this.spawnStructure(10, 1361, world, random, x,
				world.getHeightValue(x, z), z,
				(new WorldGenTreasureChest()));
		// Oasis
		this.spawnStructure(5, 4561, world, random, x,
				world.getHeightValue(x, z), z,
				(new WorldGenOasis()));
		
		// Lost Village
		this.spawnStructure(10, 861, world, random, x,
				world.getHeightValue(x, z), z, (new WorldGenLostVillage()));
	}
	
	/**
	 * Spawns a structure in the world
	 * 
	 */
	public static void spawnStructure(int minChance, int maxChance,
			World world,
			Random random, int x, int y, int z, WorldGenerator wg) {
		if (random.nextInt(maxChance) == minChance) {
			wg.generate(world, random, x, y, z);
		}
	}
	
	public void addLDOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block.blockID, maxVeinSize)).generate(
					world, random, posX, posY, posZ);
		}
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenLDMinable(block.blockID, maxVeinSize)).generate(
					world, random, posX, posY, posZ);
		}
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenLDMinable2(block.blockID, maxVeinSize)).generate(
					world, random, posX, posY, posZ);
		}
	}
	
	public void addOreSpawn(Block block, World world, Random random,
			int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY) {
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block.blockID, maxVeinSize)).generate(world,
					random, posX, posY, posZ);
		}
	}
}