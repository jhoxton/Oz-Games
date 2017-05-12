package ozlympic;

import java.util.Random;

public class Cyclist extends Athlete  {

	public Cyclist(int id, String name, String type, int age, String state, int score) {
		super(id, name,type, age, state, score);
	}	
	@Override
	public int compete(String superName) {
		
		int maximum = 800;
		int minimum = 500;
		
		Random rn = new Random();
		int range = maximum - minimum + 1;
		int time =  rn.nextInt(range) + minimum;
		return time;
		
	}
	
}
