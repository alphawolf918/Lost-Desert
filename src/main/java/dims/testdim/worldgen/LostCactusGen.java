package idim.dims.testdim.worldgen;

import idim.blocks.Blocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LostCactusGen extends WorldGenerator
{
	@Override
	public boolean generate(World par1World, Random par2Random, int par3,
			int par4, int par5)
	{
		for (int l = 0; l < 10; ++l)
		{
			int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
			int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
			int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
			
			if (par1World.isAirBlock(i1, j1, k1))
			{
				int l1 = 1 + par2Random.nextInt(par2Random.nextInt(3) + 1);
				
				for (int i2 = 0; i2 < l1; ++i2)
				{
					if (Blocks.lostCactus.canBlockStay(par1World, i1, j1 + i2,
							k1))
					{
						par1World.setBlock(i1, j1 + i2, k1,
								Blocks.lostCactus.blockID, 0, 2);
					}
				}
			}
		}
		return true;
	}
}