package fr.rorocraft.mob.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import fr.rorocraft.mob.MobCustomGUI;
import fr.rorocraft.mob.utils.InventoryUtils;

public class MobCommand implements CommandExecutor {
	
	
	private MobCustomGUI main;
	private int ticks;

	public MobCommand(MobCustomGUI main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) return true;
		
		Player player = (Player) sender;
		
		
		Inventory inv = Bukkit.createInventory(null, 36, ChatColor.GREEN + "Mob");
		
		player.openInventory(inv);
		
		ticks = 0;
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				InventoryUtils.updateAnimation(inv);
				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
				ticks ++;
				
				
				// A bout de 3 secondes d'animations : 
				if(ticks >= 20 * 3) {
					inv.clear();
					
					ItemStack zombieHead = new ItemStack(Material.ZOMBIE_HEAD);
					ItemMeta zombieHeadMeta = zombieHead.getItemMeta();
					zombieHeadMeta.setDisplayName(ChatColor.RED + "Spawn un mob custom");
					zombieHead.setItemMeta(zombieHeadMeta);
					
					inv.setItem(13, zombieHead);
					
					player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
					cancel();
					ticks = 0;
				}
			}
		}.runTaskTimer(main,  1, 1);
		
		
		
		
		
		
		
		
		return false;
	}

}
