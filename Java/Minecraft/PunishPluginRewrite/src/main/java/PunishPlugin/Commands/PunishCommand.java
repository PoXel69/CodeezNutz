package PunishPlugin.Commands;

import PunishPlugin.Menus.Inventories.PunishMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor {
  private Player player;
  private String target;

  public Player getPlayer() {
    return player;
  }

  public String getTarget() {
    return target;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      player = (Player) sender;
      if (args.length == 0) {
        return false;
      }
      target = args[0];
      PunishMenu.openPunishMenu(player);
      player.sendMessage("reached end of command");
    }
    return true;
  }
}
