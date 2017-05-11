package application;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
//import org.junit.*;
//import static org.junit.Assert.*;


import java.util.Date;

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
	//TODO after package sep, change these from static , 
	
	public static ArrayList<Athlete> comp = new ArrayList<Athlete>(); //ArrayList containing ALL athletes
	public static ArrayList<Official> offs = new ArrayList<Official>();//Arraylist containing all officals
	
	public static ArrayList<String> done = new ArrayList<String>(); //List of Strings with past game details
	
	public static ArrayList<Athlete> competeingArray = new ArrayList<Athlete>(); //Temporary ArrayList to hold eligible athletes for an event. 
	public static ArrayList<Athlete> eventAthletes = new ArrayList<Athlete>(); //Athletes selected by user for the event
	
	public static boolean eventSet = false;
	
	

	public static Event upcoming = new Event();//This is the primary event object for each Game
	
	static PrintWriter out = null;
	
	static String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	
	public static void importData() {
	try {	

		readFile r = new readFile();
		
		r.openFile();	
		r.readFile(comp);
		r.closeFile();
		
		r.openFile();
		r.readOffsFile(offs);
		r.closeFile();
		
	}catch (Exception e) {
		System.out.println("Cannot find read file");
		}	
	}
	public static void outputFile() {//Creates a new "gameResults.txt" file to store results 
		try {
		    out = new PrintWriter (new BufferedWriter(new FileWriter("gameResults.txt", false)));//ugh
		    out.println("Ozlympic Games " + timeStamp);
		    out.print("===========================\n");
		}catch (IOException e) {
		    System.err.println(e);
		}finally{
		    if(out != null){
		        out.close();
		    }
		}
	}
	
	//TODO Rewrite this as some sort of serialization
	
	public static void updateFile() { //Appends to the results file with the last match 
		try {	
		    out = new PrintWriter(new BufferedWriter(new FileWriter("gameResults.txt", true)));	
		    
		    out.println(Ozlympic.upcoming.getCode() + ", " + Ozlympic.upcoming.getOfficial().getId() + ", " + timeStamp);
		    out.println(Ozlympic.upcoming.getWinner() + ", " + Ozlympic.upcoming.getFirstTime() + ", " + 5);
		    out.println(Ozlympic.upcoming.getSecond() + ", " + Ozlympic.upcoming.getSecondTime() + ", " + 2);
		    out.println(Ozlympic.upcoming.getThird() + ", " + Ozlympic.upcoming.getThirdTime() + ", " + 1);		    
		    
		}catch (IOException e) {
			System.out.println("Error writting to file, please check existance of gameResults.txt");
		    System.err.println(e);
		}finally{
		    if(out != null){
		        out.close();
		    }
		}
	}
	

	public static Event selectGame(int option) {
		Event currentEvent = new Event();
		switch(option) {
			case 1: currentEvent = new RunningEvent();
				currentEvent.setName("Running Event");
			eventSet = true;	
				break;					
			case 2:currentEvent = new CyclingEvent(); 
				currentEvent.setName("Cycling Event");
			eventSet = true;	
				break;
			case 3:	currentEvent = new SwimEvent();	
				currentEvent.setName("Swimming Event");
			eventSet = true;	
				break;
			default:
				System.out.println("Invalid option!");
		}
		return currentEvent;
	}
	

	

	static void finishEvent() {
		
//		if(eventSet ==false ) {
//			System.out.println("Please select an event to hold first");
////			menu(comp, upcoming, loadArray, offs, done);
//		} else {							
//			System.out.println("Official for " + upcoming.getCode() + " is " + upcoming.getOfficial().getName());
//			upcoming.runEvent(comp, upcoming, loadArray, offs);	//The event launches here
//			
//			Event finEvent = new Event();	
//			finEvent = upcoming;		
//			int winner=  finEvent.getWinnerId();
//			//Makes an new event reference to cross check the users prediction with
////			if (userPic != winner) {
////				System.out.println("");
////			} else {
////				System.out.println("Congrats! You picked the winner!");
////			}			
//		}				
//		
//		String result = new String ("========\n" + "The winner of " + (upcoming.getCode()) + " was " + (upcoming.getWinner()) + "\n" +
//				"Second place was " + (upcoming.getSecond()) + "\n" +
//				"Third place was " + (upcoming.getThird()) + "\n" + "========\n");
//		//Adds the events details (as a String) to the "done" array list
//		done.add(result);
//		
//		eventSet = false;
//		menu(comp, upcoming, loadArray, offs, done);		
		
	}

	static void displayGames(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, ArrayList<Official> offs, ArrayList<String> done) {
		
		for (int i = 0; i < done.size(); i++) {
			String test = done.get(i);
		System.out.println(test);
		} 	
		
		
	
	}

//	static void displayAthletes(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, ArrayList<Official> offs,  ArrayList<String> done) {
//		
//		for(int i = 0; i < comp.size(); i++) {			
//			Athlete currentAthlete = comp.get(i);			
//			System.out.println("=============");
//			System.out.println("Name:" +currentAthlete.getName());
//			System.out.println("Type: " + currentAthlete.getType());
//			System.out.println("Age:" +currentAthlete.getAge());
//			System.out.println("State:" +currentAthlete.getState());
//			System.out.println("Current Score:" +currentAthlete.getScore());			
//		}
//		
//		menu(comp, upcoming, loadArray, offs, done);
//	}

	public static Official pickOfficial(ArrayList<Official> offs) {
	    Random rand = new Random(); 
	    Official randomOff = offs.get(rand.nextInt(offs.size()));
	    return randomOff;
	}

}
