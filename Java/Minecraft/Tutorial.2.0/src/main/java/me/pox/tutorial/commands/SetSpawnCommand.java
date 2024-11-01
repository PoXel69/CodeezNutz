package me.pox.tutorial.commands;

import me.pox.tutorial.Tutorial;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

	private final Tutorial plugin;

	public SetSpawnCommand(Tutorial plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
		if (sender instanceof Player player) {
			Location spawnPoint = player.getLocation();

			plugin.getConfig().set("spawn", spawnPoint);
			plugin.saveConfig();

			player.sendMessage("Spawn location set");
		}
		return true;
	}
}
