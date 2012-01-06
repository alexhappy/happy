package org.alex.happy.template;

import java.util.List;

import org.alex.happy.domain.Poker;
import org.alex.happy.participant.Player;

public interface Template {

	public static final int TYPE_SINGLE=0;
	public static final int TYPE_DOUBLE=1;
	
	
	public Player getOutPlayer();
	public List<Poker> getBigPokers(List<Poker> pokers);
	public List<Poker> getPokers();
	public int getTemplateType();
	public void setOutPlayer(Player outPlayer);
}
