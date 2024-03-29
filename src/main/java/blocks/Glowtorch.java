package idim.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Glowtorch extends Block
{
	protected Glowtorch(int par1)
	{
		super(par1, Material.circuits);
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("glowtorch");
		this.setHardness(0.0F);
		this.setLightValue(0.9565F);
		this.setStepSound(Block.soundWoodFootstep);
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4)
	{
		return null;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return 2;
	}
	
	/**
	 * Gets if we can place a torch on a block.
	 */
	private boolean canPlaceTorchOn(World par1World, int par2, int par3,
			int par4)
	{
		if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
		{
			return true;
		}
		else
		{
			int l = par1World.getBlockId(par2, par3, par4);
			return (Block.blocksList[l] != null && Block.blocksList[l]
					.canPlaceTorchOnTop(par1World, par2, par3, par4));
		}
	}
	
	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) ||
				par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true)
				||
				par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true)
				||
				par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)
				||
				canPlaceTorchOn(par1World, par2, par3 - 1, par4);
	}
	
	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4,
			int par5, float par6, float par7, float par8, int par9)
	{
		int j1 = par9;
		
		if (par5 == 1 && this.canPlaceTorchOn(par1World, par2, par3 - 1, par4))
		{
			j1 = 5;
		}
		
		if (par5 == 2
				&& par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH,
						true))
		{
			j1 = 4;
		}
		
		if (par5 == 3
				&& par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH,
						true))
		{
			j1 = 3;
		}
		
		if (par5 == 4
				&& par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST,
						true))
		{
			j1 = 2;
		}
		
		if (par5 == 5
				&& par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST,
						true))
		{
			j1 = 1;
		}
		
		return j1;
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);
		
		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			this.onBlockAdded(par1World, par2, par3, par4);
		}
	}
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
			}
			else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST,
					true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			}
			else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH,
					true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			}
			else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH,
					true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			}
			else if (this.canPlaceTorchOn(par1World, par2, par3 - 1, par4))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
			}
		}
		
		this.dropTorchIfCantStay(par1World, par2, par3, par4);
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5)
	{
		this.func_94397_d(par1World, par2, par3, par4, par5);
	}
	
	protected boolean func_94397_d(World par1World, int par2, int par3,
			int par4, int par5)
	{
		if (this.dropTorchIfCantStay(par1World, par2, par3, par4))
		{
			int i1 = par1World.getBlockMetadata(par2, par3, par4);
			boolean flag = false;
			
			if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)
					&& i1 == 1)
			{
				flag = true;
			}
			
			if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true)
					&& i1 == 2)
			{
				flag = true;
			}
			
			if (!par1World
					.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true)
					&& i1 == 3)
			{
				flag = true;
			}
			
			if (!par1World
					.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)
					&& i1 == 4)
			{
				flag = true;
			}
			
			if (!this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)
					&& i1 == 5)
			{
				flag = true;
			}
			
			if (flag)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4,
						par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockToAir(par2, par3, par4);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Tests if the block can remain at its current location and will drop as an
	 * item if it is unable to stay. Returns True if it can stay and False if it
	 * drops. Args: world, x, y, z
	 */
	protected boolean dropTorchIfCantStay(World par1World, int par2, int par3,
			int par4)
	{
		if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
		{
			if (par1World.getBlockId(par2, par3, par4) == this.blockID)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4,
						par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockToAir(par2, par3, par4);
			}
			
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Ray traces through the blocks collision from start vector to end vector
	 * returning a ray trace hit. Args: world, x, y, z, startVec, endVec
	 */
	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2,
			int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
		float f = 0.15F;
		
		if (l == 1)
		{
			this.setBlockBounds(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
		}
		else if (l == 2)
		{
			this.setBlockBounds(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F,
					0.5F + f);
		}
		else if (l == 3)
		{
			this.setBlockBounds(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
		}
		else if (l == 4)
		{
			this.setBlockBounds(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f,
					0.8F, 1.0F);
		}
		else
		{
			f = 0.1F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F,
					0.5F + f);
		}
		
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3,
				par6Vec3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "glowtorch");
	}
}