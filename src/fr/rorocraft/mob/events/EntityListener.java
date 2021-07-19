package fr.rorocraft.mob.events;

import java.util.Random;


import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;









public class EntityListener implements Listener{
	
	
	
	
	 @EventHandler
	 public void onDamage(EntityDamageByEntityEvent event) {
	
		 if(!(event.getDamager() instanceof Skeleton)) {
			 return;}
		 if(!(event.getEntity() instanceof Animals)) {
			 return;
		 }
		 
		
		
		Animals victim = (Animals) event.getEntity();
		
		
		
		 
		 int randomNumber = new Random().nextInt(10);
		 
		 switch(randomNumber) {
		 	case 1:
		 		victim.getWorld().createExplosion(victim.getLocation(), 5f, true, true);
		 		break;
			 
		 	case 2:
		 		event.getEntity().setFireTicks(20 * 10);
		 		break;
		 		
		 	case 3:
		 		victim.setCustomName(ChatColor.AQUA + "Victime !!!");
		 		victim.setCustomNameVisible(true);
		 		break;
		 	
		 	case 4:
		 		victim.setGravity(false);
		 		break;
		 		
		 	case 5:
		 		event.setDamage(event.getDamage() + 3);
		 		break;
		 		
		 	case 6:
		 		victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 5 , 1, true, true));
		 		break;
		 		
		 	case 7:
		 		victim.setInvisible(true);
		 		break;
			 
		 	default:
		 		victim.setBaby();
		 		break;
			
			
		 
		 
		 }
		 
		 
		 
	 }
	
	

}
