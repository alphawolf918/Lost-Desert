package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreepStone extends Block {
	public CreepStone(int id) {
		super(id, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setHardness(6F);
		this.setResistance(9.9F);
		this.setUnlocalizedName("creepstone");
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.creepCobble.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "creepstone");
	}
}