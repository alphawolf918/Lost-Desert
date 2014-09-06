package idim.handlers;

import idim.achievements.Achievements;
import idim.items.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPickupNotifier;

public class PickUpHandler implements IPickupNotifier {
	
	@Override
	public void notifyPickup(EntityItem item, EntityPlayer player) {
		int itemID = item.getEntityItem().itemID;
		if (itemID == Items.coconut.itemID) {
			player.addStat(Achievements.coconutBunch, 15);
		} else if (itemID == Items.purpleDiamond.itemID) {
			player.addStat(Achievements.foundEm, 50);
		} else if (itemID == Items.powerRod.itemID) {
			player.addStat(Achievements.hotRod, 25);
		} else if (itemID == Items.zincIngot.itemID) {
			player.addStat(Achievements.zincd, 5);
		}
	}
}