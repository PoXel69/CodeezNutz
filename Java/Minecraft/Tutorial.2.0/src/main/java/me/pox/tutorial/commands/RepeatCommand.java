package me.pox.tutorial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {

	/**
	 * Execute random-teleport command
	 *
	 * @param sender  The source for the command
	 * @param command The commands that was executed
	 * @param label   The display name for the command
	 * @param args    The arguments passed for the command
	 * @return true if the command was successful, false otherwise
	 */

	@Override
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
		if (sender instanceof Player player) {
			if (args.length != 0) {
				StringBuilder builder = new StringBuilder();

				for (int i = 0; i < args.length; i++) {
					builder.append(args[i]);
					builder.append(" ");
				}
				String finalMessage = builder.toString();
				finalMessage = finalMessage.stripTrailing();

				player.sendMessage("Message: " + finalMessage);
				return true;
			}
			player.sendMessage("Please privide a message");
			player.sendMessage("e.g: /repeat <message>");
		}
		return true;
	}
}
