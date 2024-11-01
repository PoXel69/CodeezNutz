package me.pox.enderbow.listeners;

import me.pox.enderbow.EnderBow;
import me.pox.enderbow.utilities.BowUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class TPBowListener implements Listener {

	private final EnderBow plugin;
	private final BowUtil bowUtil;

	public TPBowListener(EnderBow plugin) {
		this.plugin  = plugin;
		this.bowUtil = new BowUtil(plugin);
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onArrowLand(ProjectileHitEvent e) {
		if (e.getEntity().getShooter() instanceof Player player) {
			String message = plugin.getConfig().getString("bow-name", "&6[EnderBow]");
			BowUtil.teleportPlayer(e,player, e.getEntity().getLocation());
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (plugin.getConfig().getBoolean("give-on-join") && !e.getPlayer().hasPlayedBefore()) {
			Player player = e.getPlayer();
			player.getInventory().addItem(bowUtil.createBow());
			player.getInventory().setItem(9, new ItemStack(Material.ARROW, 1));
			player.sendMessage("here's a gift");
		}
	}
}