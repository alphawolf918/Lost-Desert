package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleCaveStoneBricks extends Block {
	public PurpleCaveStoneBricks(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("purplecavestonebricks");
		this.setResistance(8.9F);
		this.setHardness(0.4F);
		this.setLightValue(0.8F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "purplecavestonebrick");
	}
}