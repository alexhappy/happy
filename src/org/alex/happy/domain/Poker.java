package org.alex.happy.domain;

public class Poker implements Comparable<Poker>{

	public static final int COLOR_HEARTS=4;//红桃
	public static final int COLOR_SPADES=3;//黑桃
	public static final int COLOR_FLOWER=2;//梅花
	public static final int COLOR_SQUARE=1;//方片
	public static final int COLOR_KING=0;//王
	//定义牌字的大小，为了方便比大小。
	public static final int NUM_3=3;
	public static final int NUM_4=4;
	public static final int NUM_5=5;
	public static final int NUM_6=6;
	public static final int NUM_7=7;
	public static final int NUM_8=8;
	public static final int NUM_9=9;
	public static final int NUM_10=10;
	public static final int NUM_J=11;
	public static final int NUM_Q=12;
	public static final int NUM_K=13;
	public static final int NUM_A=14;
	public static final int NUM_2=15;
	public static final int NUM_LKING=16;
	public static final int NUM_BKING=17;
	
	
	private int color;
	private int number;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		String cstr="";
		switch (color) {
		case COLOR_HEARTS:
			cstr="红桃" ;break;
		case COLOR_SPADES:
			cstr="黑桃" ;break;
		case COLOR_FLOWER:
			cstr="梅花" ;break;
		case COLOR_SQUARE:
			cstr="方片" ;break;
		case COLOR_KING:
			cstr="王" ;break;
		default:
			
			break;
		}
		String num=Integer.toString(number);
		if(num.equals("17"))
			num="大";
		if(num.equals("16"))
			num="小";
		if(num.equals("15"))
			num="2";
		if(num.equals("14"))
			num="A";
		if (num.equals("13")) {
			num="K";
		}
		if (num.equals("12")) {
			num="Q";
		}
		if (num.equals("11")) {
			num="J";
		}
		
		
		return "["+cstr + "," + num + "]";
	}
	public boolean bigger(Poker poker){
		if(this.getNumber()-poker.getNumber()>0){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public int compareTo(Poker poker) {

		if(poker.getNumber()!=this.getNumber()){
			return 0-(this.getNumber()-poker.getNumber());
		}else{
			return 0-(this.getColor()-poker.getColor());
		}
	}
	
	
}
