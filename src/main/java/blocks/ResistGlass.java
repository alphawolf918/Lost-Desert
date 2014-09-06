package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ResistGlass extends Block {
	public ResistGlass(int id) {
		super(id, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("resistglass");
		this.setResistance(10F);
		this.setHardness(0.6F);
		this.setLightValue(0.9F);
		this.setStepSound(Block.soundGlassFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "resist_glass");
	}
}