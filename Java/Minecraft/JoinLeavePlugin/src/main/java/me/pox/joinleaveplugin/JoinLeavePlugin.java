package me.pox.joinleaveplugin;

import me.pox.joinleaveplugin.Listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeavePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		//~~~~~~config.yml~~~~~~
		saveDefaultConfig();
		//~~~~~~listeners~~~~~~
		new JoinLeaveListener(this);
	}

}
