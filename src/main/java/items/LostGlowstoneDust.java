package idim.items;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LostGlowstoneDust extends Item {
	public LostGlowstoneDust(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("lostglowstonedust");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "lostglowstone_dust");
	}
}