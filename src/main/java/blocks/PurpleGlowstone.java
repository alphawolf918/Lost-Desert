package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.items.Items;
import idim.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleGlowstone extends Block {
	public PurpleGlowstone(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("lostglowstone");
		this.setHardness(0.2F);
		this.setResistance(10F);
		this.setLightValue(1F);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Items.purpleGlowstoneDust.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		return 1 + par1Rand.nextInt(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "lostglowstone");
	}
}
