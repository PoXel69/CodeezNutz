package PunishPlugin.Listeners;

import PunishPlugin.Helpers.PunishMessageBuilder;
import org.bukkit.entity.Player;

public class PunishModeHandler {
  private Player player;
  private String mode;
  private String playerTarget;

  public PunishModeHandler setPlayer(Player player) {
    this.player = player;
    return this;
  }

  public PunishModeHandler setMode(String mode) {
    this.mode = mode;
    return this;
  }

  public PunishModeHandler setTarget(String target) {
    this.playerTarget = target;
    return this;
  }

  public void build() {
    String message =
        new PunishMessageBuilder()
            .setMode("&6&l" + mode)
            .setReason("&4random")
            .setDuration("&3100yr")
            .setExecutor("&1" + player.getDisplayName())
            .setTarget("&5" + playerTarget)
            .build();
    player.sendMessage(message);
  }
}
