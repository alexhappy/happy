package org.alex.happy.participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.alex.happy.domain.APoker;
import org.alex.happy.domain.Poker;
import org.alex.happy.game.Game;
import org.alex.happy.template.Template;

public class PrimaryReferee implements Referee{

	ExecutorService pool = Executors.newCachedThreadPool(); 
	private Game ruleGame;
	
	
	@Override
	public void rule(Game game) {
		ruleGame=game;
		
	}

	@Override
	public void startGame() throws InterruptedException{
		int i=0;
		
		ruleGame.getTurn().lock();
		ruleGame.getWait().lock();
		
		Template template=null;
//		List<Player> players = ruleGame.getPlayers();
//		for(Player player:players){
//			pool.execute(player);
//		}
		while(!ruleGame.isOver())
		{
			System.out.println("轮到 "+i+" 号选手出牌");
			Thread.sleep(1000);
			Template outTemplate=turnPlayer(ruleGame.getPlayers().get(i),template);
			System.out.println("剩余手牌"+ruleGame.getPlayers().get(i).getHandPokers());
			if(outTemplate!=null)
			template=outTemplate;
			i=(i+1)%ruleGame.getPlayerNum();
				
		}
	}
	@Override
	public void shuffle() {
		
		APoker aPoker=ruleGame.getaPoker();
		List<Poker> pokers =aPoker.getAll();
		int num=pokers.size();
		List<Poker> shuffledPokers=new ArrayList<Poker>(54);
		Random random =new Random();
		while(num!=0){
			
			int index=random.nextInt(num);
			Poker poker =pokers.get(index);
			pokers.remove(index);
			shuffledPokers.add(poker);
			num--;
		}
		aPoker.getAll().addAll(shuffledPokers);
		System.out.println(aPoker.getAll().size()+" " +aPoker.getAll());
		
	}

	@Override
	public void distribute() {
		List<Poker> pokers = ruleGame.getaPoker().getAll();
		List<Player> players =ruleGame.getPlayers();
		int n = pokers.size();
		while(n>ruleGame.getRemainNum()){
			for(int i=0;i<players.size();i++){
				Poker poker=pokers.get(n-1);
				players.get(i).acceptPoker(poker);
				n--;
			}
		}
	}

	@Override
	public Template turnPlayer(Player player,Template template) {
		return player.handOut(template);
	}

	@Override
	public void warnPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void overGame(Player player) {
		ruleGame.setWinner(player);
		ruleGame.setOver(true);
		System.out.println("游戏结束");
	}
	
}
