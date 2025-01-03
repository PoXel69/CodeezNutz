package PunishPlugin.Listeners;

import PunishPlugin.Helpers.MyHolder;
import PunishPlugin.Inventories.BanMenu;
import PunishPlugin.Inventories.MuteMenu;
import org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishMenuListener implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Validate.notNull(event.getClickedInventory());

    if (event.getClickedInventory().getHolder() instanceof MyHolder) {
      switch (event.getCurrentItem().getType()) {
        case NOTE_BLOCK -> MuteMenu.openMuteMenu(player);
        case WOODEN_AXE -> BanMenu.openBanMenu(player);
      }
      event.setCancelled(true);
    }
  }
}
