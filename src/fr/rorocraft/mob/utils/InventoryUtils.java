package fr.rorocraft.mob.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class InventoryUtils {

	
	
	public static void updateAnimation(Inventory inventory) {
		Material[] materials = {
				Material.BLACK_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE,
				Material.CYAN_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE,
				Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE,
				Material.MAGENTA_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE,
				Material.PURPLE_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.WHITE_STAINED_GLASS_PANE,
				Material.YELLOW_STAINED_GLASS_PANE
			};
		
		
		
		for(int slot = 0; slot < inventory.getSize(); slot ++) {
			int randomNumber = new Random().nextInt(materials.length);
			inventory.setItem(slot, new ItemStack(materials[randomNumber]));
		}
		
	}

}
