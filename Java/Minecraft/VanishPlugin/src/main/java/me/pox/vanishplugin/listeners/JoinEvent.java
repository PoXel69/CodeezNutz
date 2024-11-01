package me.pox.vanishplugin.listeners;

import me.pox.vanishplugin.VanishPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	VanishPlugin plugin;

	public JoinEvent(VanishPlugin plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		for (int i = 0; i < plugin.vanishPlayers.size(); i++) {
			player.hidePlayer(plugin, plugin.vanishPlayers.get(i));
		}
	}
}
