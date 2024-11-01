package me.pox.tutorial.commands;

import me.pox.tutorial.Tutorial;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

	private final Tutorial plugin;

	public SpawnCommand(Tutorial plugin) {
		this.plugin = plugin;
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
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
		if (sender instanceof Player player) {
			Location spawnpoint = plugin.getConfig().getLocation("spawn");

			if (spawnpoint != null) {
				player.teleport(spawnpoint);
				player.sendMessage("teleported");
				return true;
			}
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("No spawn point found, use /setspawn"));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1f, 1f);
		}
		return true;
	}
}
