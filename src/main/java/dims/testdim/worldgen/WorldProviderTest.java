package idim.dims.testdim.worldgen;

import idim.biomes.Biomes;
import idim.dims.testdim.TestDim;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderTest extends WorldProvider {
	
	@Override
	public String getDimensionName() {
		return "Lost Desert";
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(
				Biomes.lostDesert, 6F, 0.0F);
		this.dimensionId = TestDim.dimId;
	}
	
	public int getSkyColorByTemp(float f) {
		return 0x00ee22;
	}
	
	@Override
	public String getWelcomeMessage()
	{
		return "Entering the Lost Desert..";
	}
	
	@Override
	public String getDepartMessage() {
		return "Leaving the Lost Desert..";
	}
	
	@Override
	public double getMovementFactor() {
		return 4.0;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public String getSaveFolder() {
		return "DIM10";
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public Vec3 getFogColor(float f, float f1) {
		float f2 = MathHelper.cos(1.4F) * 2.0F + 0.5F;
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		float f3 = 0.0F;
		float f4 = 1.0F;
		float f5 = 0.0F;
		f3 *= f2 * 0.94F + 0.09F;
		f4 *= f2 * 0.94F + 0.06F;
		f5 *= f2 * 0.91F + 0.09F;
		return Vec3.createVectorHelper(f3, f4, f5);
	}
	
	@Override
	public boolean isSkyColored() {
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	@SideOnly(Side.SERVER)
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderTestDim(worldObj, worldObj.getSeed(), true);
	}
}