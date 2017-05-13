package gui;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

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
import ozlympic.Athlete;
import ozlympic.Official;
import ozlympic.Ozlympic;
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
	private Button addOff;
	@FXML
	private Button removeOff;
	@FXML
	private Button confrim;	
	@FXML
	private ListView rightDisplay;
	@FXML
	private ListView leftDisplay;	
	@FXML
	private ListView offList;
	@FXML
	private ListView addedOffList;
	@FXML
	private ObservableList<String> athleteDisplay =FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> athleteAdded =FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> offArrayList =FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> offInEvent =FXCollections.observableArrayList();
	
			@FXML
			private String offString;
	
	private boolean isOffSet;
	
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
		rightDisplay.setItems(athleteDisplay);
		offList.setItems(offArrayList);
		isOffSet = false;
		
	}
	
	@FXML
	private void convertList(){	 //Creates Strings based off Athlete names		
		
		for(int i = 0; i < Ozlympic.eligableAthletes.size(); i++) {			
			Athlete currentAthlete = Ozlympic.eligableAthletes.get(i);					
			String newEntry = currentAthlete.getName();
			athleteDisplay.add(newEntry);	
//			Ozlympic.competeingArray.remove(currentAthlete);
		}
		
		for(int j=0;j<Ozlympic.offs.size();j++) { // Strings of Official names for selection
			Official currOff = Ozlympic.offs.get(j);
			String newEntry = currOff.getName();
			offArrayList.add(newEntry);
//			System.out.println(newEntry);
		}
		
	}
	@FXML
	private void confirmEvent(ActionEvent event) throws ExceptionAlert {
	
//	This copies the Athletes selected by the user into a arraylist in Ozlympic to run the event off
		try {
			if(isOffSet == false) {
				throw new ExceptionAlert("Please select an Official");
			} else { 
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
						matchOfficial();
						Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
						Scene menuPageScene = new Scene(menuPage);
						Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						thisStage.setScene(menuPageScene);
						thisStage.show();
						
				} catch (Exception ExceptionAlert) {
						} 
			}
		} catch (Exception ExceptionAlert) {
			
		}
	}
	@FXML
	private void populate() {
//		inGame.setItems(athleteAdded);
		leftDisplay.setItems(athleteAdded);
		addedOffList.setItems(offInEvent);
		
//		addedOffList.setItems(offString);
		
		
		
	}
	@FXML
	private void addOfficialToEvent(){		
		try {
			if(isOffSet == true) {
				throw new ExceptionAlert("Game already has an official"); } 
			else {				
				String selectedString = (String) offList.getSelectionModel().getSelectedItem();
					
				if(selectedString != null) {
					offInEvent.add(selectedString);
//					offString = selectedString;
				
					for(int i = 0; i < offArrayList.size(); i++) {	
						String fromOfficial = offArrayList.get(i);				
						if (selectedString.equals(fromOfficial)) {
							offArrayList.remove(fromOfficial);
						}
					}
				}	
			} isOffSet = true;
			
			populate();//Re populates the list of eligible Athletes and official					
//		}
	} catch(Exception ExceptionAlert) {
			
		}
	}
	@FXML
	private void addToEvent() {		
		
		try {
			if(athleteAdded.size() > 7) {
				throw new ExceptionAlert("Game is full. Please add between 4 and 8 athletes"); } 
			else {				
				String selectedString = (String) rightDisplay.getSelectionModel().getSelectedItem();
					
				if(selectedString != null) {
					athleteAdded.add(selectedString);
				
				
					for(int i = 0; i < athleteDisplay.size(); i++) {	
						String fromAthlete = athleteDisplay.get(i);				
						if (selectedString.equals(fromAthlete)) {
							athleteDisplay.remove(fromAthlete);
						}
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
		if(selectedString != null) { 
			athleteAdded.remove(selectedString);
			athleteDisplay.add(selectedString);	
			populate();	
		}
	}
	@FXML
	private void removeOffFromEvent() {	

		String selectedString = (String) addedOffList.getSelectionModel().getSelectedItem();
		if(selectedString != null) { 
			offInEvent.remove(selectedString);
			offArrayList.add(selectedString);	
			isOffSet = false;
			populate();	
		}
	}
	private void matchOfficial() {
		
		for(int i =0;i < Ozlympic.offs.size(); i++) {
			
			Official loopOff = Ozlympic.offs.get(i);	
			String name = loopOff.getName();					
			
			for(int j =0; j < offInEvent.size(); j++) {
				String obName = offInEvent.get(j);
					if(obName == name){
					Ozlympic.upcoming.setOfficial(loopOff);
										
				}
			}
		}
		
		
		
	}
	
	
	  
}