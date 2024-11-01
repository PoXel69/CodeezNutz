package PunishPlugin.Helpers;

import PunishPlugin.Exceptions.PunishMessageBuilderExceptions;
import org.bukkit.ChatColor;

public class PunishMessageBuilder {

  private String mode;
  private String executor;
  private String target;
  private String duration;
  private String reason;

  public PunishMessageBuilder setMode(String mode) {
    if (mode == null) {
      this.mode = PunishMessageBuilderExceptions.modeIsNull;
      return this;
    }
    this.mode = ChatColor.translateAlternateColorCodes('&', mode);
    return this;
  }

  public PunishMessageBuilder setExecutor(String executor) {
    if (executor == null) {
      this.executor = PunishMessageBuilderExceptions.executorIsNull;
      return this;
    }
    this.executor = ChatColor.translateAlternateColorCodes('&', executor);
    return this;
  }

  public PunishMessageBuilder setTarget(String target) {
    if (target == null) {
      this.target = PunishMessageBuilderExceptions.targetIsNull;
      return this;
    }
    this.target = ChatColor.translateAlternateColorCodes('&', target);
    return this;
  }

  public PunishMessageBuilder setDuration(String duration) {
    if (duration == null) {
      this.duration = PunishMessageBuilderExceptions.durationIsNull;
      return this;
    }
    this.duration = ChatColor.translateAlternateColorCodes('&', duration);
    return this;
  }

  public PunishMessageBuilder setReason(String reason) {
    if (reason == null) {
      this.reason = PunishMessageBuilderExceptions.reasonIsNull;
      return this;
    }
    this.reason = ChatColor.translateAlternateColorCodes('&', reason);
    return this;
  }

  public String build() {
    String line = ChatColor.STRIKETHROUGH + "                                         ";
    String modeLine = ChatColor.translateAlternateColorCodes('&', "&2&lMode: " + mode);
    String executorLine = ChatColor.translateAlternateColorCodes('&', "&2&lExecutor: " + executor);
    String targetLine = ChatColor.translateAlternateColorCodes('&', "&2&lTarget: " + target);
    String durationLine = ChatColor.translateAlternateColorCodes('&', "&2&lDuration: " + duration);
    String reasonLine = ChatColor.translateAlternateColorCodes('&', "&2&lReason: " + reason);
    return line
        + "\n"
        + ""
        + modeLine
        + ""
        + "\n"
        + ""
        + executorLine
        + ""
        + "\n"
        + ""
        + targetLine
        + ""
        + "\n"
        + ""
        + durationLine
        + ""
        + "\n"
        + ""
        + reasonLine
        + ""
        + "\n"
        + ""
        + line;
  }
}
