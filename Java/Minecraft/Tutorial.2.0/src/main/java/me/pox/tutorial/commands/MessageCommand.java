package me.pox.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
		Player target;
		StringBuilder builder;

		if (sender instanceof Player player && args.length != 0) {
			builder = new StringBuilder();
			String playerName = args[0];

			for (int i = 1; i < args.length; i++) {
				builder.append(args[i]);
				builder.append(" ");
			}

			String message, message2;
			message  = builder.toString();
			message2 = message.stripTrailing();

			target = Bukkit.getServer().getPlayerExact(playerName);
			if (target != null) {
				player.sendMessage(ChatColor.YELLOW + "sent to "
				                   + target.getDisplayName());

				target.sendMessage(String.format("%s%s said: %s",
						ChatColor.YELLOW, player.getDisplayName(), ChatColor.GREEN + message2));
			} else if (target == null) {
				player.sendMessage(ChatColor.RED + String.format
						("%s is not online", playerName));
			}
			return true;
		}
		sender.sendMessage(ChatColor.DARK_RED + "Something went wrong!");
		return true;
	}
}