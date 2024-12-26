package PunishPlugin.Listeners;

import PunishPlugin.Commands.PunishCommand;
import PunishPlugin.Helpers.MyHolder;
import org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanMenuListener implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Validate.notNull(event.getClickedInventory());

    if (event.getClickedInventory().getHolder() instanceof MyHolder) {
      new PunishModeHandler()
          .setMode("Ban")
          .setPlayer(player)
          .setTarget(new PunishCommand().getTarget())
          .build();
      event.setCancelled(true);
    }
  }
}
