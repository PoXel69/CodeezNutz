package me.pox.vanishplugin.commands;

import me.pox.vanishplugin.VanishPlugin;
import me.pox.vanishplugin.utils.VanishUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

	private final VanishPlugin plugin;

	public VanishCommand(VanishPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player player) {
			if (plugin.vanishPlayers.contains(player)) {
				for (Player people : Bukkit.getOnlinePlayers()) {
					people.showPlayer(plugin, player);
				}
				plugin.vanishPlayers.remove(player);
				VanishUtils.actionBar(player, "&cToggled Off Vanish");
			} else if (!plugin.vanishPlayers.contains(player)) {
				for (Player people : Bukkit.getOnlinePlayers()) {
					people.hidePlayer(plugin, player);
				}
				plugin.vanishPlayers.add(player);
				VanishUtils.actionBar(player, "&aToggled On Vanish");
			}
		}
		return true;
	}
}