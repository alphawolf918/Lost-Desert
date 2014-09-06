package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.Ids;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleSand extends BlockSand {
	
	public PurpleSand(int id) {
		super(id, Material.sand);
		this.setCreativeTab(ModTabs.ldTab);
		this.setHardness(0.1F);
		this.setResistance(0.1F);
		this.setLightValue(0.125F);
		this.setUnlocalizedName("purplesand");
		this.setStepSound(Block.soundSandFootstep);
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant) {
		int plantID = plant.getPlantID(world, x, y, z);
		return (plantID == Blocks.lostCactus.blockID
				|| plantID == Block.cactus.blockID
				|| plantID == Block.deadBush.blockID || plantID == Ids.palmWoodSaplingID);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "purplesand2");
	}
}