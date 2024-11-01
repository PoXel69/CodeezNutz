package me.pox.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
		if (sender instanceof Player player) {
			if (!player.isInvulnerable()) {
				player.setInvulnerable(true);
				player.sendMessage(ChatColor.GREEN + "GodMode enabled");
			} else if (player.isInvulnerable()) {
				player.setInvulnerable(false);
				player.sendMessage(ChatColor.RED + "GodMode disabled");
			}
		}
		return true;
	}
}
