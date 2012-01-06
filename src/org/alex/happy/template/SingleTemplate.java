package org.alex.happy.template;

import java.util.ArrayList;
import java.util.List;

import org.alex.happy.domain.Poker;
import org.alex.happy.participant.Player;

public class SingleTemplate implements Template{

	private static final int type=Template.TYPE_SINGLE;
	private Player outPlayer;
	private List<Poker> pokers =new ArrayList<Poker>(1);

	
	public SingleTemplate(List<Poker> pokers){
		this.pokers.addAll(pokers);
	}
	
	@Override
	public List<Poker> getPokers() {
		return pokers;
	}

	@Override
	public int getTemplateType() {
		return type;
	}

	@Override
	public List<Poker> getBigPokers(List<Poker> pokers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getOutPlayer() {
		return outPlayer;
	}

	public void setOutPlayer(Player outPlayer) {
		this.outPlayer = outPlayer;
	}
	

}
