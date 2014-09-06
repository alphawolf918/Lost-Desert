package idim.items;

import idim.achievements.Achievements;
import idim.blocks.Blocks;
import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LostPearl extends Item {
	
	public LostPearl(int par1) {
		super(par1);
		this.setUnlocalizedName("lostpearl");
		this.setCreativeTab(ModTabs.ldTab);
		this.setMaxDamage(2);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		
		int direction = MathHelper
				.floor_double(par2EntityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (!par3World.isRemote) {
			if (direction == 1 || direction == 3) {
				par3World.setBlock(par4, par5 + 1, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 1, par6 + 1,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 1, par6 + 2,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 1, par6 - 1,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4, par5 + 2, par6 - 1,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 3, par6 - 1,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 4, par6 - 1,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 5, par6 - 1,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4, par5 + 2, par6 + 2,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 3, par6 + 2,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 2,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 5, par6 + 2,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4, par5 + 5, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4, par5 + 5, par6 + 1,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4, par5 + 2, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 3, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 4, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 2, par6 + 1,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 3, par6 + 1,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 4, par6 + 1,
						Blocks.portalBlock2.blockID);
			} else {
				par3World.setBlock(par4, par5 + 1, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 + 1, par5 + 1, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 + 2, par5 + 1, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 - 1, par5 + 1, par6,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4 - 1, par5 + 2, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 - 1, par5 + 3, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 - 1, par5 + 4, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 - 1, par5 + 5, par6,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4 + 2, par5 + 2, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 + 2, par5 + 3, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 + 2, par5 + 4, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 + 2, par5 + 5, par6,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4, par5 + 5, par6,
						Blocks.creepStone.blockID);
				par3World.setBlock(par4 + 1, par5 + 5, par6,
						Blocks.creepStone.blockID);
				
				par3World.setBlock(par4, par5 + 2, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 3, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4, par5 + 4, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4 + 1, par5 + 2, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4 + 1, par5 + 3, par6,
						Blocks.portalBlock2.blockID);
				par3World.setBlock(par4 + 1, par5 + 4, par6,
						Blocks.portalBlock2.blockID);
			}
			if (!par2EntityPlayer.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(1, par2EntityPlayer);
			}
			par2EntityPlayer.addStat(Achievements.createPortal, 5);
			return true;
		} else {
			return false;
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "lost_pearl");
	}
}