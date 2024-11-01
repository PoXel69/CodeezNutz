package me.conch.punishplugin;

public enum PunishMenuName {
  PUNISH_GUI("&7Select A Punish Form"),
  BAN_PUNISHMENT_MENU("&6Select A Ban Punishment"),
  MUTE_PUNISHMENT_MENU("&5Select a Mute Punishment"),
  BAN_CONFIRM_MENU("&4Ban Confirm Menu"),
  MUTE_CONFIRM_MENU("&3Mute Confirm Menu");

  private final String menuName;

  PunishMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuName() {
    return menuName;
  }
}
