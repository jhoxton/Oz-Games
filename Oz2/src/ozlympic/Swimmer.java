package ozlympic;

import java.util.Random;

public class Swimmer extends Athlete {

	public Swimmer(int id, String name, String type, int age, String state, int score) {
		super(id, name,type, age, state, score);
		
	}	
	@Override
	public int compete(String superName) {
		
		int maximum = 200;
		int minimum = 100;
		
		Random rn = new Random();
		int range = maximum - minimum + 1;
		int time =  rn.nextInt(range) + minimum;
		return time;
		
	}

}
