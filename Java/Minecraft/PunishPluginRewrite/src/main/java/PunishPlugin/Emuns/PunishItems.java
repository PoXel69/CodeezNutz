package PunishPlugin.Emuns;

import org.bukkit.Material;

public enum PunishItems {
  BAN(Material.WOODEN_AXE),
  MUTE(Material.NOTE_BLOCK),
  CANCEL(Material.BARRIER);

  private final Material material;

  PunishItems(Material material) {
    this.material = material;
  }

  public Material getMaterial() {
    return material;
  }
}
