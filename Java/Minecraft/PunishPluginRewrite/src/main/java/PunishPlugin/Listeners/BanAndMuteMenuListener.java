package PunishPlugin.Listeners;

import PunishPlugin.Commands.PunishCommand;
import PunishPlugin.Helpers.PunishMessageBuilder;
import PunishPlugin.Menus.Inventories.BanMenu;
import PunishPlugin.Menus.Inventories.MuteMenu;
import org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanAndMuteMenuListener implements Listener {
  PunishCommand punishCommand = new PunishCommand();

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Validate.notNull(event.getClickedInventory());

    // Check And Open Inventories
    if (event.getClickedInventory().getHolder().equals(BanMenu.getBanInventory().getHolder())
        && event.getWhoClicked().hasPermission("staff")
        && event.getClickedInventory().equals(BanMenu.getBanInventory())) {
      String message =
          new PunishMessageBuilder()
              .setMode("&6&lBan")
              .setReason("&4random")
              .setDuration("&3100yr")
              .setExecutor("&1" + player.getDisplayName())
              .setTarget("&5" + punishCommand.getTarget())
              .build();
      player.sendMessage(message);
      event.setCancelled(true);
    }

    if (event.getClickedInventory().getHolder().equals(MuteMenu.getMuteInventory().getHolder())
        && event.getWhoClicked().hasPermission("staff")
        && event.getClickedInventory().equals(MuteMenu.getMuteInventory())) {
      String message =
          new PunishMessageBuilder()
              .setMode("&6&lMute")
              .setReason("&6random")
              .setDuration("&9100yr")
              .setExecutor(player.getDisplayName())
              .setTarget(punishCommand.getTarget())
              .build();
      player.sendMessage(message);
      event.setCancelled(true);
    }
    player.sendMessage("failed");
  }
}
