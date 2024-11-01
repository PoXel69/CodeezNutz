package PunishPlugin.Helpers;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
  private final ItemStack itemStack;
  private final ItemMeta itemMeta;

  public ItemBuilder(Material material) {
    this.itemStack = new ItemStack(material);
    this.itemMeta = itemStack.getItemMeta();
  }

  public ItemBuilder setName(String name) {
    itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    return this;
  }

  public ItemBuilder setLore(List<String> lore) {
    itemMeta.setLore(lore);
    return this;
  }

  public ItemStack build() {
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
}
