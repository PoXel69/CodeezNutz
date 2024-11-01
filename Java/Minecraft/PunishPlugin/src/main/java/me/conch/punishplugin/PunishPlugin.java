package me.conch.punishplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class PunishPlugin extends JavaPlugin {

  @Override
  public void onEnable() {

    // ~~~~~~config~~~~~~
    getLogger().info("before config");
    getConfig().options().copyDefaults();
    getLogger().info("after config");
    saveDefaultConfig();
    getLogger().info("after saveDefault config");
    // ~~~~~~commands~~~~~~
    getLogger().info("before command");
    getCommand("punish").setExecutor(new PunishCommand());
    getLogger().info("after command");
    // ~~~~~~Listeners~~~~~~
    getLogger().info("before Listener");
    //    new PunishInventoryListener(this);
    getLogger().info("after Listener");
  }
}
