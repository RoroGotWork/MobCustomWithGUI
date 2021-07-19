package fr.rorocraft.mob;

import org.bukkit.plugin.java.JavaPlugin;

import fr.rorocraft.mob.commands.MobCommand;
import fr.rorocraft.mob.events.EntityListener;
import fr.rorocraft.mob.events.InventoryListener;

public class MobCustomGUI extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		
		registerCommands();
		
		registerEvents();
		
	    System.out.println("[MobCustom] Plugin pret");
	}
	
	

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}
	
	private void registerCommands() {
		
		this.getCommand("mob").setExecutor(new MobCommand(this));
	}
	
	private void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
		this.getServer().getPluginManager().registerEvents(new EntityListener(), this);
	}

}
