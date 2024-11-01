package PunishPlugin.Listeners;

import PunishPlugin.Menus.Inventories.BanMenu;
import PunishPlugin.Menus.Inventories.MuteMenu;
import PunishPlugin.Menus.Inventories.PunishMenu;
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

    // Check And Open Inventories
    if (event.getClickedInventory().getHolder().equals(PunishMenu.getPunishGUI().getHolder())
        && event.getWhoClicked().hasPermission("staff")
        && event.getClickedInventory().equals(PunishMenu.getPunishGUI())) {
      switch (event.getCurrentItem().getType()) {
        case NOTE_BLOCK -> MuteMenu.openMuteMenu(player);
        case WOODEN_AXE -> BanMenu.openBanMenu(player);
      }
      event.setCancelled(true);
    }
  }
}
