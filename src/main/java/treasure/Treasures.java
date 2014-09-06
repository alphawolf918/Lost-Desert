package idim.treasure;

import idim.dims.testdim.worldgen.LDTreasure;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public final class Treasures {
	
	public static ArrayList<String> chestTypes = new ArrayList<String>();
	
	public static void init() {
		addChestTypes();
	}
	
	public static void addChestTypes() {
		chestTypes.add(ChestGenHooks.DUNGEON_CHEST);
		chestTypes.add(ChestGenHooks.MINESHAFT_CORRIDOR);
		chestTypes.add(ChestGenHooks.PYRAMID_DESERT_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CORRIDOR);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CROSSING);
		chestTypes.add(ChestGenHooks.STRONGHOLD_LIBRARY);
		chestTypes.add(ChestGenHooks.VILLAGE_BLACKSMITH);
	}
	
	public static void addChest(int i, int j, int k, Random rand, World world,
			String chestType) {
		int chestX = i;
		int chestY = j;
		int chestZ = k;
		int chestRand = (int) (Math.random() * Math.floor(2));
		boolean isBigChest = (chestRand == 1) ? true : false;
		String chestString = chestX + " " + chestY + " " + chestZ;
		LDTreasure.addChest(world, rand, chestX, chestY, chestZ,
				isBigChest,
				chestType);
	}
	
	public static String pickChestType() {
		return chestTypes.get((int) (Math.random() * chestTypes.size()));
	}
}