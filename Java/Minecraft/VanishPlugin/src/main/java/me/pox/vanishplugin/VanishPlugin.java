package me.pox.vanishplugin;

import me.pox.vanishplugin.commands.VanishCommand;
import me.pox.vanishplugin.listeners.JoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class VanishPlugin extends JavaPlugin {
	public ArrayList<Player> vanishPlayers = new ArrayList<>();


	@Override
	public void onEnable() {
		//~~~~~~commands~~~~~~
		getCommand("vanish").setExecutor(new VanishCommand(this));
		//~~~~~~events~~~~~~
		new JoinEvent(this);
	}
}
