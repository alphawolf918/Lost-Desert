package idim.handlers;

import idim.achievements.Achievements;
import idim.items.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		if (item.itemID == Items.lostPearl.itemID) {
			player.addStat(Achievements.lostPearl, 40);
		} else if (item.itemID == Items.lostSword.itemID) {
			player.addStat(Achievements.powerOfTheBlade, 60);
		}
	}
	
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO
	}
}