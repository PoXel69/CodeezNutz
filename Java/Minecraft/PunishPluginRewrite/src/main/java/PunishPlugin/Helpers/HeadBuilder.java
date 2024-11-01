package PunishPlugin.Helpers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadBuilder {
  private final ItemStack itemStack;
  private final SkullMeta skullMeta;

  public HeadBuilder() {
    this.itemStack = new ItemStack(Material.PLAYER_HEAD);
    this.skullMeta = (SkullMeta) itemStack.getItemMeta();
  }

  public HeadBuilder setName(String name) {
    skullMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    return this;
  }

  public HeadBuilder setOwner(Player player) {
    skullMeta.setOwningPlayer(player);
    return this;
  }

  public ItemStack build() {
    itemStack.setItemMeta(skullMeta);
    return itemStack;
  }
}
