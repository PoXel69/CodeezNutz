package PunishPlugin.Listeners;

import PunishPlugin.Commands.PunishCommand;
import PunishPlugin.Helpers.MyHolder;
import PunishPlugin.Helpers.PunishMessageBuilder;
import PunishPlugin.Inventories.MuteMenu;
import org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MuteMenuListener implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Validate.notNull(event.getClickedInventory());
    player.sendMessage("First inv Holder\n" + event.getClickedInventory().getHolder());
    player.sendMessage("second inv Holder\n" + MuteMenu.openMuteMenu(player).getHolder());

    if (event.getClickedInventory().getHolder() instanceof MyHolder) {
      //      new PunishModeHandler()
      //          .setMode("Mute")
      //          .setPlayer(player)
      //          .setTarget(new PunishCommand().getTarget())
      //          .build();
      player.sendMessage(
          new PunishMessageBuilder()
              .setMode("&6&lMute")
              .setReason("&4random")
              .setDuration("&3100yr")
              .setExecutor("&1" + player.getDisplayName())
              .setTarget("&5" + new PunishCommand().getTarget())
              .build());
      event.setCancelled(true);
    }
  }
}
