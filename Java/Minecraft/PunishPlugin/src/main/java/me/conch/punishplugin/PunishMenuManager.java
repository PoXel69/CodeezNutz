package me.conch.punishplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PunishMenuManager {

  private final Map<String, Consumer<Player>> inventoryMap = new HashMap<>();

  PunishMenuUtil punishMenuUtil = new PunishMenuUtil();

  public PunishMenuManager() {
    inventoryMap.put(PunishMenuName.PUNISH_GUI.getMenuName(), this::openPunishMenu);
    inventoryMap.put(PunishMenuName.BAN_PUNISHMENT_MENU.getMenuName(), this::openBanMenuClick);
    inventoryMap.put(PunishMenuName.MUTE_PUNISHMENT_MENU.getMenuName(), this::openMuteMenuClick);
    inventoryMap.put(PunishMenuName.BAN_CONFIRM_MENU.getMenuName(), this::openBanConfirmMenuClick);
    inventoryMap.put(
        PunishMenuName.MUTE_CONFIRM_MENU.getMenuName(), this::openMuteConfirmMenuClick);
  }

  public void openPunishMenu(Player player) {
    Inventory punishGUI =
        new InventoryBuilder()
            .setPlayer(player)
            .setSize(9)
            .setTitle(PunishMenuName.PUNISH_GUI.getMenuName())
            .build();
    punishMenuUtil.addMenuItem(punishGUI, punishMenuUtil.getBAN_ITEM(), "Ban Player", 2);
    punishMenuUtil.addMenuItem(punishGUI, punishMenuUtil.getMUTE_ITEM(), "Mute Player", 6);
    player.openInventory(punishGUI);
  }

  // Opens the ban punishment menu
  public void openBanMenuClick(Player player) {
    Inventory banPunishmentMenu =
        new InventoryBuilder()
            .setPlayer(null)
            .setSize(18)
            .setTitle(PunishMenuName.BAN_PUNISHMENT_MENU.getMenuName())
            .build();

    // Add various ban reasons to the menu
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.WHITE_WOOL, "Admitting To Cheat");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.FEATHER, "Boosting");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.DANDELION, "Cheat Found in SS");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.COMPASS, "Cross Teaming");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.BRICKS, "Inappropriate Building");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.LEATHER_CHESTPLATE, "Bad " + "Skin");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.NAME_TAG, "Inappropriate Username");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.WITHER_ROSE, "Kill Farm");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.DIAMOND, "Modified File Before SS");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.LILY_OF_THE_VALLEY, "SS Refusing");
    punishMenuUtil.addReasonItem(banPunishmentMenu, Material.SKELETON_SKULL, "Unfair Advantage");

    player.openInventory(banPunishmentMenu);
  }

  // Opens the mute punishment menu
  public void openMuteMenuClick(Player player) {
    Inventory mutePunishmentMenu =
        new InventoryBuilder()
            .setPlayer(null)
            .setSize(9)
            .setTitle(PunishMenuName.MUTE_PUNISHMENT_MENU.getMenuName())
            .build();

    // Add various mute reasons to the menu
    punishMenuUtil.addReasonItem(mutePunishmentMenu, Material.EMERALD, "Advertisement");
    punishMenuUtil.addReasonItem(mutePunishmentMenu, Material.BOWL, "Begging");
    punishMenuUtil.addReasonItem(mutePunishmentMenu, Material.ZOMBIE_HEAD, "Impersonation");
    punishMenuUtil.addReasonItem(mutePunishmentMenu, Material.BOOK, "Spamming");
    punishMenuUtil.addReasonItem(
        mutePunishmentMenu, Material.WITHER_SKELETON_SKULL, "Staff/Content Creator Insult");
    punishMenuUtil.addReasonItem(mutePunishmentMenu, Material.OAK_SIGN, "Swearing/Toxicity");

    player.openInventory(mutePunishmentMenu);
  }

  public void openBanConfirmMenuClick(Player player) {
    punishMenuUtil.handleConfirmMenuClick(
        player,
        new PunishCommand().getTarget(),
        PunishMenuName.BAN_CONFIRM_MENU.getMenuName(),
        "BAN",
        punishMenuUtil.getBAN_ITEM(),
        null);
  }

  public void openMuteConfirmMenuClick(Player player) {
    punishMenuUtil.handleConfirmMenuClick(
        player,
        new PunishCommand().getTarget(),
        PunishMenuName.BAN_CONFIRM_MENU.getMenuName(),
        "BAN",
        punishMenuUtil.getBAN_ITEM(),
        null);
  }
}
