package utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmorStandUtils {

	protected HashMap<Player, ArmorStand> armorStands = new HashMap<>();

	protected void openMainMenu(Player player) {
		Inventory mainMenu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "ArmorStand GUI");
		// options for main menu
		ItemStack create     = new ItemStack(Material.ARMOR_STAND);
		ItemMeta  createMeta = create.getItemMeta();
		createMeta.setDisplayName(ChatColor.GREEN + "Create");

		ArrayList<String> createLore = new ArrayList<>();
		createLore.add(ChatColor.LIGHT_PURPLE + "Create a new ArmorStand");
		createMeta.setLore(createLore);

		create.setItemMeta(createMeta);

		ItemStack close     = new ItemStack(Material.BARRIER);
		ItemMeta  closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.RED + "Close");
		close.setItemMeta(closeMeta);

		mainMenu.setItem(1, create);
		mainMenu.setItem(7, close);

		player.openInventory(mainMenu);
	}

	protected void openCreateMenu(Player player) {
		Inventory createMenu = Bukkit.createInventory(player, 18, ChatColor.GREEN + "Create a ArmorStand");
		// GUI Buttons/Options
		ItemStack arms     = new ItemStack(Material.ARMOR_STAND);
		ItemStack glow     = new ItemStack(Material.GLOW_BERRIES);
		ItemStack armor    = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemStack base     = new ItemStack(Material.SMOOTH_STONE_SLAB);
		ItemStack complete = new ItemStack(Material.GREEN_CONCRETE);
		ItemStack cancel   = new ItemStack(Material.RED_CONCRETE);
		// Implement Meta into Items
		setArmsMeta(arms);
		setGlowMeta(glow);
		setArmorMeta(armor);
		setBaseMeta(base);
		setCompleteMeta(complete);
		setCancelMeta(cancel);
		// Implements Items into GUI
		createMenu.setItem(1, arms);
		createMenu.setItem(3, glow);
		createMenu.setItem(5, armor);
		createMenu.setItem(7, base);
		createMenu.setItem(11, complete);
		createMenu.setItem(15, cancel);

		player.openInventory(createMenu);
	}

	protected void openConfirmMenu(Player player, Material option) {
		Inventory confirmMenu = Bukkit.createInventory(player, 36, ChatColor.GREEN + "Confirm Option");
		ItemStack optionItem  = new ItemStack(option);
		ItemMeta  optionMeta  = optionItem.getItemMeta();

		switch (option) {
			case Material.ARMOR_STAND:
				optionMeta.setDisplayName(ChatColor.YELLOW + "Give Arms?");
				optionItem.setItemMeta(optionMeta);
				break;
			case GLOW_BERRIES:
				optionMeta.setDisplayName(ChatColor.YELLOW + "Give Glowing Effect?");
				optionItem.setItemMeta(optionMeta);
				break;
			case NETHERITE_CHESTPLATE:
				optionMeta.setDisplayName(ChatColor.YELLOW + "Choose Armor?");
				optionItem.setItemMeta(optionMeta);
				break;
			case SMOOTH_STONE_SLAB:
				optionMeta.setDisplayName(ChatColor.YELLOW + "Toggle Base?");
				optionItem.setItemMeta(optionMeta);
				break;
			default:
		}
		ItemStack yesButton     = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		ItemMeta  yesButtonMeta = yesButton.getItemMeta();
		yesButtonMeta.setDisplayName(ChatColor.GREEN + "YES");
		yesButton.setItemMeta(yesButtonMeta);

		ItemStack noButton     = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta  noButtonMeta = noButton.getItemMeta();
		noButtonMeta.setDisplayName(ChatColor.RED + "NO");
		noButton.setItemMeta(noButtonMeta);

		confirmMenu.setItem(13, optionItem);
		confirmMenu.setItem(21, yesButton);
		confirmMenu.setItem(23, noButton);

		player.openInventory(confirmMenu);
	}

	protected void openArmorMenu(Player player) {
		Inventory armorMenu = Bukkit.createInventory(player, 45, ChatColor.LIGHT_PURPLE + "Choose some Armor");

		ItemStack confirm     = new ItemStack(Material.GREEN_CONCRETE);
		ItemMeta  confirmMeta = confirm.getItemMeta();
		confirmMeta.setDisplayName(ChatColor.GREEN + "Done");
		confirm.setItemMeta(confirmMeta);

		ItemStack cancel     = new ItemStack(Material.RED_CONCRETE);
		ItemMeta  cancelMeta = cancel.getItemMeta();
		cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
		cancel.setItemMeta(cancelMeta);

		placeArmorItems(armorMenu, 11, Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS);
		placeArmorItems(armorMenu, 12, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
		placeArmorItems(armorMenu, 13, Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS);
		placeArmorItems(armorMenu, 14, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS);
		placeArmorItems(armorMenu, 15, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);

		armorMenu.setItem(2, confirm);
		armorMenu.setItem(6, cancel);

		player.openInventory(armorMenu);
	}

	protected void handleMaterialOption(Player player, Material material, boolean confirmed) {
		String message = confirmed ? "Option Confirmed" : "Option Canceled";
		player.sendMessage(message);

		if (armorStands.containsKey(player)) {
			ArmorStand stand = armorStands.get(player);

			switch (material) {
				case ARMOR_STAND:
					stand.setArms(confirmed);
					break;
				case GLOW_BERRIES:
					stand.setGlowing(confirmed);
					break;
				case NETHERITE_CHESTPLATE:
					stand.setArms(confirmed);
					break;
				case SMOOTH_STONE_SLAB:
					stand.setBasePlate(confirmed);
					break;
			}
		}
		openCreateMenu(player);
	}

	private void setArmsMeta(ItemStack item) {
		ItemMeta armsMeta = item.getItemMeta();
		armsMeta.setDisplayName(ChatColor.AQUA + "Arms");
		item.setItemMeta(armsMeta);
	}

	private void setGlowMeta(ItemStack item) {
		ItemMeta glowMeta = item.getItemMeta();
		glowMeta.setDisplayName(ChatColor.GOLD + "Glow");
		item.setItemMeta(glowMeta);
	}

	private void setArmorMeta(ItemStack item) {

		ItemMeta armorMeta = item.getItemMeta();
		armorMeta.setDisplayName(ChatColor.GRAY + "Armor");
		item.setItemMeta(armorMeta);
	}

	private void setBaseMeta(ItemStack item) {
		ItemMeta baseMeta = item.getItemMeta();
		baseMeta.setDisplayName(ChatColor.WHITE + "Base");
		item.setItemMeta(baseMeta);
	}

	private void setCompleteMeta(ItemStack item) {
		ItemMeta completeMeta = item.getItemMeta();
		completeMeta.setDisplayName(ChatColor.GREEN + "Complete & Creation");
		item.setItemMeta(completeMeta);
	}

	private void setCancelMeta(ItemStack item) {
		ItemMeta cancelMeta = item.getItemMeta();
		cancelMeta.setDisplayName(ChatColor.RED + "Cancel Creation");
		item.setItemMeta(cancelMeta);
	}

	private void placeArmorItems(Inventory inv, int startIndex, Material... materials) {
		int j = startIndex;
		for (Material material : materials) {
			inv.setItem(j, new ItemStack(material));
			j += 9;
		}
	}
}