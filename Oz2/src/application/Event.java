package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Event {
	
	private static String name;
	private static String code;	
	private static int eventsRun;
	private String winner;
	private String second;
	private String third;
	private int winnerId;	
	private Official offical;
	private int firstTime;
	private int secondTime;
	private int thirdTime;
	
	public ArrayList<Athlete> athletes= new ArrayList<Athlete>();
	public ArrayList<Official> officalInEvent = new ArrayList<Official>();
	
	public ArrayList<Athlete> runEvent (ArrayList<Athlete> eventAthletes, Event upcoming, ArrayList<Official> offs) {

		officalInEvent = offs;		
		this.setCode(code);	//Assigns a code to the event	
		String superName = name;
		Random randomizer = new Random();		
		ArrayList<Athlete> athInComp = new ArrayList<Athlete>(); 
		athInComp = eventAthletes;
		
		Athlete ath1 = athInComp.get(randomizer.nextInt(athInComp.size()));		
		int time1 =ath1.compete(superName);	
		
		athInComp.remove(ath1);//Removes array list reference to prevent doubling up
							   // If athlete references start disappearing, this is where it happens
		
		Athlete ath2 = athInComp.get(randomizer.nextInt(athInComp.size()));
		int time2 =ath2.compete(superName);		
		
		athInComp.remove(ath2);
		
		Athlete ath3 = athInComp.get(randomizer.nextInt(athInComp.size()));		
		int time3 =ath3.compete(superName);
		
		athInComp.remove(ath3);
		
		System.out.println("=============");
		System.out.println(getName()+ " " +getCode());
		System.out.println("=============");
		

		if ( time1 < time2 && time1 < time3 ) { //ATH1 WINS
			System.out.println("The winner is " + ath1.getName() + " at " + time1);
			ath1.setScore(5);			
			setWinner(ath1.getName());
			setWinnerId(ath1.getId());
			setFirstTime(time1);
			
			if (time2 < time3) {
				System.out.println("\nSecond place is " + ath2.getName() + " at " + time2);
				ath2.setScore(2);				
				setSecond(ath2.getName());	
				setSecondTime(time2);
				System.out.println("\nThird place is " + ath3.getName() + " at " + time3);
				ath3.setScore(1);
				setThird(ath3.getName());
				setThirdTime(time3);
				System.out.println("=============");
				
			} else if (time3 < time2) {
				System.out.println("\nSecond place is " + ath3.getName() + " at " + time3);
				ath3.setScore(2);
				setSecond(ath3.getName());
				setSecondTime(time3);
				System.out.println("\nThird place is " + ath2.getName() + " at " + time2);
				ath2.setScore(1);
				setThird(ath2.getName());
				setThirdTime(time2);
				System.out.println("=============");
				
			}						
		} else if (time2 < time1 && time2 < time3) {//ATH2 WINS		
			System.out.println("The winner is " + ath2.getName() + " at " + time2);
			ath2.setScore(5);					
			setWinner(ath2.getName());
			setWinnerId(ath2.getId());
			setFirstTime(time2);
			
			if (time1 < time3) {
				System.out.println("\nSecond place is " + ath1.getName() + " at " + time1);
				ath1.setScore(2);
				setSecond(ath1.getName());
				setSecondTime(time1);
				System.out.println("\nThird place is " + ath3.getName() + " at " + time3);
				ath3.setScore(1);
				setThird(ath3.getName());
				setThirdTime(time3);
				System.out.println("=============");
				
			} else if (time3 < time1) {
				System.out.println("\nSecond place is " + ath3.getName() + " at " + time3);
				ath3.setScore(2);
				setSecond(ath3.getName());
				setSecondTime(time3);
				System.out.println("\nThird place is " + ath1.getName() + " at " + time2);
				ath2.setScore(1);
				setThird(ath2.getName());
				setThirdTime(time2);
				System.out.println("=============");
				
			}
		} else if ( time3 < time2 && time3 < time1 ) {	//ATH3 WINS
			System.out.println("\nThe winner is " + ath3.getName() + " at " + time3);
			ath3.setScore(5);
			setWinner(ath3.getName());
			setWinnerId(ath3.getId());
			setFirstTime(time3);
			
			if (time2 < time1) {
				System.out.println("\nSecond place is " + ath2.getName() + " at " + time2);
				ath2.setScore(2);
				setSecond(ath2.getName());
				setSecondTime(time2);
				System.out.println("\nThird place is " + ath1.getName() + " at " + time1);
				ath1.setScore(1);
				setThird(ath1.getName());
				setThirdTime(time1);
				System.out.println("=============");
				
			} else if (time1 < time2) {
				System.out.println("\nSecond place is " + ath1.getName() + " at " + time1);
				ath1.setScore(2);
				setSecond(ath1.getName());
				setSecondTime(time1);
				System.out.println("\nThird place is " + ath2.getName() + " at " + time2);
				ath2.setScore(1);
				setThird(ath2.getName());
				setThirdTime(time2);
				System.out.println("=============");				
			}
		}
		
		return eventAthletes; 
	}
	//TODO Delete this once the above works
	public ArrayList<Athlete> OLDrunEventDELETE_THIS (ArrayList<Athlete> eventAthletes, Event upcoming, ArrayList<Official> offs) {

		officalInEvent = offs;		
		this.setCode(code);	//Assigns a code to the event	
		String superName = name;
		Random randomizer = new Random();		
		ArrayList<Athlete> athInComp = new ArrayList<Athlete>(); 
		athInComp = eventAthletes;
		
		Athlete ath1 = athInComp.get(randomizer.nextInt(athInComp.size()));		
		int time1 =ath1.compete(superName);	
		
		athInComp.remove(ath1);//Removes array list reference to prevent doubling up
							   // If athlete references start disappearing, this is where it happens
		
		Athlete ath2 = athInComp.get(randomizer.nextInt(athInComp.size()));
		int time2 =ath2.compete(superName);		
		
		athInComp.remove(ath2);
		
		Athlete ath3 = athInComp.get(randomizer.nextInt(athInComp.size()));		
		int time3 =ath3.compete(superName);
		
		athInComp.remove(ath3);
		
		System.out.println("=============");
		System.out.println(getName()+ " " +getCode());
		System.out.println("=============");
		

		if ( time1 < time2 && time1 < time3 ) { //ATH1 WINS
			System.out.println("The winner is " + ath1.getName() + " at " + time1);
			ath1.setScore(5);			
			setWinner(ath1.getName());
			setWinnerId(ath1.getId());
			
			if (time2 < time3) {
				System.out.println("\nSecond place is " + ath2.getName() + " at " + time2);
				ath2.setScore(2);				
				setSecond(ath2.getName());				
				System.out.println("\nThird place is " + ath3.getName() + " at " + time3);
				ath3.setScore(1);
				setThird(ath3.getName());
				System.out.println("=============");
				
			} else if (time3 < time2) {
				System.out.println("\nSecond place is " + ath3.getName() + " at " + time3);
				ath3.setScore(2);
				setSecond(ath3.getName());
				System.out.println("\nThird place is " + ath3.getName() + " at " + time2);
				ath2.setScore(1);
				setThird(ath2.getName());
				System.out.println("=============");
				
			}						
		} else if (time2 < time1 && time2 < time3) {//ATH2 WINS		
			System.out.println("The winner is " + ath2.getName() + " at " + time2);
			ath2.setScore(5);					
			setWinner(ath2.getName());
			setWinnerId(ath2.getId());
			
			if (time1 < time3) {
				System.out.println("\nSecond place is " + ath1.getName() + " at " + time1);
				ath1.setScore(2);
				setSecond(ath1.getName());
				System.out.println("\nThird place is " + ath3.getName() + " at " + time3);
				ath3.setScore(1);
				setThird(ath3.getName());
				System.out.println("=============");
				
			} else if (time3 < time1) {
				System.out.println("\nSecond place is " + ath3.getName() + " at " + time3);
				ath3.setScore(2);
				setSecond(ath3.getName());
				System.out.println("\nThird place is " + ath2.getName() + " at " + time2);
				ath2.setScore(1);
				setThird(ath2.getName());
				System.out.println("=============");
				
			}
		} else if ( time3 < time2 && time3 < time1 ) {	//ATH3 WINS
			System.out.println("\nThe winner is " + ath3.getName() + " at " + time3);
			ath3.setScore(5);
			setWinner(ath3.getName());
			setWinnerId(ath3.getId());
			
			if (time2 < time1) {
				System.out.println("\nSecond place is " + ath2.getName() + " at " + time2);
				ath2.setScore(2);
				setSecond(ath2.getName());
				System.out.println("\nThird place is " + ath1.getName() + " at " + time1);
				ath1.setScore(1);
				setThird(ath1.getName());
				System.out.println("=============");
				
			} else if (time1 < time2) {
				System.out.println("\nSecond place is " + ath1.getName() + " at " + time1);
				ath1.setScore(2);
				setSecond(ath1.getName());
				System.out.println("\nThird place is " + ath2.getName() + " at " + time2);
				ath2.setScore(1);
				setThird(ath2.getName());
				System.out.println("=============");				
			}
		}
		
		return eventAthletes; 
	}



	public ArrayList<Athlete> loadEvent(ArrayList<Athlete> athletes){
		this.athletes = athletes;
		return athletes;				
	}
	
	public String getName() {	
		return name;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getEventsRun() {
		eventsRun ++;
		return eventsRun;
	}

	public static void setEventsRun(int eventsRun) {
		Event.eventsRun = eventsRun;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

	public int getWinnerId() {
		
		return winnerId;
	}

	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}

	public Official getOfficial() {
		return offical;
	}

	public void setOfficial(Official offical) {
		this.offical = offical;
	}
	public int getSecondTime() {
		return secondTime;
	}
	public void setSecondTime(int secondTime) {
		this.secondTime = secondTime;
	}
	public int getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(int firstTime) {
		this.firstTime = firstTime;
	}
	public int getThirdTime() {
		return thirdTime;
	}
	public void setThirdTime(int thirdTime) {
		this.thirdTime = thirdTime;
	}
	
}
