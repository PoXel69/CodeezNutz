//package me.pox.tutorial.listeners;
//
//import me.pox.tutorial.Tutorial;
//import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryClickEvent;
//
//public class InventoryListener implements Listener {
//    public InventoryListener(Tutorial plugin) {
//        Bukkit.getPluginManager().registerEvents(this, plugin);
//    }
//
//    @EventHandler
//    public void onInventoryClick(InventoryClickEvent e) {
//
//        if (e.getWhoClicked() instanceof Player player) {
//
//            var clickedItem = e.getCurrentItem();
//
//            if (clickedItem.getType() == Material.DIAMOND_BLOCK) {
//                player.sendMessage("Damn cuh, you rich.");
//            } else if (clickedItem.getType() != Material.AIR) {
//                player.sendMessage("You clicked on " + clickedItem.getType());
//            }
//        }
//    }
//}
