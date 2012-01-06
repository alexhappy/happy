package org.alex.happy.game;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.alex.happy.domain.APoker;
import org.alex.happy.participant.Player;
import org.alex.happy.participant.Referee;

public class HappyGame implements Game{

	private static final int REMAIN_NUM = 3;
	private static final int PLAYER_NUM=3;
	private Date startDate;
	private Date endDate;
	private Player winner;
	private APoker aPoker;
	private boolean over;
	private List<Player> players;
	private Referee referee;
	
	
	public HappyGame(List<Player> players,Referee referee) throws Exception{
		
		if(players.size()!=getPlayerNum()){
			throw new Exception("大于比赛人数");
		}
		
		startDate = Calendar.getInstance().getTime();
		aPoker=new APoker();
		endDate=null;
		winner=null;
		over=false;
		this.players=players;
		this.referee=referee;
		
	}
	@Override
	public int getPlayerNum() {
		return PLAYER_NUM;
	}
	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void setOver(boolean over) {
		this.over = over;
	}


	
	@Override
	public APoker getaPoker() {
		return aPoker;
	}
	@Override
	public void setaPoker(APoker aPoker) {
		this.aPoker = aPoker;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}
	@Override
	public Date getEndDate() {
		return endDate;
	}
	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public Player getWinner() {
		return winner;
	}
	@Override
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	@Override
	public boolean isOver() {
		return over;
	}
	@Override
	public int getRemainNum() {
		return REMAIN_NUM;
	}
	@Override
	public Referee getReferee() {
		return referee;
	}
	
	
	
	
}
