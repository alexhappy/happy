package org.alex.happy.participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import org.alex.happy.domain.Poker;
import org.alex.happy.game.Game;
import org.alex.happy.template.SingleTemplate;
import org.alex.happy.template.Template;

public class PrimaryPlayer implements Player {

	private List<Poker> pokers=new LinkedList<Poker>();
	private Game game ;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Game game) {
		this.game=game;
	}

	@Override
	public List<Poker> getHandPokers() {
		return pokers;
	}

	@Override
	public void acceptPoker(Poker poker) {
		this.pokers.add(poker);
		shuffle();
	}
	
	private void shuffle() {
		Collections.sort(pokers);
	}
	

	@Override
	public Template handOut(Template template) {
		Template out=null;
		if(template==null){
			out=getRandom();
		}else {
			
			out=getBigger(template);
		}
		if (out==null) {
			System.out.println("*不出");
		}
		if (pokers.size()==0) {
			game.getReferee().overGame(this);
		}
		return out;
		
	}
	private Template getBigger(Template template){
		List<Poker> before=template.getPokers();
		List<Poker> out=new ArrayList<Poker>();
		for(int i=pokers.size()-1;i>=0;i--){
			Poker poker=pokers.get(i);
			if(poker.bigger(before.get(0))){
				pokers.remove(poker);
				out.add(poker);
				break;
			}
		}
		if(out.size()==0){
			return null;
		}
		Template sTemplate=new SingleTemplate(out);
		
		System.out.println("#出大牌"+out);
		
		return sTemplate;
	}
	private Template getRandom(){
		int n = pokers.size();
		Random random = new Random();
		int i = random.nextInt(n);
		Poker poker = pokers.get(i);
		pokers.remove(i);
		
		List<Poker> out=new ArrayList<Poker>(1);
		out.add(poker);
		Template sTemplate=new SingleTemplate(pokers);
		System.out.println("#随意出牌"+out);
		return sTemplate;
	}
	@Override
	public void run() {
		
	}

}
