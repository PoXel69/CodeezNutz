package me.pox.tutorial.listeners;

import me.pox.tutorial.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EntityListener implements Listener {

	private final Tutorial plugin;

	public EntityListener(Tutorial plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {

		Player player = e.getPlayer();
		// player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING_BOLT);

		//		Entity entity = Bukkit.getWorld(player.getWorld().getUID()).spawnEntity(new Location(Bukkit.getWorld(player.getWorld().getUID()), 6, 100, 6), EntityType.VILLAGER);
		//		entity.setCustomName("BOB");
		//		entity.setCustomNameVisible(true);
		//		entity.setGravity(false);
		//		entity.setGlowing(true);
		//		entity.

	}
}
