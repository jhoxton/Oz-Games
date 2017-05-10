package application;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.collections.ObservableList;

import java.util.*;
//import org.junit.*;
//import static org.junit.Assert.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

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
	
	public static void importData() {
	try {	
		
	
//		ArrayList<Athlete> comp = new ArrayList<Athlete>(); 
//		ArrayList<Official> offs = new ArrayList<Official>();// Arraylist of Officials. And, yes I know it's spelled wrong
		readFile r = new readFile();
		
		r.openFile();	
		r.readFile(comp);
		r.closeFile();
		
		r.openFile();
		r.readOffsFile(offs);
		r.closeFile();

//		TODO: Add exception catches 
		
	}catch (Exception e) {
		System.out.println("Cannot find read file");
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
	

	
//	static void selectGame(int option, ArrayList<Athlete> comp, Event upcoming, ArrayList<Athlete> loadArray, ArrayList<Official> offs, ArrayList<String> done) {
//	
//
//		
////		USE THIS CODE TO WRITE A METHOD THAT RETURNS THE CORRECT TYPE OF ATHLETE
////		THEN USE THE REST TO RUN THE MATCH, AFTER USER HAS SELECTED THE CORRECT TYPES
//		
//		
//		Event currentEvent = new Event();		
//	
//		System.out.println("Select event to hold:\n1) Swimming Event\n2) Sprinting Event\n3) Cycling Event");
//
//		loadArray = comp;
//		
//		System.out.println(loadArray.size()); //Tests the loadArray is correct and that no athletes have been removed 
//		
//			if(option == 1) {				
//				currentEvent = new SwimEvent();
//				eventSet = true;				
//				ArrayList<Athlete> returningArray = new ArrayList<Athlete>(); 			
//				returningArray = currentEvent.loadEvent(loadArray);//Calls the "loadEvent" method which determines if athletes are eligible to compete 
//				loadArray = returningArray;				
//
//				System.out.println("The competeing athletes are: \n" );
//				for(int i = 0; i < loadArray.size(); i++) {
//					Athlete currentAthlete = loadArray.get(i);
//					System.out.println(currentAthlete.getName());
//				}
//				
//			} else if(option ==2) {				
//				currentEvent = new RunningEvent();
//				eventSet = true;				
//				ArrayList<Athlete> returningArray = new ArrayList<Athlete>(); 			
//				returningArray = currentEvent.loadEvent(loadArray); 
//				loadArray = returningArray;				
//
//				System.out.println("The competeing athletes are " );
//				for(int i = 0; i < loadArray.size(); i++) {
//					Athlete currentAthlete = loadArray.get(i);
//					System.out.println(currentAthlete.getName());
//				}				
////				System.out.println(returningArray); //This tests the correct array was returned 
//	
//			} else if (option ==3) {
//				currentEvent = new CyclingEvent();
//				eventSet = true;				
//				ArrayList<Athlete> returningArray = new ArrayList<Athlete>(); 			
//				returningArray = currentEvent.loadEvent(loadArray); 
//				loadArray = returningArray;				
//
//				System.out.println("The competeing athletes are " );
//				for(int i = 0; i < loadArray.size(); i++) {
//					Athlete currentAthlete = loadArray.get(i);
//					
//					
//					
//					
//					
//					System.out.println(currentAthlete.getName());
//				}
//			} else {
//				System.out.println("Please select an event to hold");
//			}
//			
//			currentEvent = upcoming;
//
//			Official test = pickOfficial(offs);
//			System.out.println("Overseeing Official is: " + test.getName());
//			upcoming.setOfficial(test);
//			//Assigns an Official to a game
//
////			menu(comp, upcoming, loadArray, offs, done); 
//			return;		
//	} 
	
//	static void predictGame(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, Event upcoming, ArrayList<Official> offs, ArrayList<String> done) {
//		
//		if(eventSet ==false ) {
//			System.out.println("Please select an event to hold first");			
//			menu(comp, upcoming, loadArray, offs, done);
//		} else {		
//			for (int i=0; i < loadArray.size(); i++) {			
//				Athlete loopAth = loadArray.get(i);		
//				System.out.println("Name: " + loopAth.getName()+ "\nID: " + loopAth.getId()+  "\n======== ");	
//			}
//			System.out.println("Enter ID of athlete you predict will win: ");
//			Random input;
//			userPic = 10;
//			menu(comp, upcoming, loadArray, offs, done);
//		}		
//	}
	
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
		String result = new String ("========\n" + "The winner of " + (upcoming.getCode()) + " was " + (upcoming.getWinner()) + "\n" +
				"Second place was " + (upcoming.getSecond()) + "\n" +
				"Third place was " + (upcoming.getThird()) + "\n" + "========\n");
		//Adds the events details (as a String) to the "done" array list
		done.add(result);
		
		eventSet = false;
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
