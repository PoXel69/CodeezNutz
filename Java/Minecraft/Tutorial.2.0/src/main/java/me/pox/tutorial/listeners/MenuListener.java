package me.pox.tutorial.listeners;

import me.pox.tutorial.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {
	public MenuListener(Tutorial plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(ChatColor.MAGIC + "Center")) {
			if (e.isRightClick()) {
				return;
			}
			Player player = (Player) e.getWhoClicked();

			switch (e.getCurrentItem().getType()) {
				case BEEF:
					player.setFoodLevel(20);
					player.setSaturation(20);
					break;
				case SKELETON_SKULL:
					player.setHealth(0.0);
					break;
				case EXPERIENCE_BOTTLE:
					player.giveExpLevels(1000_000_000);
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + e.getCurrentItem().getType());
			}
			e.setCancelled(true);
		}
	}
}
