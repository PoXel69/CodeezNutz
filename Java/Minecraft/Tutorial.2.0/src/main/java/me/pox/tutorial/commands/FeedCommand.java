package me.pox.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {
		if (sender instanceof Player player) {
			player.setFoodLevel(20);
			player.setSaturation(20f);
			player.sendMessage(ChatColor.GOLD + "BURP!!");
		}
		return true;
	}
}
