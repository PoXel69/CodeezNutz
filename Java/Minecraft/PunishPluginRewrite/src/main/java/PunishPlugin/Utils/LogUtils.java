package PunishPlugin.Utils;

public class LogUtils {
  public String notNull(Object value, String message) {
    if (value == null) {
      return message;
    }
    return "";
  }

  public String ifNull(String value) {
    if (value == null) {
      return value;
    }
    return "";
  }
}
