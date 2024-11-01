package me.pox.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerMenuCommand implements CommandExecutor {

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
			Inventory menu = Bukkit.createInventory(player, 9, ChatColor.MAGIC + "Center");

			ItemStack feed = new ItemStack(Material.BEEF);
			ItemMeta feedMeta = feed.getItemMeta();
			feedMeta.setDisplayName("Feed");
			feedMeta.setLore(List.of(ChatColor.GOLD + "africa is jealous"));
			feed.setItemMeta(feedMeta);

			ItemStack kill = new ItemStack(Material.SKELETON_SKULL);
			ItemMeta killMeta = kill.getItemMeta();
			killMeta.setDisplayName("kill");
			killMeta.setLore(List.of(ChatColor.GOLD + "kys'ed LOL"));
			kill.setItemMeta(killMeta);

			ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);
			ItemMeta expMeta = exp.getItemMeta();
			expMeta.setDisplayName(ChatColor.MAGIC + "experience");
			expMeta.setLore(List.of(ChatColor.GOLD + "ASTOALA"));
			exp.setItemMeta(expMeta);

			menu.setItem(1, feed);
			menu.setItem(4, kill);
			menu.setItem(7, exp);

			player.openInventory(menu);
		}
		return true;
	}
}
