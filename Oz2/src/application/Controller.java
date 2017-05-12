package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.TextField;


public class Controller {
//	public static Ozlympic oz = new Ozlympic();
	
	@FXML
	private Button test;
	@FXML
	private Button quit;
	@FXML
	private Button select;
	@FXML
	private Button displayAthletes;
	@FXML
	private Button displayOfficials;
	@FXML
	private  TextArea info;
	@FXML
	private  TextArea nextEvent;
	@FXML
	private Button pastGames;
	@FXML
	private Button start;
	
	@FXML
	private void initialize() {
		displayEvent();
//		oz.importData();
		
		
	}
	
	@FXML
	private void runEvent(ActionEvent event) throws IOException {			
		if(Ozlympic.eventSet == true) {
			
		Ozlympic.upcoming.runEvent(Ozlympic.eventAthletes, Ozlympic.upcoming, Ozlympic.offs);
		Parent alertPage =FXMLLoader.load(getClass().getResource("resultsWindow.fxml"));
		Scene alertPageScene = new Scene(alertPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(alertPageScene);
		thisStage.show();	
		
		} else {
			nextEvent.setText("Please choose and event first");
		}
	}
	@FXML
	private void displayEvent(){
		if (Ozlympic.eventSet	== true) {
			info.appendText("The official of the next event is ");
			info.appendText(Ozlympic.upcoming.getOfficial().getName() + "\n");
			info.appendText("Athletes in next event are: \n");
			nextEvent.setText("Next event is: " +  Ozlympic.upcoming.getName() + "\n" +Ozlympic.upcoming.getCode());
			for(int i = 0; i < Ozlympic.eventAthletes.size(); i++) {			
				Athlete currentAthlete = Ozlympic.eventAthletes.get(i);						
				info.appendText("\nName: " +currentAthlete.getName());
						
			}
		} else {
			Ozlympic.upcoming = null; //Resets the upcoming event via "eventSet" boolean (Line 35 ResultsController.java)
//			Ozlympic.eventAthletes = null;
			nextEvent.setText("No upcoming events");
		}

	}

//
	@FXML
	private void printGames() {
		for (int i = 0; i < Ozlympic.done.size(); i++) {
			String test = Ozlympic.done.get(i);
		info.appendText(test);
		}		
	}
	
	@FXML
	private void testing(){
		if(Ozlympic.eventSet == true) {
			info.appendText(Ozlympic.upcoming.getOfficial().getName());
		} else {
			info.appendText("Please select a game first");
		}
		System.out.println("TEST BUTTON PLEASE IGNORE");
		
	}
	
	@FXML
	private void quitApp() {
		Stage stage = (Stage) quit.getScene().getWindow();
	    stage.close();
	}
	@FXML
	private void displayOfficials() { //Prints out officials stats
		info.setText("");
		for(int i = 0; i < Ozlympic.offs.size(); i++) {	
			Official currentOff = Ozlympic.offs.get(i);
			info.appendText("\nName: " + currentOff.getName());
			info.appendText("\nID:" + currentOff.getId());
			info.appendText("\n");			
		}
	}
//	private void displayOfficials() { //Prints out officials stats
//		info.setText("");
//		for(int i = 0; i < oz.offs.size(); i++) {	
//			Official currentOff = oz.offs.get(i);
//			info.appendText("\nName: " + currentOff.getName());
//			info.appendText("\nID:" + currentOff.getId());
//			info.appendText("\n");			
//		}
//	}
	@FXML
	private void displayAthletes() { //Prints out stats of all athletes
		info.setText("");
		for(int i = 0; i < Ozlympic.comp.size(); i++) {			
			info.appendText("====================\n");
			Athlete currentAthlete = Ozlympic.comp.get(i);						
			info.appendText("Name: " +currentAthlete.getName());
			info.appendText("\nID: " + currentAthlete.getId());
			info.appendText("\nSport: " + currentAthlete.getType());
			info.appendText("\nAge: " +currentAthlete.getAge());
			info.appendText("\nState: " +currentAthlete.getState());
			info.appendText("\nCurrent Score: " +currentAthlete.getScore() + "\n");			
		}
	}
//	private void displayAthletes() { //Prints out stats of all athletes
//		info.setText("");
//		for(int i = 0; i < oz.comp.size(); i++) {			
//			info.appendText("====================\n");
//			Athlete currentAthlete = oz.comp.get(i);						
//			info.appendText("Name: " +currentAthlete.getName());
//			info.appendText("\nID: " + currentAthlete.getId());
//			info.appendText("\nSport: " + currentAthlete.getType());
//			info.appendText("\nAge: " +currentAthlete.getAge());
//			info.appendText("\nState: " +currentAthlete.getState());
//			info.appendText("\nCurrent Score: " +currentAthlete.getScore() + "\n");			
//		}
//	}

	@FXML
	//THIS IS ATTACHED TO THE SELECT BUTTON
	private void choiceBox(ActionEvent event) throws IOException {
		Parent alertPage =FXMLLoader.load(getClass().getResource("EventType.fxml"));
		Scene alertPageScene = new Scene(alertPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(alertPageScene);
		thisStage.show();		
	}
}