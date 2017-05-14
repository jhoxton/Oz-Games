package ozlympic;
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
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



import java.util.Date;

import filio.readFile;
import filio.sql;

/**
 * Advanced Programming Semester 1 2017 Assignment 2
 *
 * @author Jake Novak s3609685
 *
 * github: github.com/jhoxton/AP
 *
 */

	public class Ozlympic extends Application {
		
//		public sql sqlDB = new sql();
		
		public static ArrayList<Athlete> comp = new ArrayList<Athlete>(); //ArrayList containing ALL athletes
		public static ArrayList<Official> offs = new ArrayList<Official>();//Arraylist containing all officals		
		public static ArrayList<String> done = new ArrayList<String>(); //List of Strings with past game details
		public static ArrayList<Athlete> eligableAthletes = new ArrayList<Athlete>(); //Temporary ArrayList to hold eligible athletes for an event. 
		public static ArrayList<Athlete> eventAthletes = new ArrayList<Athlete>(); //Athletes selected by user for the event
		public static boolean eventSet = false; //To check if the Event has all the info it needs to run
		public static Event upcoming = new Event();//This is the primary event object for each Game		
		static PrintWriter out = null;
		static String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());		
		public static Stage primaryStage;
		
		public static sql sqlDB = new sql();

		public void primaryStage() throws IOException { //Sets up the primary stage
			
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/Menu.fxml"));
				Scene scene = new Scene(root,490,400);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();	
		}

		@Override
		public void start(Stage primaryStage) {
			try {	
				this.primaryStage = primaryStage;
				this.primaryStage.setTitle("Ozlympic Games");			
				primaryStage();		
			}	catch(Exception e) {
					e.printStackTrace();
			}
		}
		
		
		public static void main(String[] args) {	
		
		Ozlympic.outputFile();//Makes a new "gameResults.txt" file in Ozlympic
		
//		Ozlympic.importData();
		
//		ADD A FUCKING IF ELSE CAUSE HERE YOU DOOZY CUNT
		
		sqlDB.selectAll();


		
			launch(args);	
		}

	
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
		    out.println("");
		    
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
	

	

	public static void finishEvent() {

	
		String result = new String ("========\n" + 
				"The winner of " + (upcoming.getCode()) + " was " + (upcoming.getWinner()) + "\n" +
				"Second place was " + (upcoming.getSecond()) + "\n" +
				"Third place was " + (upcoming.getThird()) + "\n" +
				"The overseeing official was " + (upcoming.getOfficial().getName() + "" + (upcoming.getOfficial().getId())));
		//Adds the events details (as a String) to the "done" array list
		done.add(result);

	
		
	}

	static void displayGames(ArrayList<Athlete> comp, ArrayList<Athlete> loadArray, ArrayList<Official> offs, ArrayList<String> done) {
		
		for (int i = 0; i < done.size(); i++) {
			String test = done.get(i);
		System.out.println(test);
		} 	

	}


}
