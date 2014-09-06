package idim.items;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Zinc extends Item {
	public Zinc(int par1) {
		super(par1);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("zincingot");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "zincingot");
	}
}