package PunishPlugin.Menus.Inventories;

import PunishPlugin.Helpers.InventoryBuilder;
import PunishPlugin.Helpers.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BanMenu {
  private static Inventory banInventory;

  public static Inventory getBanInventory() {
    return banInventory;
  }

  public static void openBanMenu(Player player) {

    banInventory =
        new InventoryBuilder().setPlayer(player).setSize(18).setTitle("&b&lBan Menu").build();
    ItemStack test =
        new ItemBuilder(Material.WITHER_SKELETON_SKULL)
            .setName("&cStaff/Contect Creator Insult")
            .build();
    banInventory.setItem(3, test);
    player.openInventory(banInventory);
  }
}
