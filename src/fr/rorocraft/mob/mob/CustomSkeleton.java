package fr.rorocraft.mob.mob;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;



import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityAnimal;
import net.minecraft.server.v1_16_R3.EntitySkeleton;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EnumItemSlot;
import net.minecraft.server.v1_16_R3.ItemStack;
import net.minecraft.server.v1_16_R3.Items;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;




public class CustomSkeleton extends EntitySkeleton {


	public CustomSkeleton( Location location) {
		super(EntityTypes.SKELETON, ((CraftWorld) location.getWorld()).getHandle());
		
		
		
		
		this.setAggressive(true);
		this.setCustomNameVisible(true);
		this.setCustomName(new ChatComponentText(ChatColor.RED + "Custom mob" + ChatColor.GREEN));
		this.setSprinting(true);
		this.setSilent(false);
		this.setFireTicks(0);
		
		
		this.setSlot(EnumItemSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
		
		this.setSlot(EnumItemSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
		this.setSlot(EnumItemSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
		this.setSlot(EnumItemSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
		this.setSlot(EnumItemSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
		
		
		
		
		
		
		this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget<EntityAnimal>(this, EntityAnimal.class, true));
		
		
		
		this.setPosition(location.getX(), location.getY(), location.getZ());
		this.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
		
		this.spawnIn(( (CraftWorld) location.getWorld()).getHandle());
		
		
		
		
	}
	
	
	public void spawnEntity() {
		
	}

	



}
