package utils;

import me.pox.tutorial.Tutorial;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

public class RTPUtils {

	private static final HashSet<Material> blockList = new HashSet<>();

	static {
		blockList.add(Material.LAVA);
		blockList.add(Material.WATER);
	}

	// ~~~~~~vars~~~~~~
	private final Tutorial plugin;
	private final int maxDistance;
	private final int minDistance;
	// cooldown related vars
	private final int cooldownInt;
	private final HashMap<UUID, Long> cooldown;

	public RTPUtils(Tutorial plugin) {
		this.plugin = plugin;
		maxDistance = this.plugin.getConfig().getInt("maxDistance", 10000);
		minDistance = this.plugin.getConfig().getInt("minDistance", 1000);
		cooldownInt = this.plugin.getConfig().getInt("cooldown", 20000);
		cooldown    = new HashMap<>();

	}

	protected void playerCooldown(Player player) {
		if (cooldown.containsKey(player.getUniqueId()) && System.currentTimeMillis() - cooldown.get(player.getUniqueId()) < cooldownInt) {
			player.sendMessage(playerCooldownTime(player));
			return;
		}
		player.sendMessage("Teleporting . . .");
		cooldown.put(player.getUniqueId(), System.currentTimeMillis());
		playerTeleport(player);
	}

	private void playerTeleport(Player player) {
		player.teleport(locationGenerator(player));
	}

	private Location locationGenerator(Player player) {
		int playerX = getRandomCoords(maxDistance, minDistance);
		int playerY = player.getLocation().getBlockY();
		int playerZ = getRandomCoords(maxDistance, minDistance);

		Location randomLocation = new Location(player.getWorld(), playerX, playerY, playerZ);
		playerY = randomLocation.getWorld().getHighestBlockAt(randomLocation).getY();
		randomLocation.setY(playerY);

		while (!isLocationSafe(randomLocation)) {
			randomLocation = locationGenerator(player);
		}
		return randomLocation;
	}

	private boolean isLocationSafe(Location loc) {
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();

		Block block  = loc.getWorld().getBlockAt(x, y, z);
		Block below  = loc.getWorld().getBlockAt(x, y - 1, z);
		Block ablove = loc.getWorld().getBlockAt(x, y + 1, z);


		return !(blockList.contains(below.getType()) || block.getType().isSolid() || ablove.getType().isSolid());
	}

	private String playerCooldownTime(Player player) {
		final long cooldownEndTime          = cooldown.get(player.getUniqueId()) + cooldownInt;
		final long currentTime              = System.currentTimeMillis();
		final long remainingCooldownMillis  = cooldownEndTime - currentTime;
		final long remainingCooldownSeconds = Math.max(0, remainingCooldownMillis / 1000);
		return String.format("%s Cooldown for another: %s %d second%s", ChatColor.RED, ChatColor.YELLOW, remainingCooldownSeconds, remainingCooldownSeconds == 1 ? "" : "s");
	}

	private int getRandomCoords(int max, int min) {
		Random random = new Random();
		return random.nextInt((max - min + 1)) + min;
	}
}
