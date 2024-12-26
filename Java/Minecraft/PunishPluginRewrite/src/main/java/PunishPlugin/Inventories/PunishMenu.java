package PunishPlugin.Inventories;

import PunishPlugin.Emuns.PunishItems;
import PunishPlugin.Helpers.HeadBuilder;
import PunishPlugin.Helpers.InventoryBuilder;
import PunishPlugin.Helpers.ItemBuilder;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishMenu {

  public static Inventory openPunishMenu(Player player) {
    Inventory punishGUI = new InventoryBuilder().setSize(9).setTitle("&2&lPunishment Menu").build();
    ItemStack banItem =
        new ItemBuilder(PunishItems.BAN.getMaterial())
            .setName("&cBan")
            .setLore(List.of("Ban this Player"))
            .build();
    ItemStack muteItem =
        new ItemBuilder(PunishItems.MUTE.getMaterial())
            .setName("&cMute")
            .setLore(List.of("Mute this Player"))
            .build();
    ItemStack playerHead =
        new HeadBuilder().setOwner(player).setName(player.getDisplayName()).build();
    punishGUI.setItem(1, banItem);
    punishGUI.setItem(4, playerHead);
    punishGUI.setItem(7, muteItem);
    player.openInventory(punishGUI);
    return punishGUI;
  }
}
