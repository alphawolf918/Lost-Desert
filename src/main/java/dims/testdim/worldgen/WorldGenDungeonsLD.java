package idim.dims.testdim.worldgen;

import idim.blocks.Blocks;
import idim.items.Items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class WorldGenDungeonsLD extends WorldGenerator
{
	public static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[] {
			new WeightedRandomChestContent(Item.saddle.itemID, 0, 1, 1, 10),
			new WeightedRandomChestContent(Item.ingotIron.itemID, 0, 1, 4, 10),
			new WeightedRandomChestContent(Item.bread.itemID, 0, 1, 1, 10),
			new WeightedRandomChestContent(Item.wheat.itemID, 0, 1, 4, 10),
			new WeightedRandomChestContent(Item.gunpowder.itemID, 0, 1, 4, 10),
			new WeightedRandomChestContent(Item.silk.itemID, 0, 1, 4, 10),
			new WeightedRandomChestContent(Item.bucketEmpty.itemID, 0, 1, 1, 10),
			new WeightedRandomChestContent(Item.appleGold.itemID, 0, 1, 1, 1),
			new WeightedRandomChestContent(Item.redstone.itemID, 0, 1, 4, 10),
			new WeightedRandomChestContent(Item.record13.itemID, 0, 1, 1, 10),
			new WeightedRandomChestContent(Item.recordCat.itemID, 0, 1, 1, 10),
			new WeightedRandomChestContent(Item.nameTag.itemID, 0, 1, 1, 10),
			new WeightedRandomChestContent(Item.horseArmorGold.itemID, 0, 1, 1,
					2),
			new WeightedRandomChestContent(Item.horseArmorIron.itemID, 0, 1, 1,
					5),
			new WeightedRandomChestContent(Item.horseArmorDiamond.itemID, 0, 1,
					1, 1),
			new WeightedRandomChestContent(Items.purpleDiamond.itemID, 0, 1,
					1, 1),
			new WeightedRandomChestContent(Items.purpleDiamond.itemID, 0, 1,
					1, 2),
			new WeightedRandomChestContent(Items.purpleGlowstoneDust.itemID, 0,
					1, 4, 10)
	};
	
	@Override
	public boolean generate(World par1World, Random par2Random, int par3,
			int par4, int par5)
	{
		byte b0 = 3;
		int l = par2Random.nextInt(2) + 2;
		int i1 = par2Random.nextInt(2) + 2;
		int j1 = 0;
		int k1;
		int l1;
		int i2;
		
		for (k1 = par3 - l - 1; k1 <= par3 + l + 1; ++k1)
		{
			for (l1 = par4 - 1; l1 <= par4 + b0 + 1; ++l1)
			{
				for (i2 = par5 - i1 - 1; i2 <= par5 + i1 + 1; ++i2)
				{
					Material material = par1World.getBlockMaterial(k1, l1, i2);
					
					if (l1 == par4 - 1 && !material.isSolid())
					{
						return false;
					}
					
					if (l1 == par4 + b0 + 1 && !material.isSolid())
					{
						return false;
					}
					
					if ((k1 == par3 - l - 1 || k1 == par3 + l + 1
							|| i2 == par5 - i1 - 1 || i2 == par5 + i1 + 1)
							&& l1 == par4
							&& par1World.isAirBlock(k1, l1, i2)
							&& par1World.isAirBlock(k1, l1 + 1, i2))
					{
						++j1;
					}
				}
			}
		}
		
		if (j1 >= 1 && j1 <= 5)
		{
			for (k1 = par3 - l - 1; k1 <= par3 + l + 1; ++k1)
			{
				for (l1 = par4 + b0; l1 >= par4 - 1; --l1)
				{
					for (i2 = par5 - i1 - 1; i2 <= par5 + i1 + 1; ++i2)
					{
						if (k1 != par3 - l - 1 && l1 != par4 - 1
								&& i2 != par5 - i1 - 1 && k1 != par3 + l + 1
								&& l1 != par4 + b0 + 1 && i2 != par5 + i1 + 1)
						{
							par1World.setBlockToAir(k1, l1, i2);
						}
						else if (l1 >= 0
								&& !par1World.getBlockMaterial(k1, l1 - 1, i2)
										.isSolid())
						{
							par1World.setBlockToAir(k1, l1, i2);
						}
						else if (par1World.getBlockMaterial(k1, l1, i2)
								.isSolid())
						{
							if (l1 == par4 - 1 && par2Random.nextInt(4) != 0)
							{
								par1World.setBlock(k1, l1, i2,
										Blocks.creepStone.blockID, 0, 2);
							}
							else
							{
								par1World.setBlock(k1, l1, i2,
										Blocks.creepCobble.blockID, 0, 2);
							}
						}
					}
				}
			}
			
			k1 = 0;
			
			while (k1 < 2)
			{
				l1 = 0;
				
				while (true)
				{
					if (l1 < 3)
					{
						label101:
						{
							i2 = par3 + par2Random.nextInt(l * 2 + 1) - l;
							int j2 = par5 + par2Random.nextInt(i1 * 2 + 1) - i1;
							
							if (par1World.isAirBlock(i2, par4, j2))
							{
								int k2 = 0;
								
								if (par1World
										.getBlockMaterial(i2 - 1, par4, j2)
										.isSolid())
								{
									++k2;
								}
								
								if (par1World
										.getBlockMaterial(i2 + 1, par4, j2)
										.isSolid())
								{
									++k2;
								}
								
								if (par1World
										.getBlockMaterial(i2, par4, j2 - 1)
										.isSolid())
								{
									++k2;
								}
								
								if (par1World
										.getBlockMaterial(i2, par4, j2 + 1)
										.isSolid())
								{
									++k2;
								}
								
								if (k2 == 1)
								{
									par1World.setBlock(i2, par4, j2,
											Block.chest.blockID, 0, 2);
									TileEntityChest tileentitychest = (TileEntityChest) par1World
											.getBlockTileEntity(i2, par4, j2);
									
									if (tileentitychest != null)
									{
										ChestGenHooks info = ChestGenHooks
												.getInfo(ChestGenHooks.DUNGEON_CHEST);
										WeightedRandomChestContent
												.generateChestContents(
														par2Random,
														info.getItems(par2Random),
														tileentitychest,
														info.getCount(par2Random));
									}
									
									break label101;
								}
							}
							
							++l1;
							continue;
						}
					}
					
					++k1;
					break;
				}
			}
			
			par1World
					.setBlock(par3, par4, par5, Block.mobSpawner.blockID, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) par1World
					.getBlockTileEntity(par3, par4, par5);
			
			if (tileentitymobspawner != null)
			{
				String pickedMob = this.pickMobSpawner(par2Random);
				tileentitymobspawner.getSpawnerLogic().setMobID(pickedMob);
				// System.out.println("Mob Picked: " + pickedMob);
			}
			else
			{
				System.err.println("Failed to fetch mob spawner entity at ("
						+ par3 + ", " + par4 + ", " + par5 + ")");
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Randomly decides which spawner to use in a dungeon
	 */
	public String pickMobSpawner(Random par1Random)
	{
		return DungeonHooks.getRandomDungeonMob(par1Random);
	}
}
