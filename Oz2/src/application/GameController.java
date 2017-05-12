package application;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import exceptions.GameFullException;
import exceptions.TooFewAthletesException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class GameController {
	
	@FXML
	private Button home;
	
	@FXML 
	private Button display;
	
	@FXML
	private Button add;
	
	@FXML
	private Button remove;

	@FXML
	private ChoiceBox compAth;
	
	@FXML
	private ChoiceBox inGame;
	
	@FXML
	private Button confrim;
	
	@FXML
	private ListView rightDisplay;
	
	@FXML
	private ListView leftDisplay;
	
	@FXML
	private Label info = new Label(application.Ozlympic.upcoming.getName());
		
	@FXML
	private ObservableList<String> athleteDisplay =FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> athleteAdded =FXCollections.observableArrayList();
	
	
	@FXML
	//TODO Be sure that is doesn't remove or clear any data about the Athletes or Event
	private void menu(ActionEvent event) throws IOException {
		athleteAdded.clear();
		athleteDisplay.clear();

		Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();		
	}
	
	@FXML
	private void initialize(){
		convertList();
//		compAth.setItems(athleteDisplay);
		rightDisplay.setItems(athleteDisplay);
		
	}
	
	@FXML
	private void convertList(){	 //Creates Strings based off Athlete names		
		
		for(int i = 0; i < Ozlympic.competeingArray.size(); i++) {			
			Athlete currentAthlete = Ozlympic.competeingArray.get(i);					
			String newEntry = currentAthlete.getName();
			athleteDisplay.add(newEntry);	
//			Ozlympic.competeingArray.remove(currentAthlete);
		}
		
	}
	
	@FXML
	private void confirmEvent(ActionEvent event) throws IOException {
	/*
	This copies the Athletes selected by the user into a arraylist
	in Ozlympic to run the event off
	Exceptions will be important here
	Also make sure it wont run unless there are at least 4 athletes
	 */
	try {
		if(athleteAdded.size() < 4) {
				throw new TooFewAthletesException();					
			} else {
				for(int i =0;i < Ozlympic.comp.size(); i++) {
					Athlete currentAthlete = Ozlympic.comp.get(i);	
					String name = currentAthlete.getName();
		
					if(athleteAdded.contains(name)) {		
						Ozlympic.eventAthletes.add(currentAthlete);
						}
					}
			}
				//TEST LOOP
	//			for(int i =0;i < Ozlympic.eventAthletes.size(); i++) {
	//				Athlete currentAthlete = Ozlympic.eventAthletes.get(i);
	//				System.out.println(currentAthlete.getName());
	//			}
			Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene menuPageScene = new Scene(menuPage);
			Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			thisStage.setScene(menuPageScene);
			thisStage.show();
			
	} catch (Exception TooFewAthletesException) {
		System.out.println("Exception worked");
		
//				TODO create a pop up box saying too few athletes
		
		}
	}
	@FXML
	private void populate() {
//		inGame.setItems(athleteAdded);
		leftDisplay.setItems(athleteAdded);
	}
	
	@FXML
	private void addToEvent() {		
		
		try {
			if(athleteAdded.size() > 8) {
				throw new  GameFullException(); } 
			else {
//				if (compAth.getValue()!= null) {
//				String passAthlete = compAth.getValue().toString();
//				athleteAdded.add(passAthlete);
//				int select = rightDisplay.getSelectionModel().getSelectedIndex();
				
				String test = (String) rightDisplay.getSelectionModel().getSelectedItem();
				System.out.println(test);
				
				
//				if (select != 0) {
//					System.out.println(athleteDisplay);
//					athleteAdded.add(select);
//					athleteDisplay.remove(select);
					
//					String passAthlete = compAth.getValue().toString();
					System.out.println("Worked");
					
					athleteAdded.add(test);
				
				for(int i = 0; i < athleteDisplay.size(); i++) {	
					String fromAthlete = athleteDisplay.get(i);				
					if (test.equals(fromAthlete)) {
						athleteDisplay.remove(fromAthlete);
					}
				}			
			}
			populate();//Re populates the list of eligible Athletes 					
//		}
	} catch(Exception GameFullException) {
		
		}
	}
	@FXML
	private void removeFromEvent() {		
		if (inGame.getValue()!= null) {
			String removeAthlete = inGame.getValue().toString();
			athleteAdded.remove(removeAthlete);
			athleteDisplay.add(removeAthlete);
							
		}
		populate();	
	}
	
	
	
	  
}