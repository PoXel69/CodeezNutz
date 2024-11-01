package PunishPlugin.Menus.Inventories;

import PunishPlugin.Helpers.HeadBuilder;
import PunishPlugin.Helpers.InventoryBuilder;
import PunishPlugin.Helpers.ItemBuilder;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishMenu {
  private static Inventory punishGUI;

  public static Inventory getPunishGUI() {
    return punishGUI;
  }

  public static void openPunishMenu(Player player) {
    punishGUI =
        new InventoryBuilder().setPlayer(player).setSize(9).setTitle("&2&lPunishment Menu").build();
    ItemStack banItem =
        new ItemBuilder(Material.WOODEN_AXE)
            .setName("&cBan")
            .setLore(List.of("Ban this Player"))
            .build();
    ItemStack muteItem =
        new ItemBuilder(Material.NOTE_BLOCK)
            .setName("&cMute")
            .setLore(List.of("Mute this Player"))
            .build();
    ItemStack playerHead =
        new HeadBuilder().setOwner(player).setName(player.getDisplayName()).build();
    punishGUI.setItem(1, banItem);
    punishGUI.setItem(4, playerHead);
    punishGUI.setItem(7, muteItem);
    player.openInventory(punishGUI);
    //    new PunishMenuManager().accessInventory(player, punishGUI);
  }
}
