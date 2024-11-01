package me.pox.armorstandplugin;

import me.pox.armorstandplugin.commands.ArmodStandCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorStandPlugin extends JavaPlugin {

	@Override
	public void onEnable() {

		//~~~~~~commands~~~~~~
		getCommand("armor-stand2").setExecutor(new ArmodStandCommand());
	}
}
