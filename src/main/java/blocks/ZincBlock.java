package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZincBlock extends Block {
	public ZincBlock(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("zincblock");
		this.setHardness(4F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "zincblock");
	}
}