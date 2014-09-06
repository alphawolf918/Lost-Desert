package idim.biomes;

import idim.blocks.Blocks;
import idim.dims.testdim.worldgen.WorldGenDesertWellsLD;
import idim.dims.testdim.worldgen.WorldGenPalmwoodTree;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class LostDesert extends BiomeGenBase {
	
	public LostDesert(int par1) {
		super(par1);
		this.waterColorMultiplier = 0x8b008b;
		this.setBiomeName("Lost Desert");
		this.setColor(Biomes.biomeColor);
		this.temperature = 8F;
		this.rainfall = 0F;
		this.setMinMaxHeight(0.1F, 0.1F);
		this.setDisableRain();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.topBlock = (byte) Blocks.purpleSand.blockID;
		this.fillerBlock = (byte) Blocks.creepStone.blockID;
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		
		if (par2Random.nextInt(1000) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenDesertWellsLD worldgendesertwells = new WorldGenDesertWellsLD();
			worldgendesertwells.generate(par1World, par2Random, k,
					par1World.getHeightValue(k, l) + 1, l);
		}
		
		if (par2Random.nextInt(100) <= 40) {
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenPalmwoodTree worldgenpalmwood = new WorldGenPalmwoodTree();
			worldgenpalmwood.generate(par1World, par2Random, k,
					par1World.getHeightValue(k, l) + 1, l);
		}
	}
}