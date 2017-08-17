package skill.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Tennis {
	private static String[] points = {"Love","Fifteen","Thirty","Deuce","All","Advantage Player ","Win for Player "};
	private static int[] players = {0,0};
	private static LinkedList<String> game = new LinkedList<>();
	private static boolean finished = false;
	
	public static void main(String[] args) {
		game.add("Love-All");
		while(!finished) {
			nextPoint();
			valute();
		}
		String[] history = game.toArray(new String[0]);
		System.out.println(Arrays.toString(history));
	}//main

	private static void nextPoint() {
		// Real points - virtual points
		// 			0 - 0
		// 			15 - 1
		// 			30 - 2
		// 			40 - 3 
		//			40+ - 4
		// 			45 - 5
		int gamer = new Random().nextInt(2);
		switch(players[gamer]) {
			case 3:
				if(players[(gamer + 1) % 2] == 4)
					players[(gamer + 1) % 2] = 3;
				else if(players[(gamer + 1) % 2] == 3)
					players[gamer] = 4;
				else {
					players[gamer] = 5;
					finished = true;
				}
				break;
			case 4:
				players[gamer] = 5;
				finished = true;
				break;
			default:
				players[gamer]++;
		}
	}//nextPoint
	
	private static void valute() {
		int a = players[0], b = players[1];
		String s = "";
		if(a == b) {
			switch(a) {
				case 1: 
					s = points[1] + "-" + points[4]; break;
				case 2: 
					s = points[2] + "-" + points[4]; break;
				default:
					s = points[3];
			}
		} else if(players[0] < 3 && players[1] < 3) {
			switch(a) {
				case 0: 
					s = points[0] + "-"; break;
				case 1: 
					s = points[1] + "-"; break;
				default:
					s = points[2] + "-";
			}
			switch(b) {
				case 0: 
					s += points[0]; break;
				case 1: 
					s += points[1]; break;
				default:
					s += points[2];
			}
		} else if(players[0] == 4 || players[0] == 3) 
			s = points[5] + "1";
		else if(players[0] == 5)
			s = points[6] + "1"; 
		else if(players[1] == 4 || players[1] == 3) 
			s = points[5] + "2";
		else if(players[1] == 5)
			s = points[6] + "2"; 
		game.add(s);
	}//valute
}//Tennis