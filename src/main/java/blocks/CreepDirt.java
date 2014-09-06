package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreepDirt extends Block {
	public CreepDirt(int par1) {
		super(par1, Material.ground);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("creepdirt");
		this.setHardness(1.5F);
		this.setResistance(0.4F);
		this.setStepSound(Block.soundGravelFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "shovel", 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "creepdirt");
	}
}