package me.pox.tutorial.commands;

import me.pox.tutorial.Tutorial;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.ArmorStandUtils;

public class ArmorStandCommand extends ArmorStandUtils implements CommandExecutor {

	private final Tutorial plugin;

	public ArmorStandCommand(Tutorial plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player player) {
			openMainMenu(player);
		}
		return true;
	}
}
