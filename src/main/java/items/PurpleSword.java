package idim.items;

import idim.creativetabs.ModTabs;
import idim.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleSword extends Item
{
	private final float weaponDamage;
	private final EnumToolMaterial toolMaterial;
	
	public PurpleSword(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1);
		this.toolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(2000);
		this.setCreativeTab(ModTabs.ldTab);
		this.setUnlocalizedName("purplesword");
		this.weaponDamage = 17.0F + par2EnumToolMaterial.getDamageVsEntity();
		par2EnumToolMaterial.customCraftingMaterial = Items.purpleDiamond;
	}
	
	public float func_82803_g()
	{
		return this.toolMaterial.getDamageVsEntity();
	}
	
	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return 20F;
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World,
			int par3, int par4, int par5, int par6,
			EntityLivingBase par7EntityLivingBase)
	{
		if (Block.blocksList[par3]
				.getBlockHardness(par2World, par4, par5, par6) != 0.0D)
		{
			par1ItemStack.damageItem(1, par7EntityLivingBase);
		}
		
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	public boolean isFull3D()
	{
		return true;
	}
	
	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}
	
	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 102000;
	}
	
	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	@Override
	public boolean canHarvestBlock(Block par1Block)
	{
		return true;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}
	
	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}
	
	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack)
	{
		return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true
				: super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit
	 * damage.
	 */
	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage
				.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", this.weaponDamage,
				0));
		return multimap;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":"
				+ "lost_sword");
	}
}
