package org.alex.happy.game;

import java.util.ArrayList;
import java.util.List;

import org.alex.happy.participant.Player;
import org.alex.happy.participant.PrimaryPlayer;
import org.alex.happy.participant.PrimaryReferee;
import org.alex.happy.participant.Referee;

public class ChessRoom {

	
	public static void main(String[] args) throws Exception {
		
		Player player1 = new PrimaryPlayer();
		Player player2 = new PrimaryPlayer();
		Player player3 = new PrimaryPlayer();
		
		List<Player> players = new ArrayList<Player>(3);
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		Referee referee = new PrimaryReferee();
		Game game = new HappyGame(players,referee);
		player1.play(game);
		player2.play(game);
		player3.play(game);
		referee.rule(game);
		referee.shuffle();
		referee.distribute();
		referee.startGame();
		System.out.println(player1.getHandPokers().size()+"张牌： "+player1.getHandPokers());
		System.out.println(player2.getHandPokers().size()+"张牌： "+player2.getHandPokers());
		System.out.println(player3.getHandPokers().size()+"张牌： "+player3.getHandPokers());
		
		
//		referee.startGame();
//		
//		game.getWinner();
		
	}
	
	
}
