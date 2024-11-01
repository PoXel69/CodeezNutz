package me.pox.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HologramCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player player) {
			ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 5, 0), EntityType.ARMOR_STAND);

			hologram.setVisible(false);
			hologram.setCustomNameVisible(true);
			hologram.setGravity(false);
			hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', "&bman kheyli be zan dexster alaghe daram"));

			ArmorStand hologram2 = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 4.5, 0), EntityType.ARMOR_STAND);
			hologram2.setVisible(false);
			hologram2.setCustomNameVisible(true);
			hologram2.setGravity(false);
			hologram2.setCustomName(ChatColor.translateAlternateColorCodes('&', "&aChon zan dexster &4DO KILO KOS &aDARE"));
		}
		return true;
	}
}
