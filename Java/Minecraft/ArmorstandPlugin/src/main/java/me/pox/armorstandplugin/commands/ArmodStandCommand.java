package me.pox.armorstandplugin.commands;

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

import java.util.ArrayList;

public class ArmodStandCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player player) {
			Inventory mainMenu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "ArmorStand GUI");

			// options for main menu
			ItemStack create = new ItemStack(Material.ARMOR_STAND);
			ItemMeta createMeta = create.getItemMeta();

			createMeta.setDisplayName(ChatColor.RED + "Create");
			ArrayList<String> createLore = new ArrayList<>();
			createLore.add(ChatColor.LIGHT_PURPLE + "Create a new ArmorStand");

			createMeta.setLore(createLore);
			create.setItemMeta(createMeta);

			ItemStack close = new ItemStack(Material.BARRIER);
			ItemMeta closeMeta = close.getItemMeta();
			closeMeta.setDisplayName(ChatColor.RED + "Close");
			close.setItemMeta(closeMeta);

			mainMenu.setItem(1, create);
			mainMenu.setItem(7, close);
			player.openInventory(mainMenu);
		}
		return true;
	}
}
