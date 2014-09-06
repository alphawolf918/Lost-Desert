package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreepCobble extends Block {
	public CreepCobble(int id) {
		super(id, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("creepcobble");
		this.setResistance(5F);
		this.setHardness(3F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "creepcobblestone");
	}
}