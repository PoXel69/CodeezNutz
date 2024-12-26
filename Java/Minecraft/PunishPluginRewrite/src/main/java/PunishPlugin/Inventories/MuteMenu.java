package PunishPlugin.Inventories;

import PunishPlugin.Helpers.InventoryBuilder;
import PunishPlugin.Helpers.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MuteMenu {
  private static Inventory muteInventory;

  public static Inventory openMuteMenu(Player player) {

    muteInventory = new InventoryBuilder().setSize(18).setTitle("&b&lMute").build();
    ItemStack test =
        new ItemBuilder(Material.WITHER_SKELETON_SKULL)
            .setName("&cStaff/Contect Creator Insult")
            .build();
    muteInventory.setItem(3, test);
    player.openInventory(muteInventory);
    return muteInventory;
  }
}
