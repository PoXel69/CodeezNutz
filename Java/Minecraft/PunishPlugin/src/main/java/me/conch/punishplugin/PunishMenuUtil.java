package me.conch.punishplugin;

import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PunishMenuUtil {

  private final Material BAN_ITEM = Material.WOODEN_AXE;
  private final Material MUTE_ITEM = Material.NOTE_BLOCK;
  private final Material CANCEL_ITEM = Material.BARRIER;
  PunishMenuManager punishManager = new PunishMenuManager();

  public Material getBAN_ITEM() {
    return BAN_ITEM;
  }

  public Material getMUTE_ITEM() {
    return MUTE_ITEM;
  }

  // Opens punishment menus based on the clicked item
  public void handlePunishMenuClick(InventoryClickEvent event, Player player) {
    Validate.notNull(event.getCurrentItem(), "Current Item Cannot be Null");
    switch (event.getCurrentItem().getType()) {
      case WOODEN_AXE -> punishManager.openBanMenuClick(player);
      case NOTE_BLOCK -> punishManager.openMuteMenuClick(player);
      default ->
          throw new IllegalStateException("Unexpected value: " + event.getCurrentItem().getType());
    }
  }

  // Opens a confirmation menu for the selected punishment
  public void handleConfirmMenuClick(
      Player player,
      Player target,
      String invName,
      String punishType,
      Material punishItem,
      ItemStack punishReason) {
    Inventory confirmPunishMenu =
        new InventoryBuilder().setPlayer(null).setSize(18).setTitle(invName).build();
    addMenuItem(confirmPunishMenu, punishItem, punishType, 1);
    addPlayerHead(confirmPunishMenu, target, 4);
    addMenuItem(confirmPunishMenu, CANCEL_ITEM, ChatColor.RED + "Cancel", 7);
    confirmPunishMenu.setItem(13, punishReason);
    player.openInventory(confirmPunishMenu);
  }

  // Handles actions in the confirmation menu
  public void handleConfirmMenuActions(InventoryClickEvent event, Player player, Player target) {
    Validate.notNull(event.getCurrentItem(), "Current item cannot be null");
    switch (event.getCurrentItem().getType()) {
      case BARRIER -> punishManager.openPunishMenu(player);
      case WOODEN_AXE, NOTE_BLOCK ->
          Bukkit.broadcastMessage(
              createPunishMessage("MUTE", "conch", target.getDisplayName(), "30d", "jendegiezan"));
      default -> event.setCancelled(true);
    }
    event.setCancelled(true);
  }

  // Adds an item to the menu with the specified name at the specified index.
  protected void addMenuItem(Inventory inv, Material material, String name, int index) {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();
    Validate.notNull(meta, "Meta Cannot be Null");
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    item.setItemMeta(meta);
    inv.setItem(index, item);
  }

  // Adds a reason item to the menu
  void addReasonItem(Inventory inv, Material material, String reason) {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(ChatColor.YELLOW + reason);
    Validate.notNull(meta, "Meta Cannot be Null");
    item.setItemMeta(meta);
    inv.addItem(item);
  }

  // Adds the player's head to the menu
  private void addPlayerHead(Inventory inv, Player player, int index) {
    ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
    SkullMeta meta = (SkullMeta) head.getItemMeta();
    meta.setOwner(player.getDisplayName());
    meta.setDisplayName(ChatColor.GOLD + player.getDisplayName());
    Validate.notNull(meta, "Meta Cannot be Null");
    head.setItemMeta(meta);
    inv.setItem(index, head);
  }

  private String createPunishMessage(
      String mode, String executor, String target, String duration, String reason) {
    String line = ChatColor.STRIKETHROUGH + "                                         ";
    String modeLine = ChatColor.GRAY + "Mode: " + ChatColor.YELLOW + ChatColor.BOLD + mode;
    String executorLine = ChatColor.GRAY + "Executor: " + ChatColor.BLUE + executor;
    String targetLine = ChatColor.GRAY + "Target: " + ChatColor.WHITE + target;
    String durationLine = ChatColor.GRAY + "Duration: " + ChatColor.RED + duration;
    String reasonLine = ChatColor.GRAY + "Reason: " + ChatColor.RED + reason;
    return String.format(
        """
		                     %s
		                     %s
		                     %s
		                     %s
		                     %s
		                     %s
		                     %s
		                     """,
        line, modeLine, executorLine, targetLine, durationLine, reasonLine, line);
  }
}
