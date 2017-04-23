package OzlympicGames;
import java.util.*;
import javafx.application.Application;

/*
 * Advanced Programming Semester 1 2017 Assignment 1
 * Jake Novak s3609685
 * 
 * github: github.com/jhoxton/AP
 * 
 * Some println functions have been left in (commented out) to show points I used for testing
 *
 */


	public class Ozlympic {

	static Scanner input = new Scanner(System.in);
	protected static boolean eventSet = false;
	public static int userPic= 0;
	static Event upcoming = new Event();//This is the primary event object for each Game
	
	public static void main(String[] args) {
		
		ArrayList<Athlete> comp = new ArrayList<Athlete>(); 
		ArrayList<Offical> offs = new ArrayList<Offical>();// Arraylist of Officials. And, yes I know it's spelled wrong
		readFile r = new readFile();
		
		r.openFile();	
		r.readFile(comp);
		r.closeFile();
		
		r.openFile();
		r.readOffsFile(offs);
		r.closeFile();

//		TODO: Add exception catches 
//		TODO: Look into XMLBeans
		
//		ArrayList<Athlete> comp = new ArrayList<Athlete>(); // The main arraylist that stores all athletes
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>(); // Arraylsit to store athletes for the next upcoming event 		
		ArrayList<String> done = new ArrayList<String>(); //List of Strings with past game details
		
			
		menu(comp, upcoming, loadArray, offs, done);//Launches the menu		
	}
	

	public static void menu(ArrayList<Athlete> comp, Event upcoming, ArrayList<Athlete> loadArray, ArrayList<Offical> offs, ArrayList<String> done) {
		
		System.out.println("\n==============");
		
		System.out.println("Ozlympic Games\n==============");
		
		if(eventSet == true) {
			System.out.println("The next event to be held is a " + upcoming.getName() + "\n");
		} else {
			System.out.println("No upcoming event\n");
		}
		
		System.out.println("1) Select a Game to Run\n2) Predict the Winner of Game\n3) Start the Game\n4) Display the results of all Games\n5) Display points of all athletes\n6) Exit\n");
		System.out.println("Enter an Option: ");
		
		try {
		int option = input.nextInt();
			switch(option) {
				case 1: selectGame(comp, upcoming, loadArray, offs, done);
					break;					
				case 2: predictGame(comp, loadArray, upcoming, offs, done);
					break;
				case 3: startGame(comp, upcoming, loadArray, offs, done); 				
					break;
				case 4: displayGames(comp, loadArray, offs, done);
					break;
				case 5: displayAthletes(comp, loadArray, offs, done);
					break;
				case 6: 
					System.out.println("Arrays cleared. Games reset. Goodbye!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option!");
					menu(comp, upcoming, loadArray, offs, done);
			}
		}catch (Exception e) {
			System.out.println("Invalid input\nPlease enter a number between 1-6");
			System.out.println();			
			}
		
		return;
			
		}
	
	static void selectGame(ArrayList<Athlete> comp, Event upcoming, ArrayList<Athlete> loadArray, ArrayList<Offical> offs, ArrayList<String> done) {
		
		Event currentEvent = new Event();		
	
		System.out.println("Select event to hold:\n1) Swimming Event\n2) Sprinting Event\n3) Cycling Event");
		int option = input.nextInt();
		loadArray = comp;
		
//		System.out.println(loadArray.size()); //Tests the loadArray is correct and that no athletes have been removed 
		
			if(option == 1) {				
				currentEvent = new SwimEvent();
				eventSet = true;				
				ArrayList<Athlete> returningArray = new ArrayList<Athlete>(); 			
				returningArray = currentEvent.loadEvent(loadArray);//Calls the "loadEvent" method which determines if athletes are eligible to compete 
				loadArray = returningArray;				

				System.out.println("The competeing athletes are: \n" );
				for(int i = 0; i < loadArray.size(); i++) {
					Athlete currentAthlete = loadArray.get(i);
					System.out.println(currentAthlete.getName());
				}
				
			} else if(option ==2) {				
				currentEvent = new RunningEvent();
				eventSet = true;				
				ArrayList<Athlete> returningArray = new ArrayList<Athlete>(); 			
				returningArray = currentEvent.loadEvent(loadArray); 
				loadArray = returningArray;				

				System.out.println("The competeing athletes are " );
				for(int i = 0; i < loadArray.size(); i++) {
					Athlete currentAthlete = loadArray.get(i);
					System.out.println(currentAthlete.getName());
				}				
//				System.out.println(returningArray); //This tests the correct array was returned 
	
			} else if (option ==3) {
				currentEvent = new CyclingEvent();
				eventSet = true;				
				ArrayList<Athlete> returningArray = new ArrayList<Athlete>(); 			
				returningArray = currentEvent.loadEvent(loadArray); 
				loadArray = returningArray;				

				System.out.println("The competeing athletes are " );
				for(int i = 0; i < loadArray.size(); i++) {
					Athlete currentAthlete = loadArray.get(i);
					
					
					
					
					
					System.out.println(currentAthlete.getName());
				}
			} else {
				System.out.println("Please select an event to hold");
			}
			
			currentEvent = upcoming;

			Offical test = pickOffical(offs);
			System.out.println("Overseeing offical is: " + test.getName());
			upcoming.setOffical(test);
			//Assigns an official to a game

			menu(comp, upcoming, loadArray, offs, done); 
			return;		
	} 
	
	static void predictGame(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, Event upcoming, ArrayList<Offical> offs, ArrayList<String> done) {
		
		if(eventSet ==false ) {
			System.out.println("Please select an event to hold first");			
			menu(comp, upcoming, loadArray, offs, done);
		} else {		
			for (int i=0; i < loadArray.size(); i++) {			
				Athlete loopAth = loadArray.get(i);		
				System.out.println("Name: " + loopAth.getName()+ "\nID: " + loopAth.getId()+  "\n======== ");	
			}
			System.out.println("Enter ID of athlete you predict will win: ");
			userPic = input.nextInt();
			menu(comp, upcoming, loadArray, offs, done);
		}		
	}
	
	static void startGame(ArrayList<Athlete> comp, Event upcoming,ArrayList<Athlete> loadArray, ArrayList<Offical> offs, ArrayList<String> done) {
		
		if(eventSet ==false ) {
			System.out.println("Please select an event to hold first");
			menu(comp, upcoming, loadArray, offs, done);
		} else {							
			System.out.println("Offical for " + upcoming.getCode() + " is " + upcoming.getOffical().getName());
			upcoming.runEvent(comp, upcoming, loadArray, offs);	//The event launches here
			
			Event finEvent = new Event();	
			finEvent = upcoming;		
			int winner=  finEvent.getWinnerId();
			//Makes an new event reference to cross check the users prediction with
			if (userPic != winner) {
				System.out.println("");
			} else {
				System.out.println("Congrats! You picked the winner!");
			}			
		}				
		
		String result = new String ("========\n" + "The winner of " + (upcoming.getCode()) + " was " + (upcoming.getWinner()) + "\n" +
				"Second place was " + (upcoming.getSecond()) + "\n" +
				"Third place was " + (upcoming.getThird()) + "\n" + "========\n");
		//Adds the events details (as a String) to the "done" array list
		done.add(result);
		
		eventSet = false;
		menu(comp, upcoming, loadArray, offs, done);		
		
	}

	static void displayGames(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, ArrayList<Offical> offs, ArrayList<String> done) {
		
		for (int i = 0; i < done.size(); i++) {
			String test = done.get(i);
		System.out.println(test);
		}		
		menu(comp, upcoming, loadArray, offs, done);		
	}

	static void displayAthletes(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, ArrayList<Offical> offs,  ArrayList<String> done) {
		
		for(int i = 0; i < comp.size(); i++) {			
			Athlete currentAthlete = comp.get(i);			
			System.out.println("=============");
			System.out.println("Name:" +currentAthlete.getName());
			System.out.println("Type: " + currentAthlete.getType());
			System.out.println("Age:" +currentAthlete.getAge());
			System.out.println("State:" +currentAthlete.getState());
			System.out.println("Current Score:" +currentAthlete.getScore());			
		}
		
		menu(comp, upcoming, loadArray, offs, done);
	}

	public static Offical pickOffical(ArrayList<Offical> offs) {
	    Random rand = new Random(); 
	    Offical randomOff = offs.get(rand.nextInt(offs.size()));
	    return randomOff;
	}
}
