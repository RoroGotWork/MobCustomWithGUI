package fr.rorocraft.mob.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.rorocraft.mob.mob.CustomSkeleton;
import net.minecraft.server.v1_16_R3.WorldServer;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		ItemStack itemStack = event.getCurrentItem();
		
		if(itemStack == null) return;
		if(!itemStack.hasItemMeta()) return;
		if(!itemStack.getItemMeta().hasDisplayName()) return;
		if(itemStack.getType() != Material.ZOMBIE_HEAD) return;
		if(!itemStack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Spawn un mob custom")) return;
		
		event.setCancelled(true);
		
		CustomSkeleton skeleton = new CustomSkeleton(player.getLocation());
		
		
		WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
		world.addEntity(skeleton);
		
		player.sendMessage("Mob spawned");
		
	}

}
