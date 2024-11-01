package me.pox.tutorial.listeners;

import me.pox.tutorial.Tutorial;
import me.pox.tutorial.events.GameEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class GameListener implements Listener {
	private final Tutorial plugin;

	public GameListener(Tutorial plugin) {
		this.plugin = plugin;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onGameEnd(GameEndEvent e) {
		Bukkit.getServer().broadcastMessage("GAME HAS ENDED MA BOI");
		Bukkit.getServer().broadcastMessage("WINNER " + e.getWinner().getDisplayName());
		Bukkit.getServer().broadcastMessage("LOSER " + e.getLoser().getDisplayName());
	}
}


