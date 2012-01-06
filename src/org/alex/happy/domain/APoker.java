package org.alex.happy.domain;

import java.util.ArrayList;
import java.util.List;

public class APoker {

	private static final int[] colors=new int[]{Poker.COLOR_HEARTS,Poker.COLOR_SPADES,Poker.COLOR_FLOWER,Poker.COLOR_SQUARE};
	private static final int[] nums=new int[]{Poker.NUM_3,Poker.NUM_4,Poker.NUM_5,Poker.NUM_6,Poker.NUM_7,Poker.NUM_8,Poker.NUM_9,Poker.NUM_10,Poker.NUM_J,Poker.NUM_Q,Poker.NUM_K,Poker.NUM_A,Poker.NUM_2};
	private List<Poker> pokers;
	
	
	private void init(){
		pokers=new ArrayList<Poker>(54);
		for(int i=0;i<colors.length;i++){
			for(int j=0;j<nums.length;j++){
				Poker poker =new Poker();
				poker.setColor(colors[i]);
				poker.setNumber(nums[j]);
				pokers.add(poker);
			}
		}
		Poker lKing=new Poker();
		lKing.setColor(Poker.COLOR_KING);
		lKing.setNumber(Poker.NUM_LKING);
		Poker bKing=new Poker();
		bKing.setColor(Poker.COLOR_KING);
		bKing.setNumber(Poker.NUM_BKING);
		
		pokers.add(lKing);
		pokers.add(bKing);
		
	}
	public APoker(){
		 init();
	}
	public List<Poker> getAll(){
		return pokers;
	}
	public static void main(String[] args) {
		APoker aPoker = new APoker();
		System.out.println(aPoker.getAll());
	}
	
}
