package OzlympicGames;

import java.util.Random;

public class Sprinter extends Athlete  {

	public Sprinter(int id, String name, String type, int age, String state, int score) {
		super(id, name,type, age, state, score);
		
	}
	@Override
	public int compete(String superName) {
		
		int maximum = 20;
		int minimum = 10;
		
		Random rn = new Random();
		int range = maximum - minimum + 1;
		int time =  rn.nextInt(range) + minimum;
		return time;
		
	}

}
