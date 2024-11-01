package me.pox.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SignCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			if (args.length != 2) {
				player.sendMessage(ChatColor.RED + "/sign <Line Number> <Text>");
			} else if (args.length == 2) {
				player.getWorld().getBlockAt(player.getLocation().add(0, 2, 0)).setType(Material.WARPED_WALL_HANGING_SIGN);
				Sign sign1 = (Sign) player.getWorld().getBlockAt(player.getLocation()).getState();
				sign1.setLine(Integer.parseInt(args[0]), args[1]);
				sign1.update();
			}
		}
		return true;
	}
}