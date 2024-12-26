package PunishPlugin.Commands;

import PunishPlugin.Inventories.PunishMenu;
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

  private void setTarget(String target) {
    this.target = target;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      player = (Player) sender;
      if (args.length == 0) {
        return false;
      }
      setTarget(args[0]);
      player.sendMessage("args must be set by now, checking...\n" + getTarget());
      PunishMenu.openPunishMenu(player);
      player.sendMessage("reached end of command");
    }
    return true;
  }
}
