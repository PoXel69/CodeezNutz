package PunishPlugin;

import PunishPlugin.Commands.PunishCommand;
import PunishPlugin.Listeners.BanAndMuteMenuListener;
import PunishPlugin.Listeners.PunishMenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PunishPlugin extends JavaPlugin {

  @Override
  public void onEnable() {

    Bukkit.getLogger().info("Hello, World!");
    //    saveDefaultConfig();
    getCommand("punish").setExecutor(new PunishCommand());
    Bukkit.getPluginManager().registerEvents(new PunishMenuListener(), this);
    Bukkit.getPluginManager().registerEvents(new BanAndMuteMenuListener(), this);
  }
}
