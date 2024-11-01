package me.pox.enderbow.utilities;

import me.pox.enderbow.EnderBow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class BowUtil {

	private static EnderBow plugin;

	public BowUtil(EnderBow plugin) {
		this.plugin = plugin;
	}

	public static ItemStack createBow() {
		ItemStack bow     = new ItemStack(Material.BOW);
		ItemMeta  bowMeta = bow.getItemMeta();

		String bowName = plugin.getConfig().getString("bow-name", "&6[EnderBow]");
		String bowLore = plugin.getConfig().getString("bow-description", "&cTeleport bow");

		bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', bowName));
		bowMeta.addEnchant(Enchantment.INFINITY, 1, false);
		bowMeta.setUnbreakable(true);

		String lore = ChatColor.translateAlternateColorCodes('&', bowLore);
		bowMeta.setLore(Collections.singletonList(lore));
		bow.setItemMeta(bowMeta);

		return bow;
	}

	public static void givePlayerBow(Player player) {
		ItemStack bow = BowUtil.createBow();
		player.getInventory().addItem(bow);
		player.getInventory().setItem(9, new ItemStack(Material.ARROW, 1));
		player.sendMessage(ChatColor.BLUE + "You have granted the power of ancient gods!");
	}

	public static void teleportPlayer(ProjectileHitEvent e, Player player, Location arrowSpot) {
		ItemStack itemInHand = player.getInventory().getItemInMainHand();
		String    bowName    = plugin.getConfig().getString("bow-name", "&6[EnderBow]");
		String    tpMessage  = plugin.getConfig().getString("teleported-message", "&aTeleported");

		if (itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', bowName))) {
			player.teleport(arrowSpot);
			e.getEntity().remove();
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', tpMessage));
			player.playSound(player, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1f, 1f);
		}
	}
}