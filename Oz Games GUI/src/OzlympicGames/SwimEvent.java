package OzlympicGames;

import java.util.ArrayList;

public class SwimEvent extends Event {
			
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
