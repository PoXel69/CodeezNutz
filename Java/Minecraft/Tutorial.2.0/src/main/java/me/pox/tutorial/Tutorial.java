package me.pox.tutorial;

import me.pox.tutorial.commands.*;
import me.pox.tutorial.files.CustomConfig;
import me.pox.tutorial.listeners.ArmorStandListener;
import me.pox.tutorial.listeners.EntityListener;
import me.pox.tutorial.listeners.GameListener;
import me.pox.tutorial.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin {
	@Override
	public void onEnable() {

		// ~~~~~~config~~~~~~
		CustomConfig.setup();
		CustomConfig.get().addDefault("name", "gfhghfjjfgy");
		CustomConfig.get().options().copyDefaults(true);
		CustomConfig.save();
		getConfig().options().copyDefaults();
		saveDefaultConfig();

		// ~~~~~~Events~~~~~~
		new MenuListener(this);
		new GameListener(this);
		new EntityListener(this);
		new ArmorStandListener(this);

		// ~~~~~~Commands~~~~~~
		getCommand("tp").setExecutor(new TeleportCommand());
		getCommand("god").setExecutor(new GodCommand());
		getCommand("fly").setExecutor(new FlyCommand(this));
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("sign").setExecutor(new SignCommand());
		getCommand("fmsg").setExecutor(new MessageCommand());
		getCommand("menu").setExecutor(new PlayerMenuCommand());
		getCommand("tpall").setExecutor(new TeleportAllCommand());
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("weapon").setExecutor(new WeaponCommand());
		getCommand("repeat").setExecutor(new RepeatCommand());
		getCommand("vision").setExecutor(new NightVisionCommand());
		getCommand("hologram").setExecutor(new HologramCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
		getCommand("armorstand").setExecutor(new ArmorStandCommand(this));
		getCommand("random-teleport").setExecutor(new RandomTeleportCommand(this));
	}
}