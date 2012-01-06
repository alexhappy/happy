package org.alex.happy.game;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;

import org.alex.happy.domain.APoker;
import org.alex.happy.participant.Player;
import org.alex.happy.participant.Referee;

public interface Game {

	public Lock getWait();
	public Lock getTurn();
	
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public void setEndDate(Date endDate) ;
	public Date getEndDate();
	public void setWinner(Player winner);
	public Player getWinner();
	public boolean isOver();
	public APoker getaPoker();
	public void setaPoker(APoker aPoker);
	public int getPlayerNum();
	public List<Player> getPlayers();
	public void setOver(boolean over);
	public int getRemainNum();
	public Referee getReferee();
}
