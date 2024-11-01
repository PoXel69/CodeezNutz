//package me.pox.tutorial.commands;
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//public class PacketCommand implements CommandExecutor {
//	@Override
//	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//		if (sender instanceof Player player && args.length > 1) {
//			Player target = Bukkit.getPlayer(args[0]);
//			if (target == null) {
//				player.sendMessage(ChatColor.RED + "Player does not exist");
//			} else {
//				StringBuilder builder = new StringBuilder();
//				for (int i = 1; i < args.length; i++) {
//					builder.append(args[i] + " ");
//				}
//				String             title          = builder.toString().trim();
//				String             formattedTitle = ChatColor.translateAlternatecolorCodes('&', title);
//				PlayerConnection   connection     = ((CraftPlayer) target.getPlayer());
//				IChatComponent     text           = IChatComponent.ChatSerializer.a("{'text': '" + formattedTitle + "'}");
//				PacketPlayOutTitle packet         = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, text, 1, 80, 1);
//				connection.sendMessage(packet);
//				player.sendMessage(target.getName() + " was sent the title " + title);
//			}
//		}
//		return true;
//	}
//}
