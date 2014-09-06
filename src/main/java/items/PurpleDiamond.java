package idim.items;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleDiamond extends Item {
	public PurpleDiamond(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("purplediamond");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "lostdiamond");
	}
}