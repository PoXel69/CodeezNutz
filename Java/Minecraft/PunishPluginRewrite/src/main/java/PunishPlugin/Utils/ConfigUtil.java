package PunishPlugin.Utils;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigUtil {
  private File file;
  private FileConfiguration config;

  public ConfigUtil(Plugin plugin, String path) {
    this(plugin.getDataFolder().getAbsolutePath() + "/" + path);
  }

  public ConfigUtil(String path) {
    this.file = new File(path);
    this.config = YamlConfiguration.loadConfiguration(this.file);
  }

  public File getFile() {
    return file;
  }

  public FileConfiguration getConfig() {
    return config;
  }

  public boolean save() {
    try {
      this.config.save(this.file);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
	  return false;
  }
}
