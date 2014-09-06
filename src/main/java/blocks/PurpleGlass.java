package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleGlass extends Block {
	public PurpleGlass(int id) {
		super(id, Material.glass);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("lostglass");
		this.setResistance(0.2F);
		this.setHardness(0.6F);
		this.setLightValue(0.5F);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "purpleglass");
	}
}
