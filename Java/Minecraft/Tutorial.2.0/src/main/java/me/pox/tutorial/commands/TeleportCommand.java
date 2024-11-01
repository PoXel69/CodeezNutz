package me.pox.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TeleportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player player) {
			if (args.length == 0) {
				player.sendMessage(ChatColor.RED + "please provide a Username");
				player.sendMessage(ChatColor.RED + "/tp <Target>");
				player.sendMessage(ChatColor.RED + "/tp <Username> <Target>");
			} else if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				try {
					player.teleport(target.getLocation());
				} catch (NullPointerException e) {
					player.sendMessage(ChatColor.RED + "Player does not Exist");
				}
			} else if (args.length == 2) {
				Player playerToSend = Bukkit.getPlayer(args[0]);
				Player target       = Bukkit.getPlayer(args[1]);
				try {
					playerToSend.teleport(target.getLocation());
				} catch (NullPointerException e) {
					player.sendMessage(ChatColor.RED + "Player does not Exist");
				}
			}
		}
		return true;
	}
}