package me.pox.tutorial.listeners;

import me.pox.tutorial.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import utils.ArmorStandUtils;

public class ArmorStandListener extends ArmorStandUtils implements Listener {

	private final Tutorial plugin;

	public ArmorStandListener(Tutorial plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onMenuClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		//menu list
		final String MAIN_MENU    = ChatColor.BLUE + "ArmorStand GUI";
		final String CREATE_MENU  = ChatColor.GREEN + "Create a ArmorStand";
		final String CONFIRM_MENU = ChatColor.GREEN + "Confirm Option";
		final String ARMOR_MENU   = ChatColor.LIGHT_PURPLE + "Choose some Armor";

		if (e.getView().getTitle().equalsIgnoreCase(MAIN_MENU)) {
			e.setCancelled(true);
			switch (e.getCurrentItem().getType()) {
				case ARMOR_STAND:
					player.sendMessage("Opened create ArmorStand menu");
					openCreateMenu(player);
					break;
				case BARRIER:
					player.sendMessage("Closing Main Menu");
					player.closeInventory();
					break;
				default:
					break;
			}
		} else if (e.getView().getTitle().equalsIgnoreCase(CREATE_MENU)) {

			if (!armorStands.containsKey(player)) {
				ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
				stand.setVisible(false);
				armorStands.put(player, stand);
			}

			switch (e.getCurrentItem().getType()) {
				case ARMOR_STAND:
					player.sendMessage("Add Arms?");
					openConfirmMenu(player, Material.ARMOR_STAND);
					break;
				case GLOW_BERRIES:
					player.sendMessage("Add Glowing Effect?");
					openConfirmMenu(player, Material.GLOW_BERRIES);
					break;
				case NETHERITE_CHESTPLATE:
					player.sendMessage("Choose Armor?");
					// Armor selection Menu
					openArmorMenu(player);
					break;
				case SMOOTH_STONE_SLAB:
					player.sendMessage("Toggle Base?");
					openConfirmMenu(player, Material.SMOOTH_STONE_SLAB);
					break;
				case GREEN_CONCRETE:
					player.sendMessage("Created ArmorStand");
					if (armorStands.containsKey(player)) {
						ArmorStand stand = armorStands.get(player);
						stand.setVisible(true);
						armorStands.remove(player);
					}
					player.closeInventory();
					break;
				case RED_CONCRETE:
					player.sendMessage("Deleted ArmorStand");
					if (armorStands.containsKey(player)) {
						ArmorStand stand = armorStands.get(player);
						stand.remove();
						armorStands.remove(player);
					}
					player.closeInventory();
					break;
			}
			e.setCancelled(true);
		} else if (e.getView().getTitle().equalsIgnoreCase(CONFIRM_MENU)) {
			if (e.getClickedInventory().contains(Material.ARMOR_STAND)) {
				switch (e.getCurrentItem().getType()) {
					case GREEN_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.ARMOR_STAND, true);
						break;
					case RED_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.ARMOR_STAND, false);
						break;
				}
			} else if (e.getClickedInventory().contains(Material.GLOW_BERRIES)) {
				switch (e.getCurrentItem().getType()) {
					case GREEN_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.GLOW_BERRIES, true);
						break;
					case RED_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.GLOW_BERRIES, false);
						break;
				}
			} else if (e.getClickedInventory().contains(Material.NETHERITE_CHESTPLATE)) {
				switch (e.getCurrentItem().getType()) {
					case GREEN_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.NETHERITE_CHESTPLATE, true);
						break;
					case RED_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.NETHERITE_CHESTPLATE, false);
						break;
				}
			} else if (e.getClickedInventory().contains(Material.SMOOTH_STONE_SLAB)) {
				switch (e.getCurrentItem().getType()) {
					case GREEN_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.SMOOTH_STONE_SLAB, true);
						break;
					case RED_STAINED_GLASS_PANE:
						handleMaterialOption(player, Material.SMOOTH_STONE_SLAB, false);
						break;
				}
			}
			e.setCancelled(true);
		} else if (e.getView().getTitle().equalsIgnoreCase(ARMOR_MENU)) {
			if (armorStands.containsKey(player)) {
				ArmorStand stand = armorStands.get(player);
				switch (e.getCurrentItem().getType()) {
					case NETHERITE_HELMET:
						if (stand.getHelmet().getType() == Material.NETHERITE_HELMET) {
							stand.setHelmet(null);
						} else {
							stand.setHelmet(new ItemStack(Material.NETHERITE_HELMET));
							player.sendMessage("Added");
						}
						break;
					case NETHERITE_CHESTPLATE:
						if (stand.getChestplate().getType() == Material.NETHERITE_CHESTPLATE) {
							stand.setChestplate(null);
						} else {
							stand.setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
							player.sendMessage("Added");
						}
						break;
					case NETHERITE_LEGGINGS:
						if (stand.getLeggings().getType() == Material.NETHERITE_LEGGINGS) {
							stand.setLeggings(null);
						} else {
							stand.setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
							player.sendMessage("Added");
						}
						break;
					case NETHERITE_BOOTS:
						if (stand.getBoots().getType() == Material.NETHERITE_BOOTS) {
							stand.setBoots(null);
						} else {
							stand.setBoots(new ItemStack(Material.NETHERITE_BOOTS));
							player.sendMessage("Added");
						}
						break;
					case GREEN_CONCRETE:
						player.sendMessage("Armor Confirmed");
						openCreateMenu(player);
						break;
					case RED_CONCRETE:
						stand.setHelmet(null);
						stand.setChestplate(null);
						stand.setLeggings(null);
						stand.setBoots(null);

						openCreateMenu(player);
						break;
				}
				e.setCancelled(true);
			}
		}
	}
}
