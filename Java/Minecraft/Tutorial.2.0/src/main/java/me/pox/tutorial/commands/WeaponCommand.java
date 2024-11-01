package me.pox.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class WeaponCommand implements CommandExecutor {

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
			ItemStack weapon = new ItemStack(Material.NETHERITE_SWORD, 1);
			ItemMeta weaponMeta = weapon.getItemMeta();

			weaponMeta.setDisplayName(ChatColor.GOLD + "Bitch killer");
			weaponMeta.setLore(Collections.singletonList("Destroys unworthy bitches to milion, bijilion pieces\nin name if gods"));
			weaponMeta.setRarity(ItemRarity.RARE);
			weaponMeta.addEnchant(Enchantment.SHARPNESS, 255, true);
			weaponMeta.addEnchant(Enchantment.LOOTING, 10, true);
			weaponMeta.setUnbreakable(true);

			weapon.setItemMeta(weaponMeta);
			player.getInventory().addItem(weapon);
		}
		return true;
	}
}
