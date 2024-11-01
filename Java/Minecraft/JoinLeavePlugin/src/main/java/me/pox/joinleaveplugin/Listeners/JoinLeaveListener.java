package me.pox.joinleaveplugin.Listeners;

import me.pox.joinleaveplugin.JoinLeavePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

	private final JoinLeavePlugin plugin;
	private String message;

	public JoinLeaveListener(JoinLeavePlugin plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		String message;
		if (player.hasPlayedBefore()) {
			message = this.plugin.getConfig().getString("welcome-back-message", "welcome back ");
		} else {
			message = this.plugin.getConfig().getString("welcome-message", "welcome ");
		}

		if (message != null) {
			message = changeToName(message, player);
			setJoinMessage(e, message);
		} else {
			player.sendMessage(ChatColor.RED + "Something went wrong!");
		}
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		String message = this.plugin.getConfig().getString("goodbye-message", "bye!");
		if (message != null) {
			message = changeToName(message, e.getPlayer());
			setQuitMessage(e, message);
		}
	}

	private String changeToName(String message, Player player) {
		String name = player.getDisplayName();
		return message.replace("%player%", name);
	}

	private void setJoinMessage(PlayerJoinEvent joinEvent, String message) {
		joinEvent.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message));
	}

	private void setQuitMessage(PlayerQuitEvent quitEvent, String message) {
		quitEvent.setQuitMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
}

