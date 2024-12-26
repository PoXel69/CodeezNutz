package PunishPlugin.Helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder {
  private int size;
  private String title;

  public InventoryBuilder setSize(int size) {
    this.size = size;
    return this;
  }

  public InventoryBuilder setRowSize(int size) {
    this.size = size * 9;
    return this;
  }

  public InventoryBuilder setTitle(String title) {
    this.title = ChatColor.translateAlternateColorCodes('&', title);
    return this;
  }

  public Inventory build() {
    return Bukkit.createInventory(
        new MyHolder(), size, ChatColor.translateAlternateColorCodes('&', title));
  }
}
