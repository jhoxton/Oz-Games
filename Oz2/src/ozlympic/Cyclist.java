package ozlympic;

import java.util.Random;

public class Cyclist extends Athlete  {

	/**
	 * Advanced Programming Semester 1 2017 Assignment 2
	 *
	 * @author Jake Novak s3609685
	 *
	 * github: github.com/jhoxton/AP
	 *
	 */
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
