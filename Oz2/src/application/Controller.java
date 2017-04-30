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


public class Controller {
	public Ozlympic oz = new Ozlympic();

	@FXML
	private Button test;
	@FXML
	private Button quit;
	@FXML
	private Button displayAthletes;
	@FXML
	private  TextArea info;
	
	@FXML
	private void initialize() {
		oz.importData();
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
	private void displayAthletes() { //Prints out stats of all athletes
		for(int i = 0; i < oz.comp.size(); i++) {			
			Athlete currentAthlete = oz.comp.get(i);			
			info.appendText("\n");
			info.appendText("\nName: " +currentAthlete.getName());
			info.appendText("\nType: " + currentAthlete.getType());
			info.appendText("\nAge: " +currentAthlete.getAge());
			info.appendText("\nState: " +currentAthlete.getState());
			info.appendText("\nCurrent Score: " +currentAthlete.getScore() + "\n");
//		oz.info();
//		info.setText("String");		
		}
	}
	

//	
//	public void testClick(){
//		button1.setOnAction(e -> {
//			System.out.println("dasd");
//			label1.setText("fg");
//		});
//	} 

	  
}