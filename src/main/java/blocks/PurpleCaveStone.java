package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleCaveStone extends Block {
	public PurpleCaveStone(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("purplecavestone");
		this.setResistance(6F);
		this.setHardness(4F);
		this.setLightValue(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.purpleCobble.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "purplecavestone");
	}
}