package ozlympic;

import java.util.ArrayList;

import java.util.Random;

/**
 * Advanced Programming Semester 1 2017 Assignment 2
 *
 * @author Jake Novak s3609685
 *
 * github: github.com/jhoxton/AP
 *
 */
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
	
	public ArrayList<Athlete> runEvent (ArrayList<Athlete> eventAthletes, Event upcoming, ArrayList<Official> offs) {
		
		this.setCode(code);	//Assigns a code to the event	
		String superName = name;
		Random randomizer = new Random();		
		ArrayList<Athlete> athInComp = new ArrayList<Athlete>(); 
		athInComp = eventAthletes;
		
		Athlete ath1 = athInComp.get(randomizer.nextInt(athInComp.size()));		
		int time1 =ath1.compete(superName);			
		athInComp.remove(ath1);

		
		Athlete ath2 = athInComp.get(randomizer.nextInt(athInComp.size()));
		int time2 =ath2.compete(superName);		
		athInComp.remove(ath2);
		
		Athlete ath3 = athInComp.get(randomizer.nextInt(athInComp.size()));		
		int time3 =ath3.compete(superName);
		
		athInComp.remove(ath3);

		if ( time1 < time2 && time1 < time3 ) { //ATH1 WINS
			ath1.setScore(5);			
			setWinner(ath1.getName());
			setWinnerId(ath1.getId());
			setFirstTime(time1);
			
			if (time2 < time3) {
				ath2.setScore(2);				
				setSecond(ath2.getName());	
				setSecondTime(time2);
				ath3.setScore(1);
				setThird(ath3.getName());
				setThirdTime(time3);
				
			} else if (time3 < time2) {
				ath3.setScore(2);
				setSecond(ath3.getName());
				setSecondTime(time3);
				ath2.setScore(1);
				setThird(ath2.getName());
				setThirdTime(time2);
				
			}						
		} else if (time2 < time1 && time2 < time3) {//ATH2 WINS		
			ath2.setScore(5);					
			setWinner(ath2.getName());
			setWinnerId(ath2.getId());
			setFirstTime(time2);
			
			if (time1 < time3) {
				ath1.setScore(2);
				setSecond(ath1.getName());
				setSecondTime(time1);
				ath3.setScore(1);
				setThird(ath3.getName());
				setThirdTime(time3);
				
			} else if (time3 < time1) {
				ath3.setScore(2);
				setSecond(ath3.getName());
				setSecondTime(time3);
				ath2.setScore(1);
				setThird(ath2.getName());
				setThirdTime(time2);
				
			}
		} else if ( time3 < time2 && time3 < time1 ) {	//ATH3 WINS
			ath3.setScore(5);
			setWinner(ath3.getName());
			setWinnerId(ath3.getId());
			setFirstTime(time3);
			
			if (time2 < time1) {
				ath2.setScore(2);
				setSecond(ath2.getName());
				setSecondTime(time2);
				ath1.setScore(1);
				setThird(ath1.getName());
				setThirdTime(time1);
				
			} else if (time1 < time2) {
				ath1.setScore(2);
				setSecond(ath1.getName());
				setSecondTime(time1);
				ath2.setScore(1);
				setThird(ath2.getName());
				setThirdTime(time2);
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
