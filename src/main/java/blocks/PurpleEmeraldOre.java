package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleEmeraldOre extends Block {
	public PurpleEmeraldOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("purpleemeraldore");
		this.setHardness(9F);
		this.setResistance(2F);
		this.setStepSound(Block.soundStoneFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Item.emerald.itemID;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
			int meta) {
		this.dropXpOnBlockBreak(world, x, y, z, 85);
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		return 1 + par1Rand.nextInt(2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "lost_emerald_ore");
	}
}