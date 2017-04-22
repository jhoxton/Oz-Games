package OzlympicGames;

import java.util.ArrayList;

public class RunningEvent extends Event {
	
	public RunningEvent () {
		super();
		setName("Running Event");	
		setCode("R0" + getEventsRun());
	}
	
	@Override
	public ArrayList<Athlete> loadEvent(ArrayList<Athlete> athletes){ //NEW ATTEMPT
		
		ArrayList<Athlete> tempArray = new ArrayList<Athlete>(); 
//		System.out.println(athletes.size());//Tests correct array was sent

		for (int i=0; i < athletes.size(); i++) {			
			Athlete currentAthlete = athletes.get(i);		
			if	(currentAthlete instanceof Sprinter || currentAthlete instanceof SuperAthlete) {
				tempArray.add(currentAthlete);					
//				System.out.println("Check method worked" + currentAthlete.getName());// Checks the loop has worked correctly				
				} 
			}		
		return tempArray;
	}
	
	
}
