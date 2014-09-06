package idim.mobs.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBloodWorm extends EntityMob {
	
	public EntityBloodWorm(World par1World) {
		super(par1World);
		this.setHealth(80F);
		this.setAIMoveSpeed(.8F);
		this.experienceValue = 175;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, this.getAIMoveSpeed(), false));
		this.tasks.addTask(3, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAIWander(this, this.getAIMoveSpeed()));
		this.tasks.addTask(5, new EntityAIRestrictSun(this));
		this.tasks.addTask(6, new EntityAIFleeSun(this, 1.5D));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this,
				EntityWanderer.class, this.getAIMoveSpeed(), false));
		this.tasks.addTask(8, new EntityAIWatchClosest(this,
				EntityWanderer.class, 6.0F));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(
				this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(
				this, EntityWanderer.class, 0, true));
		this.stepHeight = 1F;
	}
	
	@Override
	public void fall(float par1) {
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}
	
	@Override
	public int getTotalArmorValue() {
		return 18;
	}
	
	@Override
	protected String getLivingSound() {
		return "awid:mob.worm.say";
	}
	
	@Override
	protected String getHurtSound() {
		return "awid:mob.worm.hurt";
	}
	
	@Override
	protected String getDeathSound() {
		return "awid:mob.worm.death";
	}
	
	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.worm.step1", 0.15F, 1.0F);
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	public int getAttackStrength(Entity par1Entity) {
		return 20;
	}
}