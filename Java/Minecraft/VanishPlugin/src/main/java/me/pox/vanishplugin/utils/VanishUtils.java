package me.pox.vanishplugin.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class VanishUtils {
	public static void actionBar(Player target, String message) {
		target.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText
				(ChatColor.translateAlternateColorCodes('&', message
				)));
	}
}


