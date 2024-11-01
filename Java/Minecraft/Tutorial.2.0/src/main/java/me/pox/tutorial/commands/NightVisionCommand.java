package me.pox.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionCommand implements CommandExecutor {

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
			if (!player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 1, true));
				player.sendMessage(ChatColor.DARK_GREEN + "Let there be light");
				return true;
			}
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}
		return true;
	}
}
