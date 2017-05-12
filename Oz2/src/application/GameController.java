package application;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import app.Athlete;
import app.Ozlympic;
import exceptions.ExceptionAlert;
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
	private Button confrim;
	
	@FXML
	private ListView rightDisplay;
	
	@FXML
	private ListView leftDisplay;
	
	
		
	@FXML
	private ObservableList<String> athleteDisplay =FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> athleteAdded =FXCollections.observableArrayList();
	
	
	@FXML
	private void menu(ActionEvent event) throws IOException {
		
		athleteAdded.clear();
		athleteDisplay.clear();
		Ozlympic.eventSet = false;
		Ozlympic.eligableAthletes.clear();

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
		
		for(int i = 0; i < Ozlympic.eligableAthletes.size(); i++) {			
			Athlete currentAthlete = Ozlympic.eligableAthletes.get(i);					
			String newEntry = currentAthlete.getName();
			athleteDisplay.add(newEntry);	
//			Ozlympic.competeingArray.remove(currentAthlete);
		}
		
	}
	
	@FXML
	private void confirmEvent(ActionEvent event) throws ExceptionAlert {
	
//	This copies the Athletes selected by the user into a arraylist in Ozlympic to run the event off
	
	try {
		if(athleteAdded.size() < 4) {
				throw new ExceptionAlert("Please add at least 4 athletes to compete");					
			} else {
				
				for(int i =0;i < Ozlympic.comp.size(); i++) {
					Athlete currentAthlete = Ozlympic.comp.get(i);	
					String name = currentAthlete.getName();					
					for(int j =0; j < athleteAdded.size(); j++) {
						String obName = athleteAdded.get(j);
							if(obName == name){
							Ozlympic.eventAthletes.add(currentAthlete);							
						}
					}
				}
			}
				//TEST LOOP
//				for(int i =0;i < Ozlympic.eventAthletes.size(); i++) {
//					Athlete currentAthlete = Ozlympic.eventAthletes.get(i);
//					System.out.println("EventAthlete " + currentAthlete.getName());
//				}
				
			Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene menuPageScene = new Scene(menuPage);
			Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			thisStage.setScene(menuPageScene);
			thisStage.show();
			
	} catch (Exception ExceptionAlert) {
		
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
			if(athleteAdded.size() > 7) {
				throw new ExceptionAlert("Game is full. Please add between 4 and 8 athletes"); } 
			else {

				
				String selectedString = (String) rightDisplay.getSelectionModel().getSelectedItem();
//				System.out.println(selectedString);
				
					
					athleteAdded.add(selectedString);
				
				for(int i = 0; i < athleteDisplay.size(); i++) {	
					String fromAthlete = athleteDisplay.get(i);				
					if (selectedString.equals(fromAthlete)) {
						athleteDisplay.remove(fromAthlete);
					}
				}			
			}
			populate();//Re populates the list of eligible Athletes 					
//		}
	} catch(Exception ExceptionAlert) {
			
		}
	}
	@FXML
	private void removeFromEvent() {	

		String selectedString = (String) leftDisplay.getSelectionModel().getSelectedItem();
		
		athleteAdded.remove(selectedString);
		athleteDisplay.add(selectedString);	
		populate();	
	}
	
	
	
	  
}