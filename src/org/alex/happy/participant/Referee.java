package org.alex.happy.participant;

import org.alex.happy.game.Game;
import org.alex.happy.template.Template;

public interface Referee{

	public void rule(Game game);
	public void shuffle();
	public void distribute();
	public void warnPlayer(Player player);
	public void startGame() throws InterruptedException;
	public void overGame(Player player);
	public Template turnPlayer(Player player, Template template);
}
