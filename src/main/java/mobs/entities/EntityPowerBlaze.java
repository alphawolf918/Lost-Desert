package idim.mobs.entities;

import idim.items.Items;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPowerBlaze extends EntityMob
{
	/** Random offset used in floating behaviour */
	private float heightOffset = 0.5F;
	
	/** ticks until heightOffset is randomized */
	private int heightOffsetUpdateTime;
	private int field_70846_g;
	
	public EntityPowerBlaze(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
		this.experienceValue = 50;
		this.setHealth(80F);
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setAttribute(10.0D);
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return "mob.blaze.breathe";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.blaze.hit";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.blaze.death";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float par1)
	{
		// return 15728880;
		return 25728880;
	}
	
	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness(float par1)
	{
		return 2.0F;
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		if (!this.worldObj.isRemote)
		{
			if (this.isWet())
			{
				this.attackEntityFrom(DamageSource.drown, 2.0F);
			}
			
			--this.heightOffsetUpdateTime;
			
			if (this.heightOffsetUpdateTime <= 0)
			{
				this.heightOffsetUpdateTime = 100;
				this.heightOffset = 0.5F + (float) this.rand.nextGaussian() * 3.0F;
			}
			
			if (this.getEntityToAttack() != null
					&& this.getEntityToAttack().posY
							+ this.getEntityToAttack().getEyeHeight() > this.posY
							+ this.getEyeHeight()
							+ this.heightOffset)
			{
				this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
			}
		}
		
		if (this.rand.nextInt(24) == 0)
		{
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D,
					this.posZ + 0.5D, "fire.fire",
					1.0F + this.rand.nextFloat(),
					this.rand.nextFloat() * 0.7F + 0.3F);
		}
		
		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}
		
		for (int i = 0; i < 2; ++i)
		{
			this.worldObj.spawnParticle("largesmoke",
					this.posX + (this.rand.nextDouble() - 0.5D)
							* this.width,
					this.posY + this.rand.nextDouble() * this.height,
					this.posZ + (this.rand.nextDouble() - 0.5D)
							* this.width, 0.5D, 0.0D, 0.5D);
		}
		
		super.onLivingUpdate();
	}
	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (this.attackTime <= 0 && par2 < 2.0F
				&& par1Entity.boundingBox.maxY > this.boundingBox.minY
				&& par1Entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		}
		else if (par2 < 30.0F)
		{
			double d0 = par1Entity.posX - this.posX;
			double d1 = par1Entity.boundingBox.minY + par1Entity.height / 2.0F
					- (this.posY + this.height / 2.0F);
			double d2 = par1Entity.posZ - this.posZ;
			
			if (this.attackTime == 0)
			{
				++this.field_70846_g;
				
				if (this.field_70846_g == 1)
				{
					this.attackTime = 60;
					this.func_70844_e(true);
				}
				else if (this.field_70846_g <= 4)
				{
					this.attackTime = 6;
				}
				else
				{
					this.attackTime = 100;
					this.field_70846_g = 0;
					this.func_70844_e(false);
				}
				
				if (this.field_70846_g > 1)
				{
					float f1 = MathHelper.sqrt_float(par2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1009,
							(int) this.posX, (int) this.posY, (int) this.posZ,
							0);
					
					for (int i = 0; i < 1; ++i)
					{
						EntityLargeFireball entitysmallfireball = new EntityLargeFireball(
								this.worldObj, this, d0
										+ this.rand.nextGaussian()
										* f1, d1, d2
										+ this.rand.nextGaussian()
										* f1);
						entitysmallfireball.posY = this.posY
								+ this.height / 2.0F + 0.5D;
						this.worldObj.spawnEntityInWorld(entitysmallfireball);
					}
				}
			}
			
			this.rotationYaw = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}
	
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float par1) {
	}
	
	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	@Override
	protected int getDropItemId()
	{
		return Items.powerRod.itemID;
	}
	
	/**
	 * Returns true if the entity is on fire. Used by render to add the fire
	 * effect on rendering.
	 */
	@Override
	public boolean isBurning()
	{
		return this.func_70845_n();
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		if (par1)
		{
			int j = this.rand.nextInt(2 + par2);
			
			for (int k = 0; k < j; ++k)
			{
				this.dropItem(Items.powerRod.itemID, 1);
			}
		}
	}
	
	public boolean func_70845_n()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
	
	public void func_70844_e(boolean par1)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		
		if (par1)
		{
			b0 = (byte) (b0 | 1);
		}
		else
		{
			b0 &= -2;
		}
		
		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}
	
	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}
}
