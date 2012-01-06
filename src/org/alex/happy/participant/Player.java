package org.alex.happy.participant;

import java.util.List;
import java.util.Observer;

import org.alex.happy.domain.Poker;
import org.alex.happy.game.Game;
import org.alex.happy.template.Template;

public interface Player extends Observer,Runnable{
	
	public void play(Game game);
	public List<Poker> getHandPokers();
	public void acceptPoker(Poker poker);
	public Template handOut(Template template);
	
}
