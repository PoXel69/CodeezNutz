package PunishPlugin.Managers;

import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PunishMenuManager {

  public void accessInventory(Player player, Inventory inventory) {
    UUID playerUUID = player.getUniqueId();

    if (inventory != null) {
      player.openInventory(inventory);
    } else {
      player.sendMessage("No inventory found for you.");
    }
  }
}
