package me.pox.tutorial.commands;

import me.pox.tutorial.Tutorial;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

	private final ArrayList<Player> list_of_flying_players = new ArrayList<>();
	private final Tutorial plugin;
	private Player target;

	public FlyCommand(Tutorial plugin) {
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
			if (args.length == 0) {
				flyMethod(player);
				return true;
			} else if (args.length == 1 && player.hasPermission("tutorial.others") && target != null) {
				target = Bukkit.getPlayer(args[0]);
				flyMethod(target);
			}
		}
		return true;
	}

	private void flyMethod(Player player) {
		if (!list_of_flying_players.contains(player) && player.hasPermission("tutorial.fly")) {
			list_of_flying_players.add(player);

			player.setAllowFlight(true);
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText
					(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("on_fly_enable"))));
			return;
		} else if (list_of_flying_players.contains(player) && player.hasPermission("tutorial.fly")) {
			list_of_flying_players.remove(player);

			player.setAllowFlight(false);
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText
					(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("on_fly_disable"))));
			return;
		}
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText
				(ChatColor.RED + "You don't have the permission to fly. "));
	}
}
