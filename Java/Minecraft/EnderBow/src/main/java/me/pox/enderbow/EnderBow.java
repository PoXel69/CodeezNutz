package me.pox.enderbow;

import me.pox.enderbow.commands.GiveCommand;
import me.pox.enderbow.listeners.TPBowListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnderBow extends JavaPlugin {

	@Override
	public void onEnable() {

		//~~~~~~config.yml~~~~~~
		saveDefaultConfig();
		getConfig().options().copyDefaults();
		//~~~~~~Events~~~~~~
		new TPBowListener(this);
		//~~~~~~commands~~~~~~
		getCommand("enderbow").setExecutor(new GiveCommand(this));
	}
}