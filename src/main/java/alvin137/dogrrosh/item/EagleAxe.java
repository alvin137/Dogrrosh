package alvin137.dogrrosh.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.tictim.ttmpcore.common.Modeled;

import alvin137.dogrrosh.Dogrrosh;
import alvin137.dogrrosh.DogrroshMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EagleAxe extends ItemSword implements Modeled<Item>{
	private String name = "eagleaxe";
	//private String toolClass;
	private final Set<Block> effectiveBlocks;
    protected float efficiencyOnProperMaterial;
    
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
	public EagleAxe(ToolMaterial material) {
		super(material);
		this.effectiveBlocks = EFFECTIVE_ON;
		this.efficiencyOnProperMaterial = 4.0F;
		this.efficiencyOnProperMaterial = material.getEfficiencyOnProperMaterial();
		setUnlocalizedName(Dogrrosh.MODID + "." +  name);
		setRegistryName(Dogrrosh.MODID, name);
		setCreativeTab(Dogrrosh.DOGTAB.get());
		
		//toolClass = "axe";
		
	}
	 
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
	        Material material = state.getMaterial();
	        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(2, attacker);
        return true;
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		double px = playerIn.posX;
		double py = playerIn.posY;
		double pz = playerIn.posZ;
		List<Entity> elist = new ArrayList<Entity>();
		elist = worldIn.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(px-10, py-5, pz-10, px+10, py+5, pz+10));
		for(int i=0; i<elist.size();i++) {
			elist.get(i).motionX = 10;
			elist.get(i).motionY = 20;
		}
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    } 
	
}
