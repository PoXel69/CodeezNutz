package me.pox.tutorial.events;

import me.pox.tutorial.Tutorial;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class GameEndEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private final Player winner;
	private final Player loser;
	private final int finalScore;

	public GameEndEvent(Tutorial plugin, Player winner, Player loser, int finalScore) {
		this.winner     = winner;
		this.loser      = loser;
		this.finalScore = finalScore;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Player getWinner() {
		return winner;
	}

	public Player getLoser() {
		return loser;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public HandlerList getHandlers() {
		return handlers;
	}
}

