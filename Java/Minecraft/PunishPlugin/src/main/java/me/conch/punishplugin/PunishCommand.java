package me.conch.punishplugin;

import org.apache.commons.lang3.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor {
  PunishMenuManager punishManager = new PunishMenuManager();
  private Player target;

  public Player getTarget() {
    return target;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
      if (args.length != 1) {
        player.sendMessage(ChatColor.RED + "Usage: /" + label + " <username>");
        return true;
      }

      target = Bukkit.getPlayer(args[0]);
      Validate.notNull(target, ChatColor.RED + "Target Not Found.");
      punishManager.openPunishMenu(player);
      player.sendMessage("1001");
      return true;
    }
    return true;
  }
}
