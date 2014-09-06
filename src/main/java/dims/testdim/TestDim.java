package idim.dims.testdim;

import idim.dims.testdim.worldgen.WorldProviderTest;
import net.minecraftforge.common.DimensionManager;

public class TestDim {
	
	public static int dimId = 10;
	
	public static void init() {
		DimensionManager.registerProviderType(dimId, WorldProviderTest.class,
				false);
		DimensionManager.registerDimension(dimId, dimId);
	}
}