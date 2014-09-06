package idim.creativetabs;

import idim.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class LostDesertCTab extends CreativeTabs {
	public LostDesertCTab(int id, String name) {
		super(id, name);
	}
	
	@Override
	public int getTabIconItemIndex() {
		return Items.lostPearl.itemID;
	}
}