package me.pox.tutorial.commands;

import me.pox.tutorial.Tutorial;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.RTPUtils;

public class RandomTeleportCommand extends RTPUtils implements CommandExecutor {


	public RandomTeleportCommand(Tutorial plugin) {
		super(plugin);
	}

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
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			playerCooldown(player);
		}
		return true;
	}
}