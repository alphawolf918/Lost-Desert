package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PolishedLostCrystal extends Block {
	public PolishedLostCrystal(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("polishedlostcrystal");
		this.setResistance(6F);
		this.setHardness(1.8F);
		this.setLightValue(1.0F);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "polishedlostcrystal");
	}
}