package application;

import java.io.IOException;
import java.util.ResourceBundle;

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
	private ChoiceBox compAth;
	
	@FXML
	private ChoiceBox inGame;
	
	@FXML
	private Label info = new Label(application.Ozlympic.upcoming.getName());
		
	@FXML
	private ObservableList<String> athleteDisplay =FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> athleteAdded =FXCollections.observableArrayList();
	
	
	@FXML
	//TODO Be sure that is doesn't remove or clear any data about the Athletes or Event
	private void menu(ActionEvent event) throws IOException {
		Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();		
	}
	
	@FXML
	private void initialize(){
		convertList();
		compAth.setItems(athleteDisplay);
	}
	
	@FXML
	private void convertList(){
		for(int i = 0; i < Ozlympic.competeingArray.size(); i++) {			
			Athlete currentAthlete = Ozlympic.competeingArray.get(i);					
			String newShit = currentAthlete.getName();
			athleteDisplay.add(newShit);				
		}
		
	}
	
	@FXML
	private void populate() {
		inGame.setItems(athleteAdded);

	}
	
	@FXML
	private void addToEvent() {		
		if (compAth.getValue()!= null) {
			String passAthlete = compAth.getValue().toString();
			athleteAdded.add(passAthlete);
			
			for(int i = 0; i < athleteDisplay.size(); i++) {	
				String fromAthlete = athleteDisplay.get(i);				
				if (passAthlete.equals(fromAthlete)) {
					athleteDisplay.remove(fromAthlete);
				}
			}
			
			populate();
		
			
		}
		
	}

	
	
	
	  
}