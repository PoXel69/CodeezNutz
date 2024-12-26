package PunishPlugin.Inventories;

import PunishPlugin.Helpers.InventoryBuilder;
import PunishPlugin.Helpers.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BanMenu {

  public static Inventory openBanMenu(Player player) {
    Inventory banInventory = new InventoryBuilder().setSize(18).setTitle("&b&lBan Menu").build();
    ItemStack test =
        new ItemBuilder(Material.WITHER_SKELETON_SKULL)
            .setName("&cStaff/Contect Creator Insult")
            .build();
    banInventory.setItem(3, test);
    player.openInventory(banInventory);
    return banInventory;
  }
}
