package idim.items;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Coconut extends ItemFood {
	
	public Coconut(int par1) {
		super(par1, 8, false);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("coconut");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "coconut");
	}
}