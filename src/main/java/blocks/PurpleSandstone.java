package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleSandstone extends Block {
	public PurpleSandstone(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("purplesandstone");
		this.setHardness(4F);
		this.setResistance(6F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "purplestone");
	}
}