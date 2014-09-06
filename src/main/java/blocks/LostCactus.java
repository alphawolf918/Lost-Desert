package idim.blocks;

import idim.creativetabs.ModTabs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LostCactus extends Block implements IPlantable {
	@SideOnly(Side.CLIENT)
	private Icon cactusTopIcon;
	@SideOnly(Side.CLIENT)
	private Icon cactusBottomIcon;
	
	protected LostCactus(int par1) {
		super(par1, Material.cactus);
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("lostcactus");
		this.setStepSound(Block.soundClothFootstep);
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant) {
		return (plant.getPlantID(world, x, y, z) == Blocks.lostCactus.blockID);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		if (par1World.isAirBlock(par2, par3 + 1, par4)) {
			int l;
			
			for (l = 1; par1World.getBlockId(par2, par3 - l, par4) == this.blockID; ++l) {
				;
			}
			
			if (l < 3) {
				int i1 = par1World.getBlockMetadata(par2, par3, par4);
				
				if (i1 == 15) {
					par1World.setBlock(par2, par3 + 1, par4, this.blockID);
					par1World
							.setBlockMetadataWithNotify(par2, par3, par4, 0, 4);
					this.onNeighborBlockChange(par1World, par2, par3 + 1, par4,
							this.blockID);
				} else {
					par1World.setBlockMetadataWithNotify(par2, par3, par4,
							i1 + 1, 4);
				}
			}
		}
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		float f = 0.0625F;
		return AxisAlignedBB.getAABBPool().getAABB(par2 + f,
				par3, par4 + f,
				par2 + 1 - f,
				par3 + 1 - f,
				par4 + 1 - f);
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns the bounding box of the wired rectangular prism to render.
	 */
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		float f = 0.0625F;
		return AxisAlignedBB.getAABBPool().getAABB(par2 + f,
				par3, par4 + f,
				par2 + 1 - f, par3 + 1,
				par4 + 1 - f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.cactusTopIcon : (par1 == 0
				? this.cactusBottomIcon
				: this.blockIcon);
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return 13;
	}
	
	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return !super.canPlaceBlockAt(par1World, par2, par3, par4)
				? false
				: this.canBlockStay(par1World, par2, par3, par4);
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5) {
		if (!this.canBlockStay(par1World, par2, par3, par4)) {
			par1World.destroyBlock(par2, par3, par4, true);
		}
	}
	
	/**
	 * Can this block stay at this position. Similar to canPlaceBlockAt except
	 * gets checked often with plants.
	 */
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		if (par1World.getBlockMaterial(par2 - 1, par3, par4).isSolid()) {
			return false;
		} else if (par1World.getBlockMaterial(par2 + 1, par3, par4).isSolid()) {
			return false;
		} else if (par1World.getBlockMaterial(par2, par3, par4 - 1).isSolid()) {
			return false;
		} else if (par1World.getBlockMaterial(par2, par3, par4 + 1).isSolid()) {
			return false;
		} else {
			int l = par1World.getBlockId(par2, par3 - 1, par4);
			return blocksList[l] != null
					&& blocksList[l].canSustainPlant(par1World, par2, par3 - 1,
							par4, ForgeDirection.UP, this);
		}
	}
	
	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		par5Entity.attackEntityFrom(DamageSource.cactus, 2.5F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("awid:lostcactus_side");
		this.cactusTopIcon = par1IconRegister
				.registerIcon("awid:lostcactus_top");
		this.cactusBottomIcon = par1IconRegister
				.registerIcon("awid:lostcactus_bottom");
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		return EnumPlantType.Desert;
	}
	
	@Override
	public int getPlantID(World world, int x, int y, int z) {
		return this.blockID;
	}
	
	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		return -1;
	}
}