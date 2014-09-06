package idim.blocks;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import idim.mobs.entities.EntityLostFish;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LostFishBlock extends Block {
	public LostFishBlock(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("lostfish");
		this.setResistance(0.1F);
		this.setHardness(0.1F);
		this.setLightValue(0.2F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3,
			int par4, int par5) {
		if (!par1World.isRemote) {
			int rand = (int) (Math.floor(10) * Math.random());
			EntityLostFish entitysilverfish = new EntityLostFish(
					par1World);
			entitysilverfish.setLocationAndAngles(par2 + 0.5D,
					par3, par4 + 0.5D, 0.0F, 0.0F);
			if (rand >= 5 && par1World.difficultySetting != 0) {
				par1World.spawnEntityInWorld(entitysilverfish);
				entitysilverfish.spawnExplosionParticle();
			}
		}
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.purpleCobble.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "purplecavestone");
	}
}