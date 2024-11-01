package me.pox.enderbow.commands;

import me.pox.enderbow.EnderBow;
import me.pox.enderbow.utilities.BowUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommand implements CommandExecutor {

	private final EnderBow plugin;
	private final BowUtil bowUtil;

	public GiveCommand(EnderBow plugin) {
		this.plugin  = plugin;
		this.bowUtil = new BowUtil(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player target = Bukkit.getPlayerExact(args[0]);
		if (sender instanceof Player player && player.hasPermission("tpbow.givebow") && args[0] == null) {
			BowUtil.givePlayerBow(player);
			return true;
		} else if ((args[0] != null) && Bukkit.getOnlinePlayers().contains(args[0])) {
			BowUtil.givePlayerBow(target);
			return true;
		}
		sender.sendMessage(ChatColor.RED + (target.getDisplayName() + " does not exist"));
		return false;
	}
}