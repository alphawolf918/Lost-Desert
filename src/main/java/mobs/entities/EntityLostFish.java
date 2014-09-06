package idim.mobs.entities;

import idim.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityLostFish extends EntityMob
{
	/**
	 * A cooldown before this entity will search for another Silverfish to join
	 * them in battle.
	 */
	private int allySummonCooldown;
	
	public EntityLostFish(World par1World)
	{
		super(par1World);
		this.setSize(0.3F, 0.7F);
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setAttribute(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setAttribute(0.7000000238418579D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setAttribute(2.0D);
	}
	
	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	@Override
	protected Entity findPlayerToAttack()
	{
		double d0 = 8.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return "mob.silverfish.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.silverfish.hit";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.silverfish.kill";
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			if (this.allySummonCooldown <= 0
					&& (par1DamageSource instanceof EntityDamageSource || par1DamageSource == DamageSource.magic))
			{
				this.allySummonCooldown = 20;
			}
			
			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}
	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (this.attackTime <= 0 && par2 < 1.2F
				&& par1Entity.boundingBox.maxY > this.boundingBox.minY
				&& par1Entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		}
	}
	
	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.silverfish.step", 0.05F, 0.5F);
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId()
	{
		return 0;
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		this.renderYawOffset = this.rotationYaw;
		super.onUpdate();
	}
	
	@Override
	protected void updateEntityActionState()
	{
		super.updateEntityActionState();
		
		if (!this.worldObj.isRemote)
		{
			int i;
			int j;
			int k;
			int l;
			
			if (this.allySummonCooldown > 0)
			{
				--this.allySummonCooldown;
				
				if (this.allySummonCooldown == 0)
				{
					i = MathHelper.floor_double(this.posX);
					j = MathHelper.floor_double(this.posY);
					k = MathHelper.floor_double(this.posZ);
					boolean flag = false;
					
					for (l = 0; !flag && l <= 5 && l >= -5; l = l <= 0 ? 1 - l
							: 0 - l)
					{
						for (int i1 = 0; !flag && i1 <= 10 && i1 >= -10; i1 = i1 <= 0 ? 1 - i1
								: 0 - i1)
						{
							for (int j1 = 0; !flag && j1 <= 10 && j1 >= -10; j1 = j1 <= 0 ? 1 - j1
									: 0 - j1)
							{
								int k1 = this.worldObj.getBlockId(i + i1,
										j + l, k + j1);
								
								if (k1 == Blocks.purpleCaveStone.blockID)
								{
									if (!this.worldObj.getGameRules()
											.getGameRuleBooleanValue(
													"mobGriefing"))
									{
										int l1 = this.worldObj
												.getBlockMetadata(i + i1,
														j + l, k + j1);
										Block block = Blocks.purpleCaveStone;
										
										if (l1 == 1)
										{
											block = Blocks.purpleCobble;
										}
										
										if (l1 == 2)
										{
											block = Blocks.purpleCaveStoneBricks;
										}
										
										this.worldObj.setBlock(i + i1, j + l, k
												+ j1, block.blockID, 0, 3);
									}
									else
									{
										this.worldObj.destroyBlock(i + i1, j
												+ l, k + j1, false);
									}
									
									Blocks.lostFishBlock
											.onBlockDestroyedByPlayer(
													this.worldObj, i + i1, j
															+ l, k
															+ j1, 0);
									
									if (this.rand.nextBoolean())
									{
										flag = true;
										break;
									}
								}
							}
						}
					}
				}
			}
			
			if (this.entityToAttack == null && !this.hasPath())
			{
				i = MathHelper.floor_double(this.posX);
				j = MathHelper.floor_double(this.posY + 0.5D);
				k = MathHelper.floor_double(this.posZ);
				int i2 = this.rand.nextInt(6);
				l = this.worldObj.getBlockId(i + Facing.offsetsXForSide[i2], j
						+ Facing.offsetsYForSide[i2], k
						+ Facing.offsetsZForSide[i2]);
				
				if (BlockSilverfish.getPosingIdByMetadata(l))
				{
					this.worldObj.setBlock(i + Facing.offsetsXForSide[i2], j
							+ Facing.offsetsYForSide[i2], k
							+ Facing.offsetsZForSide[i2],
							Block.silverfish.blockID,
							BlockSilverfish.getMetadataForBlockType(l), 3);
					this.spawnExplosionParticle();
					this.setDead();
				}
				else
				{
					this.updateWanderPath();
				}
			}
			else if (this.entityToAttack != null && !this.hasPath())
			{
				this.entityToAttack = null;
			}
		}
	}
	
	/**
	 * Takes a coordinate in and returns a weight to determine how likely this
	 * creature will try to path to the block. Args: x, y, z
	 */
	@Override
	public float getBlockPathWeight(int par1, int par2, int par3)
	{
		return this.worldObj.getBlockId(par1, par2 - 1, par3) == Blocks.purpleCaveStone.blockID ? 10.0F
				: super.getBlockPathWeight(par1, par2, par3);
	}
	
	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}
	
	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	@Override
	public boolean getCanSpawnHere()
	{
		if (super.getCanSpawnHere())
		{
			EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(
					this, 5.0D);
			return entityplayer == null;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}
}
