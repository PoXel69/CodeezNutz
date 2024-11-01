// package me.conch.punishplugin;
//
// import org.bukkit.Bukkit;
// import org.bukkit.Material;
// import org.bukkit.entity.Player;
// import org.bukkit.event.EventHandler;
// import org.bukkit.event.Listener;
// import org.bukkit.event.inventory.InventoryClickEvent;
//
// public class PunishInventoryListenerOld implements Listener {
//
//  private final PunishPlugin plugin;
//  PunishMenuUtil punishUtil = new PunishMenuUtil();
//  Player target = new PunishCommand().getTarget();
//
//  public PunishInventoryListenerOld(PunishPlugin plugin) {
//    this.plugin = plugin;
//    Bukkit.getPluginManager().registerEvents(this, plugin);
//  }
//
//  @EventHandler
//  public void onMenuClick(InventoryClickEvent e) {
//    Player player = (Player) e.getWhoClicked();
//
//    if (punishUtil.isInventoryTitle(e, punishUtil.PUNISH_GUI_NAME)) {
//      punishUtil.handlePunishMenuClick(e, player);
//      e.setCancelled(true);
//    } else if (punishUtil.isInventoryTitle(e, punishUtil.BAN_PUNISHMENT_MENU_NAME)) {
//      if ((e.getCurrentItem()).getType().equals(Material.AIR)) return;
//      punishUtil.handleConfirmMenuClick(
//          player,
//          target,
//          punishUtil.BAN_CONFIRM_MENU_NAME,
//          "Ban",
//          Material.WOODEN_AXE,
//          e.getCurrentItem());
//      e.setCancelled(true);
//    } else if (punishUtil.isInventoryTitle(e, punishUtil.MUTE_PUNISHMENT_MENU_NAME)) {
//      if ((e.getCurrentItem()).getType().equals(Material.AIR)) return;
//      punishUtil.handleConfirmMenuClick(
//          player,
//          target,
//          punishUtil.MUTE_CONFIRM_MENU_NAME,
//          "Mute",
//          Material.NOTE_BLOCK,
//          e.getCurrentItem());
//      e.setCancelled(true);
//    } else if (punishUtil.isInventoryTitle(e, punishUtil.BAN_CONFIRM_MENU_NAME)
//        || punishUtil.isInventoryTitle(e, punishUtil.MUTE_CONFIRM_MENU_NAME)) {
//      punishUtil.handleConfirmMenuActions(e, player, target);
//      e.getWhoClicked().closeInventory();
//      e.setCancelled(true);
//    }
//  }
// }
