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
		readFile r = new readFile();
		
		r.openFile();	
		r.readFile(comp);
		r.closeFile();
		System.out.println("Current added Athletes are ");
		
//		TODO: Add exception catches 
//		TODO: Look into XMLBeans
		
//		ArrayList<Athlete> comp = new ArrayList<Athlete>(); // The main arraylist that stores all athletes
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>(); // Arraylsit to store athletes for the next upcoming event 		
		ArrayList<Offical> offs = new ArrayList<Offical>();// Arraylist of Officials. And, yes I know it's spelled wrong
		ArrayList<String> done = new ArrayList<String>(); //List of Strings with past game details
		
		Offical off1 = new Offical(1, "Lesie", "Offical", 35, "NSW", 0);
		Offical off2 = new Offical(2, "Ben","Offical", 36,"VIC", 0);		
		Offical off3 = new Offical(3,"Ann","Offical",33, "NSW", 0);
		Offical off4 = new Offical(4,"Ron","Offical", 45, "NSW", 0);
		Offical off5 = new Offical(4,"Tom","Offical", 31, "QLD", 0);
				
		offs.add(off1);
		offs.add(off2);
		offs.add(off3);
		offs.add(off4);
		offs.add(off5);
				
//		Cyclist cycle = new Cyclist(1, "Chloe Hosking","Cyclist",26, "VIC", 0); 
//		Cyclist cycle2 = new Cyclist(2, "Sara Carrigan","Cyclist", 36,"NSW", 0); 
//		Cyclist cycle3 = new Cyclist(3, "Ben Dyball", "Cyclist", 27,"NSW", 0);
//		Cyclist cycle4 = new Cyclist(4, "Allan Davis","Cyclist", 36,"QLD", 0); 
//		
//		comp.add(cycle);
//		comp.add(cycle2);
//		comp.add(cycle3);
//		comp.add(cycle4);
//		
//		Swimmer swim = new Swimmer(5, "Taylor McKeown","Swimmer", 22,"QLD", 0); 
//		Swimmer swim2 = new Swimmer(6, "Stephanie Rice", "Swimmer",28,"28", 0); 
//		Swimmer swim3 = new Swimmer(7, "Cameron Delaney","Swimmer", 36,"NSW", 0); 
//		Swimmer swim4 = new Swimmer(8, "Brenton Rickard","Swimmer", 33,"33", 0); 
//		comp.add(swim);
//		comp.add(swim2);
//		comp.add(swim3);
//		comp.add(swim4);
//		
//		Sprinter sprint = new Sprinter(9, "Jessica Thornton","Sprinter", 18,"NSW", 0);
//		Sprinter sprint2 = new Sprinter(10, "Sally Pearson","Sprinter", 30,"TAS", 0);
//		Sprinter sprint3 = new Sprinter(11, "Joel Milburn","Sprinter", 31,"WA", 0);
//		Sprinter sprint4 = new Sprinter(12, "Tristan Thomas", "Sprinter", 25,"30", 0);
//		comp.add(sprint);
//		comp.add(sprint2);
//		comp.add(sprint3);
//		comp.add(sprint4);
//		
//		SuperAthlete superAth = new SuperAthlete(14, "Felicity Abram","Super", 30,"QLD", 0);
//		SuperAthlete superAth2 = new SuperAthlete(15, "Miranda Carfrae","Super", 28,"VIC", 0);
//		SuperAthlete superAth3 = new SuperAthlete(16, "Luke Bell","Super", 37," VIC", 0);
//		SuperAthlete superAth4 = new SuperAthlete(17, "Pete Jacobs","Super", 35,"NSW", 0);
//		comp.add(superAth);
//		comp.add(superAth2);
//		comp.add(superAth3);
//		comp.add(superAth4);
//				
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
