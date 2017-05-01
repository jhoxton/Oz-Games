package application;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.TextField;


public class Controller {
	private Ozlympic oz = new Ozlympic();
	
	@FXML
	private Button test;
	@FXML
	private Button quit;
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
	private void initialize() {
		displayEvent();
//		Ozylmpic.importData();
		oz.importData();
	}
	@FXML
	private void displayEvent(){
		if (oz.eventSet == true) {
			nextEvent.setText("The next event is: " +  oz.upcoming.getName());
		} else {
			nextEvent.setText("No upcoming events");
		}
	}
	@FXML
	private void printGames() {
		for (int i = 0; i < oz.done.size(); i++) {
			String test = oz.done.get(i);
		info.appendText(test);
		}		
	}
	
	@FXML
	private void testing(){
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
		for(int i = 0; i < oz.offs.size(); i++) {	
			Official currentOff = oz.offs.get(i);
			info.appendText("\nName: " + currentOff.getName());
			info.appendText("\nID:" + currentOff.getId());
			info.appendText("\n");
			
		}
	}
	@FXML
	private void displayAthletes() { //Prints out stats of all athletes
		info.setText("");
		for(int i = 0; i < oz.comp.size(); i++) {			
			Athlete currentAthlete = oz.comp.get(i);						
			info.appendText("\nName: " +currentAthlete.getName());
			info.appendText("\nID: " + currentAthlete.getId());
			info.appendText("\nType: " + currentAthlete.getType());
			info.appendText("\nAge: " +currentAthlete.getAge());
			info.appendText("\nState: " +currentAthlete.getState());
			info.appendText("\nCurrent Score: " +currentAthlete.getScore() + "\n");

		}
	}

	  
}