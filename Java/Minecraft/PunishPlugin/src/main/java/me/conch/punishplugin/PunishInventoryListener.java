package me.conch.punishplugin;

import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishInventoryListener implements Listener {

  private final PunishPlugin plugin;
  PunishMenuUtil punishUtil = new PunishMenuUtil();
  Player target = new PunishCommand().getTarget();

  public PunishInventoryListener(PunishPlugin plugin) {
    this.plugin = plugin;
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onMenuClick(InventoryClickEvent e) {
    Player player = (Player) e.getWhoClicked();
    String title = e.getView().getTitle();

    if (title.equalsIgnoreCase(PunishMenuName.PUNISH_GUI.getMenuName())) {
      punishUtil.handlePunishMenuClick(e, player);
      e.setCancelled(true);
    } else if (title.equalsIgnoreCase(PunishMenuName.BAN_PUNISHMENT_MENU.getMenuName())) {
      if ((e.getCurrentItem()).getType().equals(Material.AIR)) return;
      Validate.notNull(e.getCurrentItem(), "There is no Current Item");
      punishUtil.handleConfirmMenuClick(
          player,
          target,
          PunishMenuName.BAN_CONFIRM_MENU.getMenuName(),
          "Ban",
          punishUtil.getBAN_ITEM(),
          e.getCurrentItem());
      e.setCancelled(true);
    } else if (title.equalsIgnoreCase(PunishMenuName.MUTE_PUNISHMENT_MENU.getMenuName())) {
      if ((e.getCurrentItem()).getType().equals(Material.AIR)) return;
      punishUtil.handleConfirmMenuClick(
          player,
          target,
          PunishMenuName.MUTE_CONFIRM_MENU.getMenuName(),
          "Mute",
          punishUtil.getMUTE_ITEM(),
          e.getCurrentItem());
      e.setCancelled(true);
    } else if (title.equalsIgnoreCase(PunishMenuName.MUTE_CONFIRM_MENU.getMenuName())
        || title.equalsIgnoreCase(PunishMenuName.BAN_CONFIRM_MENU.getMenuName())) {
      punishUtil.handleConfirmMenuActions(e, player, target);
      e.getWhoClicked().closeInventory();
    }
  }
}
