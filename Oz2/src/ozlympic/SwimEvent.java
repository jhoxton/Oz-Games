package ozlympic;

import java.util.ArrayList;

public class SwimEvent extends Event {
	/**
	 * Advanced Programming Semester 1 2017 Assignment 2
	 *
	 * @author Jake Novak s3609685
	 *
	 * github: github.com/jhoxton/AP
	 *
	 */	
	public SwimEvent () {
		super();
		setName("Swimming Event");		
		setCode("S0" + getEventsRun());
	}

	@Override
	public ArrayList<Athlete> loadEvent(ArrayList<Athlete> athletes){
		
		ArrayList<Athlete> tempArray = new ArrayList<Athlete>(); 

		for (int i=0; i < athletes.size(); i++) {			
			Athlete currentAthlete = athletes.get(i);		
			if	(currentAthlete instanceof Swimmer || currentAthlete instanceof SuperAthlete) {
				tempArray.add(currentAthlete);					
				}
			}		
		return tempArray;
	}
	
	
	
	
	
}
